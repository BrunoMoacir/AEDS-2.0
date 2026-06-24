#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


typedef struct
{
    int ano, mes, dia;
} Data;

typedef struct
{
    int hora, minuto;
} Hora;

typedef struct
{
    int id;
    char *nome; // string
    char *cidade;
    int capacidade;
    double avaliacao;

    int n_tipos_cozinha;
    char **tipos_cozinha; // array de strings

    int faixa_preco;
    Hora horario_abertura;
    Hora horario_fechamento;
    Data data_abertura;
    bool aberto;
} Restaurante;

typedef struct
{
    int tamanho;                // contador de restaurantes
    Restaurante **restaurantes; // array de ponteiros restaurantes
} Colecao_Restaurantes;

// variaveis globais
int comparacoes = 0;
int movimentacoes = 0;

int tamanho_string(const char *s)
{ // funcao para contar letras
    int i = 0;
    while (s[i] != '\0')
        i++; // vou de letra em letra ate o '\0'
    return i;
}

char *clonar_string(const char *s)
{
    int tam = tamanho_string(s);

    char *copia = (char *)malloc(tam + 1); // +1 por causa do '\0'

    for (int i = 0; i < tam; i++)
    {
        copia[i] = s[i]; // copio letra por letra
    }
    copia[tam] = '\0'; // fecho a string
    return copia;
}

int comparar_strings(const char *s1, const char *s2)
{
    int i = 0;
    while (s1[i] != '\0' && s2[i] != '\0')
    {
        // O SEGREDO: Forçar o C a ler a letra como um número positivo (igual o Java faz)
        unsigned char c1 = (unsigned char)s1[i];
        unsigned char c2 = (unsigned char)s2[i];
        
        if (c1 != c2)
            return c1 - c2; // Agora as palavras com acento vão para o lado certo!
        i++;
    }
    
    // Tem que fazer o mesmo na hora de retornar a diferença final
    return (unsigned char)s1[i] - (unsigned char)s2[i];
}

int string_para_int(const char *str)
{
    int resultado = 0;
    int sinal = 1;
    int i = 0;

    if (str[0] == '-')
    { // se o numero for negativo ajusto o sinal e pulo o traco
        sinal = -1;
        i++;
    }

    while (str[i] != '\0' && str[i] >= '0' && str[i] <= '9')
    { // vou multiplicando por 10 para empurrar as casas decimal e soma o novo numero
        resultado = (resultado * 10) + (str[i] - '0');
        i++;
    }
    return resultado * sinal;
}

double string_para_double(const char *str)
{
    double resultado = 0;
    double fator_decimal = 1.0;
    int i = 0;

    while (str[i] != '\0' && str[i] != '.')
    {
        resultado = (resultado * 10.0) + (str[i] - '0'); // pego a parte inteira -> antes do ponto
        i++;
    }

    if (str[i] == '.')
    { // se achei um ponto pego a parte decimal
        i++;
        while (str[i] != '\0' && str[i] >= '0' && str[i] <= '9')
        {
            fator_decimal /= 10.0; // 0.1 0.01
            resultado = resultado + (str[i] - '0') * fator_decimal;
            i++; // incremento
        }
    }
    return resultado;
}

char **extrair_campos(char *str, char sep, int *count)
{
    int qtd = 1;
    // primeiro pego quantos separadores tem para saber o tamanho do array resultante
    for (int i = 0; str[i] != '\0'; i++)
    {
        if (str[i] == sep)
            qtd++;
    }

    *count = qtd;
    char **partes = (char **)malloc(qtd * sizeof(char *)); // cria o array das gavetas
    int idx = 0;

    char buffer[500] = {0}; // uma variavel tmp para ir montando a palavra letra por letra
    int buf_idx = 0;

    for (int i = 0;; i++)
    {
        // ignoro o \r e \n
        if (str[i] == sep || str[i] == '\0' || str[i] == '\r' || str[i] == '\n')
        {
            buffer[buf_idx] = '\0';                // quando acho o separador coloco o \0
            partes[idx++] = clonar_string(buffer); // clono o que juntei e salva no array
            buf_idx = 0;                           // limpo o buffer para comecar a montar a próxima palavra

            // s oque parou foi o final paro
            if (str[i] == '\0' || str[i] == '\r' || str[i] == '\n')
                break;
        }
        else
        {
            // se for letra normal continuo jogando
            buffer[buf_idx++] = str[i];
        }
    }
    return partes;
}

Data parse_data(char *s)
{
    Data d;
    sscanf(s, "%d-%d-%d", &d.ano, &d.mes, &d.dia); // sscanf
    return d;
}

Hora parse_hora(char *s)
{
    Hora h;
    sscanf(s, "%d:%d", &h.hora, &h.minuto);
    return h;
}

Restaurante *parse_restaurante(char *s)
{
    Restaurante *r = (Restaurante *)malloc(sizeof(Restaurante)); // crio na memoria

    int count = 0;
    char **p = extrair_campos(s, ',', &count); // pico a linha inteira nas virgulas
    r->id = string_para_int(p[0]);
    r->nome = clonar_string(p[1]);
    r->cidade = clonar_string(p[2]);
    r->capacidade = string_para_int(p[3]);
    r->avaliacao = string_para_double(p[4]);

    int coz_count = 0;
    // pego a parte de cozinhas na posicao 5 e pico pelo ;
    r->tipos_cozinha = extrair_campos(p[5], ';', &coz_count);
    r->n_tipos_cozinha = coz_count; // guardo quantos tipos tem

    r->faixa_preco = tamanho_string(p[6]); //

    int h_count = 0;
    char **horas = extrair_campos(p[7], '-', &h_count); // corto o horario corretamente
    r->horario_abertura = parse_hora(horas[0]);
    r->horario_fechamento = parse_hora(horas[1]);

    r->data_abertura = parse_data(p[8]);

    // assumo q ta fechado, mas se tiver a letra t no texto mudo para aberto
    r->aberto = false;
    for (int i = 0; p[9][i] != '\0'; i++)
    {
        if (p[9][i] == 't' || p[9][i] == 'T')
        {
            r->aberto = true;
            break;
        }
    }

    return r;
}

void formatar_data(Data *data, char *buffer)
{
    sprintf(buffer, "%02d/%02d/%04d", data->dia, data->mes, data->ano); // sprintf
}

void formatar_hora(Hora *hora, char *buffer)
{
    sprintf(buffer, "%02d:%02d", hora->hora, hora->minuto); // sprintf
}

void formatar_restaurante(Restaurante *r, char *buffer)
{
    char tc[500] = "["; // array para caber todas cozinhas
    int pos = 1;
    // copio letra por letra de cada cozinha p dentro do tc
    for (int i = 0; i < r->n_tipos_cozinha; i++)
    {
        int t = tamanho_string(r->tipos_cozinha[i]);
        for (int j = 0; j < t; j++)
        {
            tc[pos++] = r->tipos_cozinha[i][j];
        }
        if (i < r->n_tipos_cozinha - 1)
            tc[pos++] = ','; // se nao for a ultima poe virgula
    }
    tc[pos++] = ']';
    tc[pos] = '\0'; // fechamento string

    char fp[10] = "";
    for (int i = 0; i < r->faixa_preco; i++)
        fp[i] = '$';
    fp[r->faixa_preco] = '\0';

    char h_ab[10], h_fe[10], d_ab[20];
    formatar_hora(&r->horario_abertura, h_ab);
    formatar_hora(&r->horario_fechamento, h_fe);
    formatar_data(&r->data_abertura, d_ab);

    char *status_aberto; // guardo o texto do status

    if (r->aberto == true)
    {
        status_aberto = "true";
    }
    else
    {
        status_aberto = "false";
    }

    // formatacao final
    sprintf(buffer, "[%d ## %s ## %s ## %d ## %.1f ## %s ## %s ## %s-%s ## %s ## %s]",
            r->id, r->nome, r->cidade, r->capacidade, r->avaliacao, tc, fp,
            h_ab, h_fe, d_ab, status_aberto);
}

Restaurante* buscarPorId(Colecao_Restaurantes *col, int id) {
    for (int i = 0; i < col->tamanho; i++) {
        if (col->restaurantes[i]->id == id) {
            return col->restaurantes[i]; // retorno o ponteiro qnd acho
        }
    }
    return NULL;
}


void ler_csv_colecao(Colecao_Restaurantes *colecao, char *path)
{
    FILE *file = fopen(path, "r"); // r-> read arquivo

    if (!file)
    {
        printf("Erro ao abrir arquivo.\n");
        return;
    }

    char linha[1000];                  // guardo a linha q to lendo
    fgets(linha, sizeof(linha), file); // leio o cabecalho

    while (fgets(linha, sizeof(linha), file))
    { // pego a linha inteira com o fgets
        if (tamanho_string(linha) > 2)
        {
            // salvo o restaurante parseado e depois somo +1 no tamanho
            colecao->restaurantes[colecao->tamanho++] = parse_restaurante(linha);
        }
    }
    fclose(file);
}

typedef struct Celula {
    Restaurante *elemento;
    struct Celula *prox; // aponta pro prox
} Celula;

void inserirNaListaOrdenada(Celula *primeira, Restaurante *r) {
    Celula *i = primeira;
    
    // navego pela lista enquanto o nome que to olhando for "menor
    while (i->prox != NULL && comparar_strings(r->nome, i->prox->elemento->nome) > 0) {
        i = i->prox;
    }
    
    // achei o espaco crio o vagao e engato ele
    Celula *nova = (Celula*)malloc(sizeof(Celula));
    nova->elemento = r;
    nova->prox = i->prox;
    i->prox = nova;
}

void pesquisarNaLista(Celula *i, char *nome) {
    while (i != NULL) {
        comparacoes++; 
        
        //calculo a diferenca alfabeta
        int cmp = comparar_strings(nome, i->elemento->nome);

        if (cmp < 0) {
            break; 
        }

        // imprimo o rastro
        printf("%s ", i->elemento->nome);

        if (cmp == 0) {
            char buffer[1000];
            formatar_restaurante(i->elemento, buffer);
            printf("SIM %s\n", buffer); 
            return;
        }

        i = i->prox; 
    }
    
    printf("NAO\n");
}


typedef struct No {
    unsigned char letra; 
    Celula *primeira;    // o no cabeca 
    struct No *esq, *dir;
} No;

No* raiz = NULL;

No* inserirNaArvore(No *no, Restaurante *r) {
    // pego so a primeira letra pra navegar
    unsigned char letra_inicial = (unsigned char)r->nome[0]; 

    if (no == NULL) {
        // crio a gaveta da letra se ela n existir
        no = (No*)malloc(sizeof(No));
        no->letra = letra_inicial;
        no->esq = NULL;
        no->dir = NULL;
        
        // crio o no cabeca vazio
        no->primeira = (Celula*)malloc(sizeof(Celula)); 
        no->primeira->prox = NULL;

        // coloco o primeiro restaurante na lista que acabei de criar
        inserirNaListaOrdenada(no->primeira, r); 
        
    } else if (letra_inicial < no->letra) {
        no->esq = inserirNaArvore(no->esq, r); // vou pra esquerda
    } else if (letra_inicial > no->letra) {
        no->dir = inserirNaArvore(no->dir, r); // vou pra direita
    } else {
        inserirNaListaOrdenada(no->primeira, r);
    }
    
    return no;
}

void pesquisarRec(No *no, char *nome) {
    unsigned char letra_inicial = (unsigned char)nome[0];

    if (no == NULL) {
        printf("NAO\n"); // arvore acabou e a letra n existia
    } else {
        comparacoes++;
        
        if (letra_inicial == no->letra) {
            // Achei o no da letra do restaurante
            pesquisarNaLista(no->primeira->prox, nome);
        } else if (letra_inicial < no->letra) {
            printf("ESQ ");
            pesquisarRec(no->esq, nome);
        } else {
            printf("DIR ");
            pesquisarRec(no->dir, nome);
        }
    }
}

void pesquisar(char *nome) {
    printf("RAIZ "); // comeco a rastrear os ponteiros da arvore em maiusculo
    pesquisarRec(raiz, nome);
}

int main() {
    Colecao_Restaurantes col;
    col.tamanho = 0;
    col.restaurantes = (Restaurante **)malloc(1000 * sizeof(Restaurante *));
    
    ler_csv_colecao(&col, "/tmp/restaurantes.csv");

    char entrada[200];

    // insercao
    while (scanf(" %s", entrada) == 1) {
        if (comparar_strings(entrada, "FIM") == 0 || comparar_strings(entrada, "-1") == 0) {
            break;
        }

        int id = string_para_int(entrada); 
        Restaurante *r = buscarPorId(&col, id); 
        
        if (r != NULL) {
            raiz = inserirNaArvore(raiz, r);
        }
    }

    // pesquisa
    while (scanf(" %[^\n\r]", entrada) == 1) { 
        if (comparar_strings(entrada, "FIM") == 0) {
            break;
        }

        pesquisar(entrada);
    }

    // log
    FILE *log = fopen("885492_hibrida_arvore_lista.txt", "w");
    if (log != NULL) {
        fprintf(log, "885492\t%d\t0\n", comparacoes);
        fclose(log);
    }

    return 0;
}
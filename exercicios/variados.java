// lista de pilhas-> contar o total de elementos
public int totalElementos(){
    int total = 0;// contagem de elementos
    for(CelulaLista i = inicio; i != null; i = i.prox){// percorro a lista (cada no tem uma pilha)

        CelulaPilha p = i.topo;// pego o topo da pilha atual

        while(p != null){// percorro ela
            total ++;// conto os elementos
            p = p.prox;// avanco
        }
    }
    return total;// retorno total
}

// lista de pilhas -> retornar a pilha com mais elementos
public int maiorPilha(){
    CelulaLista resp = inicio;// guarda a pilha com maior tamanho

    int maior = 0;// guarda o tamanho da maior pilha

    for(CelulaLista i = inicio; i != null; i = i.prox){// percorro a lista
        int cont = 0;// contador de elementos da pilha
        CelulaPilha p = i.topo;// pego o primeiro elemento da pilha

        while(p != null){// conto os elementos da pilha
            cont++;
            p = p.prox;
        }
        if(cont > maior){// se a contagem for maior que a contagem da maior pilha eu faco a troca
            resp = p;
            maior = cont;
        }
    }
    return resp;
}

// fazer um metodo de inserir no fim na lista dupla circular
public void inserirFim(int x){
    CelulaDupla* nova = novaCelulaDupla(x);// crio uma nova celula

    CelulaDupla* ultimo = primeiro->ant;//pego o ultimo (na fila circular ele fica atras do primeiro)

    nova->prox = primeiro;// nova aponta para o primeiro
    nova->ant = ultimo;// nova aponta pro antigo ultimo

    ultimo->prox = nova;// antigo ultimo aponta pra nova
    primeiro->ant = nova;// primeiro aponta de volta para a nova
}

// contar os numeros pares na matriz flexivel
public int contaPares(){
    int count = 0;
    CelulaLinhaAtual = inicio;

    for(int i = 0; i < linha.; i++){
        Celula colunaAtual = linha;
        for(int j = 0;j < coluna; j++){
            if(i.elemento % 2 == 0){
                count ++;
            }
            colunaAtual = colunaAtual.dir;
        }
        linhaAtual = linhaAtual.inf;
    }
    return count;
}

// na lista dupla, remover todos os elementos negativos (primeiro,ultimo,prox,ant)
public void removeNegativos(){
    CelulaDupla i = primeiro.prox;// pego o primeiro elemento depois da cabeça

    while(i != null){// varro ela toda
        if(i.elemento < 0){// s o elemento for menor que 0
            i.ant.prox = i.prox;

            if(i.prox == null){
                i.prox.ant = i.ant;
            }else{
                ultimo = i.ant;// se era o ultimo
            }
        }
        i = i.prox;
    }
}

// na matriz flexivel, somar apenas as bordas(inicio,inf,sup,dir,esq)
public int somaBorda(){
    int soma = 0;

    Celula linha = inicio;
    int i = 0;
    while(linha != null){
        Celula col = linha;
        int j = 0;

        while(col != null){
            if(i == 0 || i == this.linha - 1|| j == 0 || j == this.linha - 1){
                soma+= col.elemento;
            }
            col = col.dir;
            j++;
        }
        linha = linha.inf;
        i++;
    }
    return soma;
}

// na matriz flexivel, encontrar o maior elemento
public int maiorElemento(){
    Celula linha = inicio;

    int maior = inicio.elemento;

    while(linha != null){

        Celula col = linha;

        while(col != null){
            if(col.elemento > maior){
                maior = col.elemento;
            }
            col = col.dir;
        }
        linha = linha.inf;
    }
    return maior;
}

// lista de matrizes, somo todos os elementos de todas as matrizes-> lista(primeiro,ultimo,prox) matriz(inicio,elemento,esq,inf,dir,sup)
public int somaMatrizes(){
    int soma = 0 ;

    for(CelulaLista i = inicio; i != null; i = i.prox){

        Matriz m = i.matriz;

        Celula linha = m.inicio;

        while(linha != null){
            Celula col = linha;

            while(col != null){
                soma += col.elemento;
                col = col.dir;
            }
            linha = linha.inf;
        }
    }
    return soma;
}

// lista de pilhas -> contar quantas pilhas estao vazias
public int contVazias(){
    int count = 0;

    for(Celula i = inicio; i != null; i = i.prox){
        if(i.topo == null){
            count ++;
        }
}

//lista de pilhas -> contar quantas pilhas tem mais de 3 elementos
public int cont3Elementos(){
    int resp = 0;

    for(Celula i = inicio; i != null; i = i.prox){
        int count = 0;

        CelulaPilha p = i.topo;

        while(p != null){
            count ++;
            p = p.prox;
        }
        if(count > 3){
            resp ++;
        }
    }
    return resp;
}

// lista dupla -> somas elementos cujos valores estejam entre 10 e 50(primeiro,ultimo,prox,ant)
public int somaElementos(){
    int soma = 0;

    for(CelulaDupla i = inicio.prox; i != null; i = i.prox){
        if(i.elemento > 9 && i.elemento < 51){
            soma += i.elemento;
        }
    }
    return soma;
}

// matriz flexivel -> somar apenas elementos impares(inicio,dir,esq,inf,sup)
public int somaImpares(){
    int soma = 0;

    Celula linha = inicio;
    while(linha != null){
        Celula col = linha;
        while(col != null){
            if(col.elemento % 2 != 0){
                soma += col.elemento;
            }
            col = col.dir;
        }
        linha = linha.inf;
    }
    return soma;
}

// matriz flexivel -> verificar se existe um numero x (busca)
public boolean existe(int x){
    boolean presente = falso;

    Celula linha = inicio;
    while(linha != null){
        Celula col = linha;
        while(col != null){
            if(col.elemento == x){
                presente = true;
            }
            col = col.dir;
        }
        linha = linha.inf;
    }
    return presente;
}

// lista de matrizes -> contar quantos pares tem
public int contaPares(){
    int count = 0;
    for(CelulaLista i = inicio; i != null; i = i.prox){
        Matriz m = i.matriz;

        Celula linha = m.inicio;
        while(linha != null){
            Celula col = linha;
            while(col != null){
                if(col.elemento % 2 == 0){
                    count ++;
                }
                col = col.dir;
            }
            linha = linha.inf;
        }
    }
    return count;
}

// lista de filas -> contar quantos elementos tem no total
public int contaElementos(){
    int count = 0;

    for(CelulaLista i = inicio; i != null; i = i.prox){

        // cada NO tem uma fila
        CelulaFila f = i.primeiro;// inicio da fila

        while(f != null){
            count ++;
            f = f.prox;
        }
    }
    return total;
}

// lista de matrizes -> somar apenas as diagonais principais
public int somaDiagonal(){
    int soma = 0;

    for(int CelulaLista i = inicio; i != null; i = i.prox){

        Matriz m = i.matriz;

        Celula c = m.inicio;

        while(c != null){
            soma += c.elemento;

            c = c.inf;// ando com ele 1 para baixo
            if(c != null){// se ele nao for null apos andar p baixo eu ando p direita, mantendo o principio da diagonal principal
                c = c.dir;
            }
        }
    }
    return soma;
}

// ----- ARVORE BINARIA DE PESQUISA-----\\ 
// contar os nós da arvore
public int contarNos(){
    return contarNos(raiz);
}
public int contarNos(No i){
    if(i == null){
        return 0;
    }

    return 1 + contarNos(i.esq) + contarNos(i.dir);// eu conto esse no + esquerda + direita
}

// ALTURA DA ARVORE
public int altura(){
    return altura(raiz);
}
public int altura(No i){
    if(i == null){
        return -1;// base
    }
    int esq = altura(i.esq);
    int dir = altura(i.dir);

    if(esq > dir){
        return 1 + esq;
    }else{
        return 1 + dir;
    }

}

// lista de filas -> retornar quantas filas possuem pelo menos 1 elemento impar
public int contaImpar(){
    int count = 0;

    for(CelulaLista i = primeiro; i != null; i = i.prox){
        CelulaFila f = i.topo;

        boolean impar = false;

        while(f != null){
            if(f.elemento % 2 != 0){
                impar = true;
                break;
            }
            f = f.prox;
        }
        if(impar){
            return count ++;
        }
    }
    return count;
}

// lista dupla-> verificar se a lista esta em ordem crescente
public boolean crescente(){
    for(Celula i = primeiro; i != null && i.prox != null; i = i.prox){
        if(i.elemento > i.prox.elemento){
            return false;
        }
    }
    return true;
}

// matriz flexivel -> contar quantos elementos sao maiores que a media da matriz
publuc int maiorMedia(){
    int count = 0;
    int soma = 0;

    int elementoMaior = 0;

    Celula linha = inicio;
    while(linha != null){
        Celula col = linha;
        while(col != null){
            soma += col.elemento;
            count ++;
            col = col.dir
        }
        linha = linha.inf;
    }

    int media = soma / count;

    linha = inicio;
    while(linha != null){
        col = linha;
        while(col != null){
            if(col.elemento > media){
                elementoMaior ++;
            }
            col = col.dir;
        }
        linha = linha.inf;
    }
    return elementoMaior;
}

// lista de matrizes -> quantas possuem pelo menos 1 numero negativo
public int contaNegativo(){
    int count = 0;

    for(CelulaLista i = inicio; i != null; i = i.prox){
        Matriz m = i.matriz;

        boolean temNegativo = false;

        Celula linha = m.inicio;
        while(linha != null){
            Celula col = linha;
            while(col != null){
                if(col.elemento < 0){
                    temNegativo = true;
                    break;
                }
                col = col.dir;
            }
            linha = linha.inf;
        }
        if(temNegativo){
            count ++;
        }
    }
    return count;
}

// verificar se 2 arvores sao espelho uma da outra
public boolean isEspelho(No a, No b){
    if(a == null && b == null){
        return true;
    }

    if(a == null || b == null){
        return false;
    }

    if(a.elemento != b.elemento){
        return false;
    }

    return isEspelho(a.esq,b.dir) %% isEspelho(a.dir,b.esq);
}

// lista flexivel -> inserir um elemento x antes de cada numero impar
public void insereX(int x){
    Celula ant = primeiro;// referencia
    Celula i = primeiro.prox;// referencia

    while(i != null){
        if(i.elemento % 2 != 0){// se o elemento for impar
            Celula tmp = new Celula(x);// crio a nova celula

            ant.prox = tmp;
            tmp.prox = i;

            ant = tmp;
        }
        ant = i;
        i = i.prox;
    }
}

// pilha flex -> retornar quantos elementos sao maiores que a media -> prox, topo, elemento
public int maiores(){
    int count = 0;
    int soma = 0;

    for(Celula i = topo; i != null; i = i.prox){
        soma += i.elemento;
        
        count ++
    }

    int media = 0;
    media = soma / count;

    count = 0;

    for(Celula j = topo; j != null; i = i.prox){
        if(i.elemento > media){
            count ++;
        }
    }
    return count;
}

// lista dupla flexivel -> verificar se e palindromo
public boolean palindromo(){
    Celula i = primeiro;
    Celula j = ultimo;

    while(i != j){
        if(i.elemento != j.elemento){
            return false;
        }
        i = i.prox;
        j = j.ant;
    }
    return true;
}

// arvore de listas -> contar quantos nos possuem lista com soma > 100
public int maiorQue100(){
    return maiorQue100(raiz);
}
public int maiorQue100(No i){
    if(i == null){
        return 0;
    }

    int soma = 0;

    for(Celula j = i.primeiro; j != null; j = j.prox){
        soma += j.elemento;
    }

    if(soma > 100){
        soma ++;
    }

    return resp + maiorQue100(i.esq) + maiorQue100(i.dir);
}

// abp de pilha-> somar todos os elementos
int somaElementos(){
    return somaElementos(raiz);
}
int somaElementos(No i){
    if(i == null){
        return 0;
    }
    int soma = 0;
    CelulaPilha p = i.topo;
    while(p != null){
        soma += p.elemento;
        p = p.prox;
    }

    return soma + somaElementos(i.esq) + somaElementos(i.dir);
}

// palindromo na fila dupla sem cabeça(primeiro elemento e valido)
public boolean palindromo(){
    Celula i = primeiro;
    Celula j = ultimo;
    while(i != j){
        if(i.elemento != j.elemento){
            return false;
        }
        i = i.prox;
        j = j.ant;
    }
    return true;
}

// lista de matriz -> somar diagonais principais matriz
int somaDiagonal(){
    int soma = 0;
    for(Celula i = primeiro; i != null; i = i.prox){
        Celula c = i.matriz.inicio;;
        while(c != null){
            soma += c.elemento;
            c = c.inf;
            if(c != null){
                c = c.dir;
            }
        }        
    }
    return soma;
}

// Em uma árvore de listas que funciona como dicionário (nós guardam a letra inicial, listas guardam palavras em ordem alfabética), implemente void remover(String palavra) que remove a palavra da estrutura.
public void remover(String palavra){

}

// lista de filas -> retornar quantas filas tem pelo menos 1 impar
public int contaImpar(){
    int count = 0;
    for(CelulaLista i = inicio; i != null; i = i.prox){
        CelulaFila f = i.primeiro;
        while(f != null){
            if(f.elemento % 2 != 0){
                count = ++;
                f = null;
            }
            f = f.prox;
        }
    }
    return count;
}

public boolean isEspelho(Arvore outra) {
    return isEspelho(this.raiz, outra.raiz);
}
private boolean isEspelho(No a, No b) {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;
    if (a.elemento != b.elemento) return false;

    // esq de A espelha dir de B, e dir de A espelha esq de B
    return isEspelho(a.esq, b.dir) && isEspelho(a.dir, b.esq);
}

// arvore de listas -> cada no guarda a letra inicial e cada lista guarda palavras em ordem alfabetica
public void inserir(String palavra){
    char letra = palavra.chatAt(0);
    raiz = inserir(palavra,letra,raiz);
}
public void inserir(String palavra, char letra, No i){
    if(i == null){// crio o novo no e ja insiro na lista
        No novo = new No (letra);
        Celula c = new Celula(palavra);
        novo.primeiro = novo.ultimo = c;
        return novo;
    }else if(letra < i.letra){
        i.esq = inserir(palavra,letra,i.esq);
    }else if(letra > i.letra){
        i.dir = inserir(palavra,letra,i.dir);
    }else{// no encontrado
        Celula nova = new Celula(palavra);
        Celula ant = null;
        Celula j = i.primeiro;
        while(j != null && j.palavra.compareTo(palavra) > 0){
            ant = j;
            j = j.prox;
        }
        nova.prox = j;
        if(ant == null)i.primeiro = nova;
        else ant.prox = nova;
        if(nova.prox == null) i.ultimo = nova
    }
    return i;
}

// lista de pilhas -> contar quantas estao em ordem crescente
public int contaCrescentes(){
    int count = 0;
    for(CelulaLista i = inicio; i != null; i = i.prox){
        boolean crescente = true;
        CelulaPilha p = i.topo;
        while(p != null && p.prox != null){
            if(p.elemento > p.prox.elemento){
                crescente = false;
                break;
            }
            p = p.prox;
        }
        if(crescente) count ++;
    }
    return count;
}

// arvore de listas -> procurar uma palavra -> cada no e uma letra
public boolean buscar(String palavra){
    return buscar(palavra, raiz);
}
private boolean buscar(String palavra, No i){
    if(i == null){
        return false;
    }
    char letra = palavra.charAt(i);
    if(letra < i.letra){
        return buscar(palavra, i.esq);
    }else if(letra > i.letra){
        return buscar(palavra,i.dir);
    }
    // passou por tudo = achei
    for(Celula j = primeiro; j != null; j = j.prox){
        if(j.palavra.equals(palavra)){
            return true;
        }
    }
    return false;
}

// em uma ABP, somar todas as diagonais principais das matrizes dos nos
public int somaDiagonais(){
    return somaDiagonais(raiz);
}
private int somaDiagonais(No i){
    if(i == null){
        return 0;
    }
    int soma = 0;// ela vai zerar a cada iteracao
    Celula m = i.matriz.inicio;
    while(m != null){
        soma += m.elemento;
        m = m.inf;
        if(m != null){/
            m = m.dir;
        }
    }
    return soma + somaDiagonais(i.esq) + somaDiagonais(i.dir);
}

// verificar em uma lista de filas se todas estao em ordem crescente
boolean verificaDecrescente(){
    for(CelulaLista i = inicio; i != null; i = i.prox){
        CelulaPilha p = i.primeiro;
        while(p != null && p.prox == null){
            if(p.elemento > p.prox.elemento){
                return false;
            }
            p = p.prox;
        }
    }
    return true;
}

// na fila de pilhas (fila c celula cabeca) somar a qt de elementos de todas as pilhas
public int contarTotal(){
    int count = 0;
    for(CelulaFila i = primeiro.prox; i != null; i = i.prox){
        CelulaPilha p = i.topo;
        while(p != null){
            soma ++;
            p = p.prox;
        }
    }
    return soma;
}

// pilha de listas pesquisar um elemento e retornar true se aparecer em qualquer das listas
boolean existe(int x){
    for(CelulaPilha p = topo; p != null; p = p.prox){
        CelulaLista l = p.primeiro;
        while(l != null){
            if(l.elemento == x){
                return true;
            }
            l = l.prox;
        }
    }
    return false;
}

// na matriz de fila implementar o somaPrimeiros que percorre toda matriz e soma o primeiro elemento de cada fila nao vazia
public int somaPrimeiros(){
    int soma = 0;
    CelulaMat linha = inicio;
    while(linha != null){
        CelulaMat col = linha;
        while(col != null){
            if(col.primeiro != null){
                soma += col.elemento;
            }
            col = col.dir;
        }
        linha = linha.esq;
    }
    return soma;
}

// na fila de matrizes implementar metodo que some as diagonal principais das matrizes
public int somaDiagonalPrincipal(){
    int soma = 0;
    for(CelulaFila f = primeiro.prox; f != null; f = f.prox){
        Celula c = f.matriz.inicio;
        while(c != null){
            soma += c.elemento;
            c = c.inf;// desco
            if(c != null){//verifico se ainda tem matriz
                c = c.dir;// vou p lado
            }
        }
    }
    return soma;
}

//contar nos da matriz com mais de k elementos na lista
public int maisDeK(){
    int count = 0;
    CelulaMat linha = inicio;
    while(linha != null){
        CelulaMat col = linha;
        while(col != null){
            int tam = 0;
            Celula c = col.primeiro.prox;
            while(c != null){
                tam ++;
                c = c.prox;
            }
            if(tam > K){
                count ++;
            }
            col = col.dir;
        }
        linha = linha.inf;
    }
    return count;
}

// na ABP percorrer toda arvore, e a cada no acessar a pilha e remover os valores negativos realocando ponteiros
public void removeNegativos(){
    removeNegativos(raiz);
}
private void removeNegativos(No i){
    if(i == null){
        return ;
    }

    while(i.topo != null && i.topo.elemento < 0){
        i.topo = i.topo.prox;// removo os negativos do topo
    }

    CelulaPilha p = i.topo;
    while(p != null){
        if(p.prox.elemento < 0){
            p.prox = p.prox.prox;
        }else{
            p = p.prox;
        }
    }
    removeNegativos(i.esq);
    removeNegativos(i.dir);
}

// na ABP de filas, implementar metodo que retorne a media de todas as filas de todos os nos
public double media(){
    int count = countTotal(raiz);
    int soma = somaTotal(raiz);
    if(count == 0){
        return 0.0;
    }
    return (double)soma / count;
}
public int countTotal(No i){
    if(i == null){
        return 0;
    }
    int count = 0;
    for(CelulaFila f = i.primeiro; f != null; f = f.prox){
        count ++;
    }
    return count + countTotal(i.esq) + countTotal(i.dir);
}
public int somaTotal(No i){
    if(i == null){
        return 0;
    }
    int soma = 0;
    for(CelulaFila f = i.primeiro; f != null; f = f.prox){
        soma += f.elemento;
    }
    return soma + somaTotal(i.esq) + somaTotal(i.dir);
}

// na ABP de pilhas verificar se um valor x aparece em qualquer posicao de qqr fila
boolean existe(int x){
    return existe(x,raiz);
}
public boolean existe(int x, No i){
    if(i == null){
        return false;
    }
    CelulaPilha p = i.topo;
    while(p != null){
        if(x == p.elemento){
            return true;
        }
        p = p.prox;
    }
    
    return existe(x,i.esq) || existe(x,i.dir);// busco nas subarvores
}

//na arvore de listas retornar o char do no que a lista tem mais elementos
public char melhorLetra = ' ';
public int maiorTam = -1;
public char noListaLonga(){
    maiorTam = -1;
    buscar(raiz);
    return melhorLetra;
}
public void buscar(No i){
    if(i == null){
        return;
    }
    for(CelulaLista c = i.primeiro; i != null; i = i.prox){
        tam ++;
    }
    if(tam > maiorTam){
        maiorTam = tam;
        melhorLetra = i.letra;
    }
    buscar(i.esq);
    buscar(i.dir);
}

// fila de pilhas -> total de elementos em todas as pilhas
public int contarTotal{
    int total = 0;

    for(CelulaFila = primeiro.prox; i != null; i = i.prox){
        CelulaPilha p = i.topo;
        while(p != null){
            soma += p.elemento;
            p = p.prox;
        }
    }
    return total;
}

// em uma pilha de listas verificar se um elemento x existe
public boolean existe(int x){
    for(CelulaPilha i = topo; i != null; i = i.prox){
        CelulaLista p = i.primeiro;
        while(p != null){
            if(p.elemento == x){
                return true;
            }
            p = p.prox;
        }
    }
    return false;
}

// matriz de filas -> somar o primeiro elemento de cada fila ao vazia
public int somaPrimeiro(){
    int soma = 0;
    CelulaMat linha = inicio;
    while(linha != null){
        CelulaMat col = linha;
        while(col != null){
            if(col.primeiro != null){
                soma += primeiro;
            }
            f = f.prox;
            col = col.dir;
        }
        linha = linha.inf;
    }
    return soma;
}

// na fila de matrizes somar as diagonais principais
public int somaDiagonais(){
    int soma = 0;
    for(CelulaFila i = primeiro; i != null; i = i.prox){
        Celula c = i.matriz.inicio;
        while(c != null){
            soma += c.elemento;
            c = c.inf;
            if(c != null){
                c = c.dir;
            }
        }
    }
    return soma;
}

// matriz de lista -> contar listas com mais de k elementos
public int contaLista(){
    int count = 0;
    CelulaMat linha = inicio;
    while(linha != null){
        CelulaMat col = linha;
        while(col != null){
            int tam = 0;
            Celula l = col.primeiro.prox;
            while(l != null){
                tam ++;
                l = l.prox;
            }
            if(tam > k){
                count ++;
            }
            col = col.dir;
        }
        linha = linha.inf;
    }
    return count;
}

// em uma arvore de pilha -> remover todos os elementos negativos da pilha
public void removeNegativos(){
    removeNegativos(raiz);
}
private void removeNegativos(No i){
    if(i == null){
        return 0;
    }

    while(i.topo != null && i.topo.elemento < 0){
        i.topo = i.topo.prox;
    }

    CelulaPilha p = i.topo;
    while(p != null && p.prox != null){
        if(p.prox.elemento < 0){
            p.prox = p.prox.prox;
        }else{
            p = p.prox;
        }
    }
    removeNegativos(i.esq);
    removeNegativos(i.dir);
}

// na arvore de filas calcular a media global de todos os elementos de todas as pilhas
public double media(){
    int count = countFila(raiz);
    if(count = 0){
        return 0;
    }
    int soma = somaFila(raiz);

    return (double)soma / count;
}
private int countFila(No i){
    if(i == null){
        return 0;
    }
    int count = 0;
    CelulaFila f = i.primeiro;
    while(f != null){
        count ++;
        f = f.prox;
    }
    return count + countFila(i.esq) + countFIla(i.dir);
}
private int somaFila(No i){
    if(i == null){
        return 0;
    }
    int soma = 0;
    CelulaFila f = i.primeiro;
    while(f != null){
        soma += soma.elemento;
        f = f.prox;
    }
    return soma + somaFila(i.esq) + somaFila(i.dir);
}

//na arvore de pilas verificar se um elemento x existe em qualquer pilha da arvore
public boolean existe(int x){
    return existe(x,raiz);
}
private boolean existe(int x, No i){
    if(i == null){
        return false;
    }
    CelulaPilha p = i.topo;

    while(p != null){
        if(p.elemento == x){
            return true;
        }
        p = p.prox;
    }

    return existe(x,i.esq) || existe(x,i.dir);
}

// arvore de filas somar somente os elementos das filas dos nos folhas
public int somaFolhas(){
    return somaFolhas(raiz);
}
public int somaFolhas(No i){
    if( i == null){
        return 0;
    }

    int soma = 0;

    if(i.esq == null && i.dir == null){
        CelulaFila f = i.primeiro;
        while(f != null){
            soma += f.elemento;
            f = f.prox;
        }
    }

    return soma + somaFolhas(i.esq) + somaFolhas(i.dir);
}

// contar nos que a pilha tenha soma dos elementos maior que x
public int somaMaior(int x){
    return somaMaior(x, raiz);
}
private int somaMaior(int x, No i){
    if(i == null){
        return 0;
    }
    CelulaPilha p = i.topo;
    int soma = 0;
    while(p != null){
        soma ++;
        p = p.prox;
    }
    if(soma > x){
        return 1 + somaMaior(x, i.esq) + somaMaior(x, i.dir);
    }else{
        return somaMaior(x,i.esq) + somaMaior(x,i.dir);
    }
}

//na arvore de listas somar o comprimento de todas as palavras armazenadas em todos os nos da arvore
public int totalCaracteres(){
    return totalCaracteres(raiz);
}
private int totalCaracteres(No i){
    if(i == null){
        return 0;
    }
    int soma = 0;
    Celula f = i.primeiro;

    while(f != null){
        soma += palavra.length();
    }

    return soma + totalCaracteres(i.esq) + totalCaracteres(i.dir);
}

// na arvore de arvore contar quantas palavras comecam e possuem a mesma quantidade de caracteres que o metodo mandar
public int contarPalavras(String padrao){
    char letra = padrao.charAt(0);
    int tamanho = padrao.length();
    No no = buscarNo(raiz,letra);// busca na arvore externa
    if(no == null) return 0;
    return contarNaInterna(no.raiz, tamanho);// percorrer abp interna
}
private No buscarNo(No i, char letra){// nesse metodo eu acho o No da primeira letra da string padrao
    if(i == null){
        return null;
    }
    if(i.letra == letra){
        return i;
    }
    if(letra < i.letra){
        return buscarNo(i.esq, letra);
    }
    return buscarNo(i.dir,letra);
}
private int contarNaInterna(No2 i, int tamanho){// conto quantas palavras da arvore interna sao do mesmo tamanho da string padrao
    if(i == null){
        return 0;
    }
    int count = 0;
    if(i.palavra.length() == tamanho){
        count = 1;
    }
    return count + contarNaInterna(i.esq, tamanho ) + contarNaInterna(i.dir, tamanho);
}

// na lista de filas retornar a celula da lista que aponta para a fila com maior numero de elementos
public CelulaLista maiorFila(){
    int maior = 0;
    CelulaLista resp = inicio;

    for(CelulaLista i = inicio.prox; i != null; i = i.prox){
        int count = 0;
        CelulaFila f = i.primeiro.prox;
        while(f != null){
            count ++;
            f = f.prox;
        }
        if(count > maior){
            resp = i;// resp recebe a atual celula lista
            maior = count;
        }
    }
    return resp;
}


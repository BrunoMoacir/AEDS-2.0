#include <stdio.h>
#include <stdlib.h>
#include <err.h>
typedef struct Celula
{
    int elemento;
    struct Celula *prox;
} Celula;

Celula *topo;

void inserir(int x)
{
    Celula *tmp = novaCelula(x); // crio uma celula temporaria com o novo elemento
    tmp->prox = topo;            // faço o prox da temporaria apontar pro topo antigo
    topo = tmp;                  // temporaria vai para o topo
    tmp = NULL;                  // libero a temporaria
}

int remover()
{
    if (topo == NULL)
    { // se a pilha estiver vazia da erro
        errx(1, "erro");
    }
    int temp = topo->elemento; // guardo o elemento a ser removido
    Celula *tmp = topo;        // guardo o topo atual em uma celula temporaria
    topo = topo->prox;         // topo recebe o novo topo
    tmp->prox = NULL;          // libero o temp
    free(tmp);
    tmp = NULL;  // libero a celula
    return temp; // retorno o elemento removido
}

void mostrar()
{
    Celula *i;
    printf("[");
    for (i = topo; i != NULL; i = i->prox)
    {
        printf("%d ", i->elemento);
    }
    printf("]");
}

int soma()
{
    Celula *i;
    int soma = 0;
    for (i = topo; i != NULL; i = i->prox)
    {
        soma += i->elemento;
    }
    return soma;
}

int somaRec()
{
    return somaRec(topo);
}
int somaRec(Celula *i)
{
    if (i == NULL)
    {
        return 0;
    }
    else
    {
        return i->elemento + somaRec(i->prox);
    }
}

int maiorElemento()
{
    Celula *i;
    int maior = topo->elemento;
    for (i = topo; i != NULL; i = i->prox)
    {
        if (i->elemento > maior)
        {
            maior = i->elemento;
        }
    }
    return soma;
}

void mostrarRec()
{
    printf("[");
    mostrarRec(topo);
    printf("]");
}
void mostrarRec(Celula *i)
{
    if (i == NULL)
    {
        return;
    }
    printf("%d ", i->elemento);
    mostrarRec(i->prox);

}

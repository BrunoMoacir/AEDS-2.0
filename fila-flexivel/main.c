#include <stdio.h>
#include <stdlib.h>
#include <err.h>

typedef struct Celula{
    int elemento;
    struct Celula* prox;
}Celula;

Celula* primeiro;
Celula* ultimo;

void inserir(int x){
    ultimo->prox = novaCelula(x);// ultimo prox recebe e cria novo elemento
    ultimo = ultimo->prox;// ultimo recebe o novo elemento
}

int remover(){
    if(primeiro == ultimo){
        errx(1,"erro");
    }
    Celula* tmp = primeiro;
    primeiro = primeiro->prox;
    int elemento = primeiro->elemento;
    tmp->elemento = NULL;
    free(tmp);
    tmp = NULL;
    return elemento;
}

void mostrar(){
    printf("[");
    Celula* i;
    for(i = primeiro->elemento; i != NULL; i = i->prox){
        printf("%d ",i->elemento);
    }
    printf("]");
}

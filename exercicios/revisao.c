// inserir no fim de uma celula dupla encadeada circular
void inserirFim(){
    CelulaDupla* nova = novaCelulaDupla(x);
    CelulaDupla* ultima = primeira->ant;
    nova->prox = primeiro;
    nova->ant = ultimo;
    primeiro->ant = nova;
    ultima->prox = nova;
}

// remover inicio na lista dupla encadeada circular com cabeca
void removerInicio(){
    if(primeiro->prox == primeiro){
        return 0;// lista vazia
    }
    Celula* removida = primeiro->prox;
    primeiro->prox = removida->prox;
    removida->prox->ant = primeiro;
    free(removida);
}

// inserir inicio na lista dupla circular
void inserirInicio(int x){
    Celula* nova = novaCelulaDupla(x);

    nova->prox = primeiro->prox;
    primeiro->prox = nova;
    nova->ant = primeiro;
    primeiro->prox->ant = nova;
}
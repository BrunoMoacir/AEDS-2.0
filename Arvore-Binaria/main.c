// remover ultima coluna da matriz flexivel 
void removeColuna(Matriz *m){
    if(m->inicio == NULL || m->coluna == 0){
        return 0;
    }
    Celula *linha = m->inicio;
    while(linha != NULL){// vou ate a ultima linha
        Celula *col = linha;
        while(col != NULL){
            col = col->dir;//vou ate a ultima coluna
        }
        if(col->esq != NULL){
            col->esq->dir = NULL;
        }
        free(col);
        linha = linha->dir;
    }
    m->colunas --;
}

// inserir no fim da lista dupla circular com cabeça
void inserirFim(int x){
    CelulaDupla *nova = novaCelulaDupla(x);
    CelulaDupla *ultimo = primeiro->ant;

    // ligo as 4 celulas
    nova->prox = primeiro;// proxima da nova vira o primeiro
    nova->ant = ultimo;// anterior da nova vira o ultimo
    ultimo->prox = nova;// proximo do ultimo vira a nova
    primeiro->ant = nova;// anterior do primeiro(ultimo) vira a nova
}
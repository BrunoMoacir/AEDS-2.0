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
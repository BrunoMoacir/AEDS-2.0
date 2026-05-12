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

// inserir ordenado na lista dupla circular com cabeca
void inserirOrdenado(int x){
    CelulaDupla* nova = novaCelulaDupla(x);
    CelulaDupla* cur = primeiro->prox;
    while(cur != primeiro && cur->elemento < x){
        cur = cur->prox;
    }
    nova->prox = cur;
    nova->ant = cur->ant;
    cur->ant->prox = nova;
    cur->ant = nova;
}

// inverter a lista 
void inverterLista(){
    CelulaDupla* i = primeiro->prox;
    while(i != primeiro){
        CelulaDupla* tmp = i->prox;
        i->prox = i->ant;
        i->ant = tmp;
        i = tmp;// avanco
    }
}

// contar o tamanho da lista dupla circular
int tamanhoLista(CelulaDupla* primeiro){
    CelulaDupla* i = primeiro->prox;
    int count = 0;
    while(i != primeiro){
        count ++;
        i = i->prox;
    }
    return count;
}

// buscar elemento na lista dupla circular com cabeça
CelulaDupla* buscarElemento(CelulaDUpla* primeiro, int x){
    CelulaDupla* i = primeiro->prox;
    while(i != primeiro){
        if(i->elemento == x){
            return i;
        }
        i = i->prox;
    }
    return NULL;
}

// remover a ultima coluna da matriz flexivel
void removerUltimaColuna(Matriz *m){
    Celula* linha = m->inicio;
    while(linha != null){
        Celula* col = linha;
        while(col->dir != null){
            col = col->dir;// posiciono o ponteiro na coluna na ultima coluna
        }
        if(col->esq != null){
            col->esq->dir = NULL;
        }
        Celula* prox = linha->inf;
        free(col);
        linha=prox;
    }
}

// busca na arvore em c
No* buscar(No* i, int x){
    if(raiz == null){
        return NULL;
    }
    if(raiz->numero == val){
        return raiz;
    }
    if(x < raiz->numero){
        return buscar(raiz->esq, x);
    }
    return buscar(raiz->dir,x);
}

// inserir na arvore em c
No* inserir(No* raiz, int x){
    No* novo = malloc(sizeof(No));
    novo->numero = x;
    novo->esq = novo->dir = NULL;
    if(!raiz)return novo;
    No *c = raiz,*pai = NULL;
    while(c ){
        pai = cur;
        if(x < cur->numero){
            cur = cur->esq;
        }else{
            cur=cur->dir;
        }
    }
    if(x <pai->numero){
        pai->esq = novo;
    }else{
        pai->dir = novo;
    }
    return raiz;
}
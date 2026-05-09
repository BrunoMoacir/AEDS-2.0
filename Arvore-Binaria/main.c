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

// na lista dupla circular com celula cabeca, remover o ultimo elemento
void removerUltimo(){
    if(primeiro->prox == primeiro){
        return;// lista vazia
    }  
    CelulaDupla* ultimo = primeiro->ant;// crio uma celula pegando o ultimo elemento
    CelulaDupla* penultimo = ultimo->ant;// crio uma celula pegando o penultimo elemento

    penultimo->prox = primeiro;// faco o prox do penultimo (que seria o ultimo) apontar para o primeiro (cabeca)
    primeiro->ant = penultimo;// faco o ant do primeiro(que seria o ultimo)apontar para o penultimo
}


// remover a primeira linha da matriz flexivel ajustando os ponteiros
// so eu ir para a segunda linha, passar por todos os elementos fazendo com que seu sup aponte para null
void removerPrimeiraLinha(Matriz* m){
    Celula* velhaLinha = m->inicio;
    m->inicio = m->inicio->inf;// novo inicio = segunda linha

    if(m->inicio != null){
        Celula* c = m->inicio;
        while(c != null){
            c->sup = NULL;
            c = c->dir;
        }
    }
    // libero as colunas da primeira linha
    while(velhaLinha != NULL){
        Celula* prox = velhaLinha->dir;
        free(velhaLinha);
        velhaLinha = prox;
    }
    m->linhas --;
}
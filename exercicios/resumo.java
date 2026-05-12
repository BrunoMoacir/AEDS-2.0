public class resumo {
    // LISTA DUPLA CIRCULAR COM CABECA -> mexer sempre 4 ponteiros
    void inserirFIm(int x){
        CelulaDupla* nova = novaCelulaDupla(x);
        CelulaDupla* ultimo = primeiro->ant;
        nova->prox = primeiro;
        nova->ant = ultimo;
        ultimo->prox = nova;
        primeiro->ant = nova;
    }

    void removerInicio(){
        if(primeiro->prox == primeiro){return;}// vazia
        CelulaDupla* rem = primeiro->prox;
        primeiro->prox = rem->prox;
        rem->prox->ant = primeiro;
        free(rem);
    }

    void inserirInicio(int x){
        CelulaDupla* nova = novaCelulaDupla(x);
        CelulaDupla* prim = primeiro->prox;// 1.o real
        nova->prox = prim;
        nova->ant = primeiro;
        primeiro->prox = nova;
        prim->ant = nova;
    }

    // MATRIZ FLEXIVEL
    // PERCURSO COMPLETO
    Celula linha = inicio;
    while(linha != null){
        Celula col = linha;
        while(col != null){
            // uso col.elemento
        }
        col = col.dir;
    }
    linha = linha.inf;
}

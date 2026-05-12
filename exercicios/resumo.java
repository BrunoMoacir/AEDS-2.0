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

    // DIAGONAL PRINCIPAL
    Celula c = inicio;
    while(c != null)
    // uso c
    c = c.inf;
    if(c != null){
        c = c.dir;
    }

    // ARVORE BINARIA DE PESQUISA REMOCAO (3 casos)
    No remover(int x, No i) throws Exception{
        if(i == null){
            throw new Exception("Erro");
        }else if(x < i.elemento){
            i.esq = remover(x,i.esq);
        }else if(x > i.elemento){
            i.dir = remover(x,i.dir);
        }else if(i.dir == null){
            i = i.esq;// caso 1 e 2a
        }else if(i.esq == null){
            i = i.dir;// caso 2b
        }else{
            i.esq = maiorEsq(i,i.esq);// caso 3
        }
        return i;
    }
    No maiorEsq(No i, No j){
        if(j.dir == null){
            i.elemento = j.elemento;
            j = j.esq;
        }else{
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }

    // lista de pilhas -> retornar a celula com a pilha de maior elemento
    public CelulaLista maiorPilha(){
        int tamanho = 0;
        CelulaLista maior = inicio;
        for(CelulaLista i = inicio; i != null; i = i.prox){
            int count = 0;
            for(CelulaPilha p = i.topo; i != null; i = i.prox){
                count ++;
            }
            if(count > tamanho){
                tamanho = count;
                maior = i;
            }
        }
    }
    return maior;

    // na matriz de listas com cabeça remover impares das listas
    public void removeImpares(){
        CelulaMat linha = inicio;
        while(linha != null){
            CelulaMat col = linha;
            while(col != null){
                Celula ant = col.primeiro, j = ant.dir;
                while(j != null){
                    if(j.numero % 2 != 0){
                        ant.prox = j.prox;
                        if(j == col.ultimo){
                            col.ultimo = ant;
                        }else{
                            ant = j;
                            j = ant.prox;
                        }
                        col = col.dir;
                    }
                    linha = linha.inf;
                }
            }
        }
    }

    // verificar se uma arvore e espelho da outra
    public boolean isEspelho(Arvore outra){
        return isEspelho(this.raiz, outra.raiz);
    }
    private boolean isEspelho(No a, No b){
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        if(a.elemento != b.elemento){
            return false;
        }
        return isEspelho(a.esq, b.dir) && isEspelho(a.dir, b.esq);
    }

    // arvore de arvore, contar quantas comecam com o char primeiro e termina com o char ultimo
    public int contarPalavras(char p, char u){
        return contarPalavras(p,u,raiz);
    }
    private int ContarPalavras(char p, char u, No i){
        if(i == null){
            return 0;
        }
        int count = contarInterna(p,u,i.raiz);
        return count + contarPalavras(p, u,i.esq) + contarPalavras(p, u,i.dir);
    }
    private int contarInterna(char p, char u, No2 i){
        if(i == null){
            return 0;
        }
        String a = i.palavra;
        int ok = 0;
        if(a.charAt(0) == p && a.charAt(a.length() - 1) == u){
            ok = 1;
        }
        return ok + contarInterna(p, u, i.esq) + contarInterna(p, u, i.dir);
    }

    
}

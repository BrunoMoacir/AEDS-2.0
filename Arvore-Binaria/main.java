class No{
    public No(int x) {
        //TODO Auto-generated constructor stub
    }
    public int elemento;
    No esq;
    No dir;
}
class ArvoreBinaria{
    void inserir(int x)throws Exception{
        raiz = inserir(raiz, x);
    }

    No inserir(No i, int x)throws Exception{
        if(i == null){
            i = new No(x);
        }else if(x < i.elemento){
            i.esq = inserir(i.esq, x);
        }else if(x > i.elemento){
            i.dir = inserir(i.dir, x);
        }else{
            throw new Exception("erro");
        }
        return i;
    }

    boolean pesquisar(int x) {
        return pesquisar(x,raiz);
    }
    boolean pesquisar(int x, No i){
        boolean resp;
        if(i == null){
            resp = false;
        }else if(x == i.elemento){
            resp = true;
        }else if(x < i.elemento){
            resp = pesquisar(x,i.esq);
        }else{
            resp = pesquisar(x,i.dir);
        }
        return resp;
    }
}

// REMOCAO
void remover(int x) throws Exception{
    return remover(x,raiz);
}
No remover(int x, No i) throws Exception{
    if(i == null){
        throw new Exception("Erro");
    }else if(x < i.elemento){
        return (x,i.esq);
    }else if(x > i.elemento){
        return (x,i.dir);
    }else if(i.dir == null){// caso 1 folha ou caso 2a so filho esq
        i = i.esq;
    }else if(i.esq == null){// caso 2b so filho dir
        i = i.dir;
    }else{// caso 3 -> dois filhos
        i.esq = maiorEsq(i,i.esq);
    }
    return i;
}
No maiorEsq(No i, No j){
    if(j.dir == null){// j e o maior, nao tem filhos dir
        i.elemento = j.elemento;//copia para o  o deletado
        j = j.esq;// removo j
    }else{
        j.dir = maiorEsq(i,j.dir);// continuo buscando a direita
    }
    return j;
}
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

// abp -> implementar remover do 0 sem consulta
void remover(int x) throws Exception{
    raiz = remover(x,raiz);
}
No remover(int x, No i) throws Exception{
    if(i == null){
        throw new Exception("Erro");
    }else if(x < i.elemento){
        remover(x, i.esq);
    }else if(x > i.elemento){
        remover(x, i.dir);
    }else if(i.dir == null){// aqui eu ja achei o elemento, agora e processar seus filhos
        i = i.esq;// se nao tem filho a direita pego o da esquerda
    }else if(i.esq == null){
        i = i.dir;// se n tem filho a esquerda pego o da direita
    }else{
        i.esq = maiorEsq(i,i.esq);
    }
    return i;
}
No maiorEsq(No i, No j){// vou usar o no J  
    if(j.dir == null){// j e o maior -> n tem filho a direita
        i.elemento = j.elemento;// copio para o no deletado
        i = i.esq;//removo j
    }else{
        j.dir = maiorEsq(i,j.dir);// continuo buscando a direita
    }
    return j;
}

// na ABP, fazer o removerMenor() que remove o menor elemento vulgo no mais a esquerda
void removerMenor() throws Exception{
    if(raiz == null){
        throw new Exception("Erro");
    }
    raiz = removerMenos(raiz);
}
void removerMenor(No i){
    if(i.esq == null){// i e o menor: 0 ou 1 filho
        return i.dir;
    }
    i.esq = removerMenor(i.esq);// continuo a esquerda
    return i;
}

// na ABP, remover o menor elemento
void removerMaior() throws Exception{
    if(raiz == null){
        throw new Exception("Erro");
    }
    raiz = removerMaior(raiz);
}
void removerMaior(No i){
    if(i.dir == null){
        return i.esq;
    }
    i.dir = removerMaior(i.dir);// continuo a direita
    return i;
}

// na abp, remover todas as folhas (nos sem filhos)
void removerFolhas(){
    raiz = removerFolhas(raiz);
}
void No removerFolhas(No i){
    if(i == null){
        return null;
    }
    if(i.esq == null && i.dir == null){
        return null;// é folha -> removo
    }
    i.esq = removerFolhas(i.esq);// faco o msm para esq
    i.dir = removerFolhas(i.dir);// faco o msm para dir
    return i;
}

// na abp remover elementos maiores que X
void removerMaiorX(int x){
    raiz = removerMaiorX(x, raiz);
}
void removerMaiorX(int x,No i){
    if(i == null){
        return null;
    }
    if(i.elemento > x){
        return removerMaiorX(x,i.esq);// descarto tudo a dir, mantenho so a subarvore esq
    }
    i.dir = removerMaiorX(x,i.dir);
    return i;
}
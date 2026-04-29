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
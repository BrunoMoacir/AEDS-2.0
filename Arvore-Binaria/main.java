class No{
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
}
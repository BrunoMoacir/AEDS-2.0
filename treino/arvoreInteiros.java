import java.util.Scanner;

public class arvoreInteiros {
    static class No {
        int elemento;
        No esq;
        No dir;

        public No(int x) {
            elemento = x;
            esq = null;
            dir = null;
        }
    }

    public static No inserir(No i, int x){
        if(i == null){
            i = new No(x);
        }else if(x < i.elemento){
            i.esq = inserir(i.esq, x);
        }else if(x > i.elemento){
            i.dir = inserir(i.dir,x);
        }
        return i;
    }

    public static boolean pesquisar(No i, int x){
        boolean resp;
        if(i == null){
            resp = false;
        }else if(i.elemento == x){
            resp = true;
        }else if(x < i.elemento){
            resp = pesquisar(i.esq, x);
        }else {
            resp = pesquisar(i.dir,x);
        }
        return resp;
    }

    public static void caminharCentral(No i){
        if(i != null){
            caminharCentral(i.esq);
            System.out.println(i.elemento);
            caminharCentral(i.dir);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        No raiz = null;

        int x = sc.nextInt();
        while(x != -1){
            raiz = inserir(raiz,x);
            x = sc.nextInt();
        }
        System.out.println("EM ORDEM");

        caminharCentral(raiz);

        sc.close();
    }
}

import java.util.Scanner;

public class arvoreStrings{
    static class No{
        String elemento;
        No esq;
        No dir;

        public No(String s){
            elemento = s;
            esq = null;
            dir = null;
        }
    }

    public static No inserir(No i, String s){
        if(i == null){// cheguei numa posicao vazia
            i = new No(s);
        }else if(s.compareTo(i.elemento) < 0){
            i.esq = inserir(i.esq, s);
        }else if(s.compareTo(i.elemento) > 0){
            i.dir = inserir(i.dir,s);
        }
        return i;
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

        String palavra = sc.next();

        while(palavra.compareTo("FIM") != 0){
            raiz = inserir(raiz,palavra);
            palavra = sc.next();
        }

        System.out.println("EM ORDEM");
        
        caminharCentral(raiz);

        sc.close();
    }
}
import java.util.Scanner;

public class pilha{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        char[] pilha = new char[s.length()];
        int topo = -1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(topo >= 0 && pilha[topo] == c){// se topo >= 0 (nao ta vazio) e o elemento == char
                topo --;// removo
            }else{
                topo ++;
                pilha[topo] = c;// adiciono
            }
        }
        for(int i = 0; i <= topo; i++){
            System.out.print(pilha[i]);
        }
        System.out.println();
    }
}
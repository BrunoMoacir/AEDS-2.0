import java.util.Scanner;

public class questao11 {
    public static void inverter(String s, int i){
        if(i < 0){// acabou a string
            return;
        }
        System.out.print(s.charAt(i));// imprimo o caractere

        inverter(s, i - 1);// chamo novamente a string indo um caractere para esquerda
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){// enquanto tiver algo para ler

            String s = sc.nextLine();// pego a string

            inverter(s, s.length() - 1);// chamo o metodo recursivo

            System.out.println();
        }
    }
}

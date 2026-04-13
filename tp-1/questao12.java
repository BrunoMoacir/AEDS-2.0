import java.util.Scanner;

public class questao12 {
    public static int somaNumeros(int n){
        if(n == 0){
            return 0;
        }
        return (n % 10) + somaNumeros(n / 10);
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int numero = sc.nextInt();

            System.out.println(somaNumeros(numero));
        }
    }
}

import java.util.Scanner;


public class main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int n = sc.nextInt();// qt operacoes

            String[] fila = new String[1000];

            int inicio  = 0;
            int fim = 0;

            int tamanho = 0;

            for(int i = 0; i < n; i++){
                String comando = sc.next();// leio comando

                if(comando.charAt(0) == 'C' && comando.charAt(2) == 'E'){
                    String nome = sc.next();

                    fila[fim] = nome;
                    fim ++;
                    tamanho ++;
                }else if(comando.charAt(0) == 'C' && comando.charAt(2) == 'A'){
                    if(tamanho == 0){
                        System.out.println("FILA VAZIA");
                    }else{
                        System.out.println(fila[inicio]);
                        inicio ++;
                        tamanho --;
                    }
                }else{
                    System.out.println(tamanho);
                }
                
            }
        }
    }
}

import java.util.Scanner;

public class fila{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int [] fila = new int [1000];
		int inicio = 0;
		int fim = 0;
		int tamanho = 0;

		while(sc.hasNext()){
			String comando = sc.next();
			if(comando.charAt(0) == 'E'){
				fila[fim] = sc.nextInt();
				fim ++;
				tamanho ++;
			}else if(comando.charAt(0) == 'S'){
				inicio ++;
				tamanho --;
			}else{
				for(int i = inicio; i <= fim; i++){
					System.out.println(fila[i]);
				}
			}
		}
	}
}


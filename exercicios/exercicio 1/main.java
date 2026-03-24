import java.util.Scanner;

public class main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int qtNumeros = sc.nextInt();
		int [] numeros = new int[qtNumeros];
		for(int i = 0; i < qtNumeros; i++){
			numeros[i] = sc.nextInt();
		}
		// ordenar
		for(int j = qtNumeros - 1; j > 0; j--){
			for(int k = 0; k < j; k++){
				if(numeros[k] > numeros[k + 1]){
					int tmp = numeros[k];
					numeros[k] = numeros[k + 1];
					numeros[k + 1] = tmp;
				}
			}
		}
		// imprimir final
		for(int b = 0; b < qtNumeros; b++){
			System.out.println(numeros[b] + " ");
		}
		sc.close();
	}
}

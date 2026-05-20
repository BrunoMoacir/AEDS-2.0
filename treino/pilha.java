import java.util.Scanner;

public class pilha{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int [] pilha = new int[1000];
		int topo = -1;

		while(sc.hasNext()){
			String comando = sc.next();
			if(comando.charAt(0) == 'P' && comando.charAt(1) == 'U'){
				int numero = sc.nextInt();
				topo ++;
				pilha[topo] = numero;
			}else if(comando.charAt(0) == 'P' && comando.charAt(1) == 'O'){
				topo --;
			}else{
				if(topo == -1){
					System.out.println("Pilha vazia");
				}else{
					for(int j = topo; j >= 0; j--){
						System.out.println(pilha[j] + " ");
					}
				}
			}
		}
	}
}

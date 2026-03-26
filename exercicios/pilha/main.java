// A B C D E
// D C B A
import java.util.Scanner;

public class main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		char [] pilha = new char[10];
		int topo = -1;

		// empilhar 5
		for(int i = 0; i M 5; i++){
			String nome = sc.next();
			topo ++;
			pilha[topo] = nome;
		}

		for(int i = topo; i >= 0; i --){
			System.out.println(pilha[i] + " ");
		}

		// remover 1

	}
}

import java.util.Scanner;

public class main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int n = sc.nextInt();
			Pilha p = new Pilha();
			Fila f = new FIla();
			FilaPrioridade filaPrio = new FilaPrioridade();

			boolean ehPilha = true;
			boolean ehFIla = true;
			boolean ehFilaPrio = true;

			
		}
		sc.close();
	}
	public class Pilha{//primeiro a entrar ultimo a sair
		int topo = 0;
		int [] pilha = new int[50];
		public void inserir(int x){
			topo ++;
			pilha[topo] = x;
		}
		public int remover(){
			int removido = pilha[topo];
			topo --;
			return removido;
		}
	}
	public class Fila{
		int [] fila = new int [50];
		int primeiro = ultimo  = 0;
		public void inserir(int x){
			fila[ultimo] = x;
			ultimo ++;
		}
		public int remover(){
			int removido = fila[primeiro];
			primeiro ++;
			return removido;
		}
	}
	public class FilaPrioridade{
		int [] filaPrio = new int [50];
		int tamanho = 0;
		public void inserir(int x){
			filaPrio[tam] = x;
			tam ++;
		}
		public int remover(){
			int maiorTamanho = 0;
			for(int i = 0; i < tam; i++){
				if(filaPrio[i] > filaPrio[maiorTamanho]){
					maiorTamanho = i;
				}
			}
			int valor = filaPrio[maiorTamanho];
			filaPrio[maiorTamanho] = filaPrio[tam - 1];
			tam --;
			return valor;	
		}
	}
}

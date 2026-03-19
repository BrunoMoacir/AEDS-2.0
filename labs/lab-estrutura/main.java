import java.util.Scanner;

class Pilha{//primeiro a entrar ultimo a sair
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
class Fila{
	int [] fila = new int [50];
	int primeiro = 0;
	int ultimo = 0;
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
class FilaPrioridade{
	int [] filaPrio = new int [50];
	int tam = 0;
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
public class main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int n = sc.nextInt();
			Pilha p = new Pilha();
			Fila f = new Fila();
			FilaPrioridade filaPrio = new FilaPrioridade();

			boolean ehPilha = true;
			boolean ehFila = true;
			boolean ehFilaPrio = true;

			for(int i = 0; i < n; i++){
				int comando = sc.nextInt();
				int x = sc.nextInt();
				if(comando == 1){
					p.inserir(x);
					f.inserir(x);
					filaPrio.inserir(x);
				}
			}
			if(ehPilha){
				System.out.println("stack");
			}else if(ehFila){
				System.out.println("queue");
			}else if(ehFilaPrio){
				System.out.println("priority queue");
			}else if((ehPilha && ehFila) || (ehPilha && ehFilaPrio) || (ehFila && ehFilaPrio)){
				System.out.println("not sure");
			}else{
				System.out.println("impossible");
			}
			
		}
		sc.close();
	}
}

// fila -> primeiro a entrar, primeiro a sair
public class fila{
	public Fila(int tamanho){
		array = new int[tamanho + 1];// +1 para diferenciar cheio/vazio
		primeiro = ultimo = 0;

	}
	// metodos iterativos
	public void inserir(int x) throws Exception{
		if(((ultimo + 1) % array.length) == primeiro){// fila cheia
			throw new Exception("Erro");
		}
		array[ultimo] = x;
		ultimo = (ultimo + 1) % array.length
	}
	public int remover() throws Exception{
		if(primeiro == ultimo){// fila vazia
			throw new Exception("Erro");
		}
		int removido = array[primeiro];
		primeiro = (primeiro + 1) % array.length;
		return removido;
	}
	public void mostrar() throws Exception{
		if(primeiro == ultimo){
			throw new Exception("Erro");
		}
		int i = primeiro;
		System.out.println("[");
		while( i != ultimo){
			System.out.println(array[i] + " ");
			i = (i + 1) % array.length;
		}
		System.out.println("]");
	}
	public boolean isVazio(){
		boolean vazio = false;
		if(primeiro == ultimo){
			vazio = true;
		}
		return vazio;
	}
	public boolean pesquisar(int chave){
		boolean existe = false;
		int i = primeiro;
		while(i != ultimo && !existe){// enquanto o i nao chegar no fim e o existe continuar falso
			if(array[chave] == array[i]){
				existe = true;
			}
		i = (i + 1) % array.length;
		}
		return existe;
	}
	// metodos recursivos
	public void mostrarRec(){
		System.out.println("[");
		mostrarRec(primeiro)// aqui sempre a primeira posicao/numero
		System.out.printlb("]");
	}
	public void mostrarRec(int i){
		if(i != ultimo){
			System.out,println(array[i] + " ");
			i = (i + 1) % array.length;

			mostrarRec(i);// chamo ela mesma -> recursividade
		}
	}
	public boolean pesquisarRec(int chave){
		return pesquisarRec(chave,primeiro);
	}
	public boolean pesquisarRec(int chave, int i){
		boolean existe = falso;
		if(i == ultimo){// chegou no fim
			return existe;
		}
		if(array[i] == chave){
			existe = true;
		}
		return(chave, (i + 1) % array.length);
	}
	
	
	
	
	public static void main(String [] args){

	}
	
}

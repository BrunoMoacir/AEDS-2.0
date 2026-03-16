public class main{
	
	class Lista{
		int [] array;
		int n;

		Lista() { this(6)};
		Lista(int tamanho){
			array = new int [tamanho];
			n = 0;
		}
		void inserirInicio(int x)throws Exception{
			if( n >= array.length){
				throw new Exception ("Erro");
			}
		       for(int i = n; i > 0; i--){// levo os elementos para o fim do array
				array[i] = array[i -1];
		       }
			array[0] = x;
	 		n++;		
		}
		void inserirFinal(int x) throws exception{
			if(n >= array.length){
				throw new Exception("Erro");
			}
			array[n] = x;
			n++;
		}
		void inserir(int x,int pos)throws exception{
			if(n >= array.length || pos < 0 || pos < n){
				throw new Exception("Erro");
			}
			for(int i = n; i > pos; i--){//faco todos os elementos irem para uma casa ao lado
				array[i] = array[i - 1];
			}
			array[pos] = x;// coloco o elemento desejado na posicao que ta vazia agora
			n++;
		}
		int removerInicio throws Exception(){
			if(n == 0){
				throw new Exception("Erro");
			}
			int removido = array[0];// pego o elemento que vai ser removido
			n--;//
			for(int i = 0; i < n; i++){
				array[i] = array[i + 1];
			}
			return removido;
		}
		int removerFim() throws Exception{
			if(n == 0){
				throw new Exception("Erro");
			}
			int removido = array[n];
			n--;
			return removido;
		}
		int remover(int pos) throws Exception{
			if(n == 0){
				throw new Exception("Erro");
			}
			int removido = array[pos];
			n--;// aviso que a lista diminuiu de tamanho
			for(int i = pos; i < n; i++){
				array[i] = array[i + 1];
			}
			return removido;
		}
		void mostrar(){
			System.out.println("[");
			for(int i = 0; i < n; i++){
				System.out.println(array[i] + " "):
			}
			System.out.println("]");
		}	
	
	public static void main(String[] args){
		
	}
}

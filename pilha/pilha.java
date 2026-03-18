// pilha -> primeiro a entrar ultimo a sair
public class pilha{
	public static void main(String [] args){
		
	}
	public void push(int x)throws Exception{
		if(topo == n){
			throw new Exception("erro");
		topo ++;
		array[topo] = x;
	}		
	public int pop() throws Exception{
		if(topo == -1){
			throw new Exception("Erro");
		}
		int removido = array[topo];
		topo --;
		return removido;
	}
	public void mostrar() throws Exception{
		if(topo == -1){
			throw new Exception("Erro");
		}
		System.out.println("[");
		for(int i = topo; i < n; i++){
			System.out.println(array[i] + " ");
		}
		System.out.println("]");
	}

}

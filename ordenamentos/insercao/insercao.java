public class insercao{
	public static void main(String [] args){
		int [] numeros = {4,3,6,7,4};
		int n = 5;

		// ordenacao por insercao
		for(int i = 1; i < n; i++){
			int tmp = array[i];// pego os elementos por ordem
			int j = i - 1;// coloco o j uma posicao atras do elemento selecionado
			while((j <= 0) && (array[j] > tmp){// enquanto j for maior ou igual a zero e o numero do vetor for maior que o elemento selecionado
				array[j + 1] = array[j];// faco as trocas
				j--;// diminuo j
		}
		array[j + 1] = tmp;// chego na posicao do elemento ordenado e coloco ele
	}
}

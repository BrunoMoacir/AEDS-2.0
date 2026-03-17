public class selecao{
	public static void main(String [] args){
		int[] numeros = {3,2,1,4,5,7,3,2};	
		int n = 8;
		// ordenacao por selecao
		for(int i = 0; i < (n - 1); i++){
			int pos = i;
			for(int j = i + 1; j < n; j++){
				if(numeros[j] < numeros[pos]){
					pos = j;
				}
		}
		int tmp = numeros[pos];
		numeros[pos] = numeros[j];
		numeros[j] = tmp;
	}
}

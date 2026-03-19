public class quicksort{
	public static void main(String [] args){
		
	}
	public quicksort(int esq, int dir){
		int i = esq; int j = dir; int pivo = (array[(dir + esq) / 2];// escolha do pivo(metade do array)
		while( i <= j){
			while(array[i] < pivo){
				i++;
			}
			while(array[j] > pivo){
				j--;
			}
			if(i <= j){
				swap(i,j); i++; j--;
			}
		}
		if(esq < j){
			quicksort(esq,j);
		}
		if(i < dir){
			quicksort(i,dir);
		}
	}
}

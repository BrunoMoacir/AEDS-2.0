#include <stdio.h>
#include <stdlib.h>

int main(){
	int n;
	scanf("%d", &n);
	int numeros[n];

	for(int i = 0; i < n; i++){
		scanf("%d", &numeros[i]);
	}// leio cada numero
	
	for(int j = n - 1; j > 0; j --){
		for(int k = 0; k < j; k ++){
			if(numeros[k] > numeros[k + 1]){
				int tmp = numeros[k];
				numeros[k] = numeros[k + 1];
				numeros[k + 1] = tmp;
			}
		}
	}
	for(int b = 0; b < n; b++){
		printf("%d ", numeros[b]);
	}
	return 0;
}

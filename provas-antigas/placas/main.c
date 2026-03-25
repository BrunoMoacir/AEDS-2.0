#include <stdio.h>
#include <stdlib.h>

int main(){
	int n;
	scanf("%d", &n);

	for(int i = 0; i < n; i++){
		char placa[8];

		scanf(" %s",placa);

		if(placa[4] >='0' && placa[4] <='9'){
			printf("A");// placa antigo padrao
		} else if(placa[4] >= 'A' && placa[4] <= 'Z'){
			printf("M");// placa mercosul
		} else{
			printf("I");// placa invalida
		}
		scanf(" %s",placa);
	}
	return 0;
}

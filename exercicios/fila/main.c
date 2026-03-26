#include <stdio.h>

int main(){
	int n;
	scanf("%d", &n);

	char fila[n][50];

	for(int i = 0; i < n; i++){
		scanf("%s", fila[i]);
	}

	int inicio = 0;
	int fim = n;

	if(inicio < fim){
		inicio ++;
	}

	for(int i = inicio; i < fim; i++){
		printf("%s", fila[i]);
	}
	return 0;
}

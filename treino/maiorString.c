#include <stdio.h>

int main(){
	char atual[100];
	char maior[100];

	int tamMaior = 0;

	while(scanf("%s", atual) != EOF){
		int tam = 0;
		while(atual[tam] != 0){
			tam ++;
		}

		if(tam > tamMaior){
			tamMaior = tam;

			int i = 0;

			while(atual[i] != '\0'){
				maior[i] = atual[i];
				i ++;
			}
			maior[i] = '\0';
		}
	}
	printf("%s\n", maior);
	return 0;
}

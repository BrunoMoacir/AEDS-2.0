#include <stdio.h>

int main(){
	char fila[1000][100];//ate 1000 strings, cada string com ate 99 char + \0
	int inicio = 0;
	int fim = 0;
	int tamanho = 0;

	char comando[20];

	while(scanf("%s", comando) != EOF){
		// ENTRA nome
		if(comando[0] == 'E'){
			scanf("%s",fila[fim]);
			fim ++;
			tamanho ++;
		}else if(comando[0] == 'S'){
			if(tamanho > 0){
				inicio ++;
				tamanho --;
			}
		}else{
			for(int i = inicio; i < fim; i++){
				printf("%s\n", fila[i]);
			}
		}
	}
	return 0;
}

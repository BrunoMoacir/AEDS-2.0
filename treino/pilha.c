#include <stdio.h>

int main(){
	char pilha[1000][100];// 1000 strings com ate 100 letras
	int topo = -1;

	char comando[50];

	while(scanf("%s", comando) != EOF){
		if(comando[0] == 'A'){
			topo ++;
			scanf("%s", pilha[topo]);
		}else if(comando[0] == 'U'){
			if(topo > 0){
				topo --;
			}
		}else{
			for(int i = topo; i >=0; i --){
				printf("%s\n", pilha[i]);
			}
		}
	}
	return 0;
}

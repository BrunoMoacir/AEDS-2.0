#include <stdio.h>

int main(){
	char pilha[10][50];
	int topo = -1;

	for(int i = 0; i < 5; i++){
		scanf("%s", pilha[i];
		topo ++;
	}

	topo --;//removo 1
	
	for(int i = topo; i >=0; i --){
		printf("%s ", pilha[i];
	}
	return 0;
}

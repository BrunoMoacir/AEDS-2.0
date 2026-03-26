#include <stdio.h>
#include <stdlib.h>

int main(){
	char d,n[100];

	while(scanf(" %c,%s"m %d, n) && (d != 0)){
		char resultado[100];
		int j = 0;

		for(int i = 0;n[i] != '\0'; i++){
			if(n[i] != d){
				resultado[j ++] = n[i];
			}
		}
		resultado[j] = '\0';
		int inicio = 0;
		while(inicio < j && resultado[inicio] == '0'){
			inicio ++;
		}

		if(inicio == j){
			printg("0\n");
		} else{
			printf("%s\n", &resultado[inicio]);
		}
	}
	return 0;
}

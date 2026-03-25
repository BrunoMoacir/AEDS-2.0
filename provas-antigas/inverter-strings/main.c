#include <stdio.h>
#include <stdlib.h>

int main(){
	char c [1000];
	scanf("%s", c);

	int tam = 0;
	while(c[tam] != '\0') tam++;

	for(int i = tam - 1; i >=0; i--){
		printf("%c", c[i]);
	}
}

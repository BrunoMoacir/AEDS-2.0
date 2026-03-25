#include <stdio.h>
#include <stdlib.h>

int main(){
	char s [1000];
	scanf("%s", s);

	int letras = 0, numeros = 0, outros = 0;

	for(int i = 0; s[i] != '\0'; i++){
		char c = s[i];

		if(c >= '0' && c <= '9'){
			numeros ++;
		}else if(c >='a' && c <='z'){
			letras ++;
		} else{
			outros ++;
		}
	}
	printf("%d %d %d", letras,numeros,outros);
}

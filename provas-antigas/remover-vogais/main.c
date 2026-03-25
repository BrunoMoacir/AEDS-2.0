#include <stdio.h>
#include <stdlib.h>

int main(){
	char s [1000];
	while(scanf("%s", s) != EOF){
		for(int i = 0; s[1] != '\0'; i++){
			char c = s[i];

			if(c != 'a' && c !='e' && c!= 'i' && c != 'o' && c != 'u'){
				printf("%c", c);
			}
		}
		printf("\n");
	}
}

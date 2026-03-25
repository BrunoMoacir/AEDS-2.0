#include <stdio.h>
#include <stdlib.h>

int main(){
	char c;

	while(scanf("%c",&c) != EOF){
		if(c == '@'){
			c = 'a';
		}else if(c == '&'){
			c = 'e';
		}else if(c == '!'){
			c = 'i';
		}else if(c == '*'){
			c = 'o';
		}else if(c == '#'){
			c = 'u';
		}
		printf("%c",c);
	}
	return 0;
}

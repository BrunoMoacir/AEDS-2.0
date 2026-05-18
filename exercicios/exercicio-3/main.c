#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Atleta{
	char nome[50];
	int peso;
}Atleta;

int main(){
	Atleta atletas[50];
	int i = 0;// quantidade;
	
	while(scanf("%s %d",atletas[i].nome, &atletas[i].peso) != EOF){
		i++;
	}

	for(int k = i - 1; k >= 0; k--){
		for(int j = 0; j < k; j++){
			if(atletas[j].peso < atletas[j + 1].peso){
				Atleta tmp = atletas[j];
				atletas[j] = atletas[j + 1];
				atletas[j + 1] = tmp;
			}
		}
	}

	for(int b = 0; b < i; b++){
		printf("%s, %d\n", atletas[b].nome, atletas[b].peso);
	}
}

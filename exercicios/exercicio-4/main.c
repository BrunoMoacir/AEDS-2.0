#include<stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Funcionario{
	char nome[50];
	int salario;
}Funcionario;

int main(){
	int n;// qt funcionarios
	scanf("%d", &n);

	Funcionario funcionarios [n];

	for(int i = 0; i < n; i++){
		scanf("%s",funcionarios[i].nome);
		scanf("%d",&funcionarios[i].salario);
	}

	// ordenacao bolha
	for(int j = n - 1; j >= 0; j--){
		for(int k = 0; k < j; k++){
			if(funcionarios[k].salario > funcionarios[k+1].salario){
				Funcionario tmp = funcionarios[k];
				funcionarios[k] = funcionarios[k + 1];
				funcionarios[k + 1] = tmp;
			}
		}
	}

	for(int b = 0; b < n; b++){
		printf("%s ,%d\n",funcionarios[b].nome, funcionarios[b].salario);
	}
}

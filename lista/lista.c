#include <stdio.h>
#include <stdlib.h>

int main(){

}
void inserirInicio(int x){
	if(n >= MAXTAM){
		exit(1);
	}
	for(int i = n; i > 0; i--){
		array[i] = array[i - 1];
	}
	array[0] = x;
	n++;
}
void inserirFim(int x){
	if(n >= MAXTAM){
		exit(1);
	}
	array[n] = x;
	n++;
}
void inserir(int x, int pos){
	if(n >= MAXTAM){
		exit(1);
	}
	for(int i = n; i > pos; i --){// levo os elementos para o fim do array
		array[i] = array[i - 1];
	}
	array[pos] = x;// coloco na posicao desejada
	n++;// informo que a lista cresceu
}
int removerInicio(){
	if(n == 0){
		exit(1);
	}
	int removido = array[0];// pego o elemento que ta sendo removido
	n --;// informo que o array diminuiu
	for(int i = 0; i < n; i++){// faco todos os elementos cubrirem o que foi removido
		array[i] = array[i + 1];
	}
	return removido;
}
int removerFim(){
	if(n == 0){
		exit(1);
	}
	int removido = array[n];
	n--;
	return removido;
}
int remover(int pos){
	if(n == 0 || pos < 0 || pos > n){
		exit(1);
	}
	int removido = array[pos];// pego o elemento que vai sair
	n --;// informo que a lista diminuiu
	for(int i = pos; i < n; i++){// faco os elementos cubrir as posicoes A PARTIR da que saiu
		array[i] = array[i + 1];
	}
	return removido;
}
void mostrar(){
	printf("[");
	for(int i = 0; i < n; i++){
		printf("%d", array[i]);
	}
	printf("]");
}

#include <stdio.h>
#include <stdlib.h>

int somaNumeros(int n){
    if (n == 0){// quando n zerar, sai da funcao
        return 0;
    }
    return (n % 10) + somaNumeros(n / 10) ;// pego o ultimo digito do numero, somo, e depois tiro ele com o %
}
int main(){
    int numero;

    while(scanf("%d", &numero) == 1){// leio enquanto houver numeros para serem lidos
        printf("%d\n", somaNumeros(numero));// mando o numero atual para a funcao e imprimo o seu resultado
    }
}
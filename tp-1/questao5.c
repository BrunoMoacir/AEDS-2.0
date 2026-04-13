#include <stdio.h>
#include <stdlib.h>

int main(){
    char numeros[20];
    scanf("%s", numeros);

    while(!(numeros[0] == 'F' && numeros[1] == 'I' && numeros[2] == 'M')){
        printf("")
    }
}
int somaNumeros(int n){
    if (n == 0){
        return 0;
    }
    return (n % 10) + somaNumeros(n / 10) ;
}
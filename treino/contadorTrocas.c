#include <stdio.h>

int main(){
    int n;
    scanf("%d", &n);
    printf("Li o tamanho %d\n", n);

    int numeros[n];

    for(int i = 0; i < n; i++){
        scanf("%d", &numeros[i]);
    }

    int trocas = 0;

    for(int j = n - 1; j > 0; j--){
        for(int k = 0; k < j; k++){
            if(numeros[k] > numeros[k + 1]){
                int temp = numeros[k];
                numeros[k] = numeros[k + 1];
                numeros[k + 1] = temp;
                trocas ++;
            }
        }
    }
    printf("%d\n", trocas);
}
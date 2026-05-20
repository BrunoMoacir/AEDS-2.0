#include <stdio.h>

int main(){
    int n;
    scanf("%d", &n);

    for(int i = 0; i < n; i++){
        int l;// qt vagoes
        scanf("%d", &l);

        int vagoes[l];// crio o vagao no tamanho do vagao

        for(int j = 0; j < l; j++){// preencho vagao
            scanf("%d", &vagoes[j]);
        }

        int trocas = 0;

        // bubble sort para ordenar os vagoes

        for(int k = l - 1; k > 0; k--){
            for(int j = 0; j < k; j++){
                if(vagoes[j] > vagoes[j + 1]){
                    int temp = vagoes[j];
                    vagoes[j] = vagoes[j + 1];
                    vagoes[j + 1] = temp;
                    trocas ++;
                }
            }
        }
        printf("Optimal train swapping takes %d swaps\n", trocas);
    }
}
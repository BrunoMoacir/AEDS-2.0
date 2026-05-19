#include <stdio.h>
#include <stdlib.h>
// ler uma palavra e imprimir o tamanho
int main(){
    char s[50];
    scanf("%s", s);

    int tam = 0;
    while(s[tam] != '\0'){
        tam++;
    }
    printf("%d", tam);
    return 0;
}
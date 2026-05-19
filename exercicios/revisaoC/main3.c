#include <stdio.h>
#include <stdlib.h>

// comparar 2 strings e retornar se sao iguais ou diferentes
int main(){
    char s1[40];
    char s2[40];

    scanf("%s", s1);
    scanf("%s", s2);

    int i = 0;
    int iguais = 0;

    while(s1[i] != '\0'){
        if(s1[i] != s2[i]){
            iguais = 1;
        }
        i++;
    }

    if(iguais == 0){
        printf("IGUAIS");
    }else{
        printf("DIFERENTES");
    }
}
#include <stdio.h>
#include <stdlib.h>

// contar palavras de uma frase
int main(){
    char s[500];

    scanf(" %[^\n]", s);// leio a linha inteira

    int i = 0;

    int count = 1;

    while(s[i] != '\0'){
        if(s[i] == ' '){
            count ++;
        }
        i++;
    }
    printf("%d\n", count);
}
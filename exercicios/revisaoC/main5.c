#include <stdio.h>

// remover vogais de uma palavra
int main(){
    char s[100];

    scanf("%s", s);

    int i = 0;

    while(s[i] != '\0'){
        if(s[i] != 'a' && s[i] !='e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u'){
            printf("%c", s[i]);
        }
        i++;
    }
    printf("\n");
}
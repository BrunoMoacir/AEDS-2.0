#include <stdio.h>
#include <stdlib.h>
// contar quantidade de 'a'
int main(){
    char s[50];
    scanf("%s", s);

    int count = 0;
    int i = 0;
    while(s[i] != '\0'){
        if(s[i] == 'a'){
            count ++;
        }
        i++;
    }

    printf("%d\n", count);
}
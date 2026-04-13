#include <stdio.h>
#include <stdlib.h>

int main(){
    char s[100];// declaro a string

    scanf(" %[^\n]", s);// leio toda a string inclusive espacos

    while(!(s[0] == 'F' && s[1] == 'I' && s[2] == 'M')){// enquanto for != de FIM
        int n = 0;
        while(s[n] != 0){// calculo o tamanho
            n++;
        }
        for(int i = n - 1; i >= 0; i--){// comeco do final e vou ate o inicio imprimindo ao contrario
            printf("%c", s[i]);
        }
        printf("\n");
        scanf(" %[^\n]", s);
    }
    return 0;
}
#include <stdio.h>
#include <stdlib.h>

int main(){
    char s[100];// declaro a string

    scanf("%s", s);// leio ate enter ou espaco (nao uso & por ja ser um ponteiro)

    while(!(s[0] == 'F' && s[1] == 'I' && s[2] == 'M')){// enquanto for != de FIM
        int n = 0;
        while(s[n] != 0){// calculo o tamanho
            n++;
        }
        for(int i = n - 1; i >= 0; i--){// comeco do final e vou ate o inicio imprimindo ao contrario
            printf("%c", s[i]);
        }
        printf("\n");
        scanf("%s", s);
    }
    return 0;
}
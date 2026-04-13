#include <stdio.h>

int tamanho(char str[]){ // funcao para pegar o tamanho da string
    int count = 0;
    while(str[count] != '\0'){
        count ++;
    }
    return count;
}
void cifraRecursivo(char str[], int i){
    if(str[i] == '\0'){// acaba quando a string acaba
        return;
    }
    str[i] = str[i] + 3;// cifro: somo 3 digitos na tabela ASCII

    cifraRecursivo(str, i + 1);// chamo a funcao denovo para cifrar a proxima letra
}
int main(){
    char linha [1000];

    scanf(" %[^\n]", linha);// leio a linha inteira

    while(!(linha[0] == 'F' && linha[1] == 'I' && linha[2] == 'M')){// enquanto nao for FIM, continua
        cifraRecursivo(linha, 0);// mando a string para a funcao de cifrar
        printf("%s\n", linha);// imprimo
        scanf(" %[^\n]", linha);// leio a proxima
    }
    return 0;
}
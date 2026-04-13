#include <stdio.h>
#include <stdlib.h>

int tamanho (char str[]){// descobrir o tamanho da string
    int cont = 0;
    while(str[cont] != '\0'){
        cont ++;
    }
    return cont;
}

char converteMinuscula(char c){// converter letra maiuscula para minuscula atraves da tabela ASCII
    if(c >= 'A' && c <='Z'){
        return c + 32;
    }
    return c;
}

int isFim(char str[]){// verificar se "fim" chegou
    if(tamanho(str) != 3){
        return 0;// falso em C
    }
    if(str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
        return 1;// verdadeiro em C
    }
    return 0;
}

int isAnagrama(char str1[], char str2[]){// metodo iterativo do anagrama
    int tam1 = tamanho(str1);
    int tam2 = tamanho(str2);

    if(tam1 != tam2){// se o tamanho for diferente, nao tem como ser anagrama
        return 0;
    }

    int contador[200];// cria o contador de letras

    for(int i = 0; i < 200; i ++){//zera array inteiro (para n ter lixo)
        contador[i] = 0;
    }

    for(int i = 0; i < tam1; i++){// preenche o contador
        // converte as duas letras atuais para minusculas
        char letra1 = converteMinuscula(str1[i]);
        char letra2 = converteMinuscula(str2[i]);

        contador[(int)letra1] ++;
        contador[(int)letra2] --;
    }

    for(int i = 0; i < 200; i++){// ve se sobrou alguma letra
        if(contador[i] != 0){
            return 0;// falso
        }
    }
    return 1;// verdadeiro
}

int main(){
    char palavra1[100];
    char palavra2[100];

    while(scanf("%s",palavra1) == 1){
        if(isFim(palavra1)){
            break;
        }

        scanf("%s", palavra2);

        if(isAnagrama(palavra1, palavra2) == 1){
            printf("SIM\n");
        } else{
            printf("NAO\n");
        }
    }
    return 0;
}

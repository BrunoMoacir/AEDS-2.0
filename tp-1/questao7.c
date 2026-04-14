#include <stdio.h>

int tamanho(char str[]){// funcao para pegar o tamanho da string
    int count = 0;
    while(str[count] != '\0'){
        count ++;
    }
    return count;
}
int isFim(char str[]){// funcao para verificar se ja chegou em FIM
    if(tamanho(str) != 3){
        return 0;
    }
    if(str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
        return 1;
    }
}

int substringMaisLonga(char str[]){
    int n = tamanho(str);
    int max_len = 0;// guardo o maior valor

    // ponteiros
    int inicio = 0;
    int fim = 0;

    int janela[256];//marcar a letra

    for(int i = 0; i < 256; i++){// zera o array a cada nova palavra testada
        janela[i] = 0;
    }

    while(fim < n){// corro a string inteira
        char charAtual = str[fim];

        int indiceAtual = charAtual + 128;// garantia q seja de 0 - 255

        if(janela[indiceAtual] == 0){
            janela[indiceAtual] = 1;// se a letra ainda nao ta na janela, marco ela como presente

            int tamanhoAtual = fim - inicio + 1;
            if(tamanhoAtual > max_len){
                max_len = tamanhoAtual;// atualizo 
            }
            fim ++;// expando para direita
        }else{// se a letra ja ta na janela
            char charInicio = str[inicio];

            int indiceInicio = charInicio + 128;

            janela[indiceInicio] = 0;// tiro ela do inicio do array
            inicio ++;// encolho a janela p esquerda para tirar repeticao
        }
    }
    return max_len;
}
int main(){
    char linha[1000];
    while(scanf("%s", linha) == 1){
        if(isFim(linha)){// se for FIM acaba 
            break;
        }
        printf("%d\n", substringMaisLonga(linha));//mando para a funcao de substring e printo o resultado
    }
    return 0;
}
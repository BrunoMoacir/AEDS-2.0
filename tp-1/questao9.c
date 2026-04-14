#include <stdio.h>

int tamanho(char str[])
{ // funcao para pegar o tamanho da string
    int count = 0;
    while (str[count] != '\0')
    {
        count++;
    }
    return count;// retorno o tamanho
}

void cifraRecursivo(char str[], int i)
{
    if (str[i] == '\0')// quando a string chegar no fim acaba
    {
        return;
    }

    str[i] = str[i] + 3;// cifro ela

    cifraRecursivo(str, i + 1);// chamo a funcao recursivamente para continuar no proximo caractere
}

int main()
{
    char linha[1000];

    while (fgets(linha, sizeof(linha), stdin) != NULL)// enquanto tiver linha para ler
    {
        // remover o \n 
        int i = 0;
        while (linha[i] != '\0')
        {
            if (linha[i] == '\n')
            {
                linha[i] = '\0';
                break;
            }
            i++;
        }

        if (linha[0] == 'F' && linha[1] == 'I' && linha[2] == 'M')// se for FIM, acaba as leituras
        {
            break;
        }

        cifraRecursivo(linha, 0);// chamo a funcao passando a string e o numero de i (comeco) 0
        printf("%s\n", linha);
    }

    return 0;
}
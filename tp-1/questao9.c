#include <stdio.h>

int tamanho(char str[])
{ // funcao para pegar o tamanho da string
    int count = 0;
    while (str[count] != '\0')
    {
        count++;
    }
    return count;
}

void cifraRecursivo(char str[], int i)
{
    if (str[i] == '\0')
    {
        return;
    }

    str[i] = str[i] + 3;

    cifraRecursivo(str, i + 1);
}

int main()
{
    char linha[1000];

    while (fgets(linha, sizeof(linha), stdin) != NULL)
    {
        // remover o '\n' manualmente
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

        if (linha[0] == 'F' && linha[1] == 'I' && linha[2] == 'M')
        {
            break;
        }

        cifraRecursivo(linha, 0);
        printf("%s\n", linha);
    }

    return 0;
}
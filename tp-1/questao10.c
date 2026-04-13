#include <stdio.h>

int tamanho(char str[])
{
    int count = 0;
    while (str[count] != '\0')
    {
        count++;
    }
    return count;
}
int isVogal(char c)
{
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
}
int isLetra(char c)
{
    return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
}
int isVogal(char str[], int i) {
    if (str[i] == '\0') return 1; 
    if (!isVogalChar(str[i])) return 0;
    
    return isVogal(str, i + 1); 
}

int isConsoante(char str[], int i) {
    if (str[i] == '\0') return 1;
    if (!isLetraChar(str[i]) || isVogalChar(str[i])) return 0; 
    
    return isConsoante(str, i + 1);
}

int isInteiro(char str[], int i) {
    if (str[i] == '\0') return 1;

    if (str[i] < '0' || str[i] > '9') return 0;
    
    return isInteiro(str, i + 1);
}

int isReal(char str[], int i, int pontos) {
    if (str[i] == '\0') return 1;

    if (str[i] >= '0' && str[i] <= '9') {
        return isReal(str, i + 1, pontos);
    } 
    else if (str[i] == '.' || str[i] == ',') {
        if (pontos == 1) return 0; 
        return isReal(str, i + 1, pontos + 1);
    }
    
    return 0; 
}
int main(){
    char linha[1000];

    scanf("%s", linha);
    while()
}
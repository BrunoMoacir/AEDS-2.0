char nome[10] = "Bruno"; -> B r u n o \0// \0 marca o final da string

// leitura de string
char s[50];
scanf("%s", s);

// leitura de linha inteira
char s[100];
scanf(" %[^\n]", s);// leio tudo ate \n

// descobrir tamanho da string
int tam = 0;
while(s[tam] != '\0'){
    tam ++;
}



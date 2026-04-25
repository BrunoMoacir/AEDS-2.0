#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct{
    int ano;
    int mes;
    int dia;
}Data;

typedef struct{
    int hora;
    int minuto;
}Hora;

typedef struct{
    int id;
    char* nome;
    char* cidade;
    int capacidade;
    double avaliacao;
    int n_tipos_cozinha;
    char** tipos_cozinha;
    int faixa_preco;
    Hora horario_abertura;
    Hora horario_fechamento;
    Data data_abertura;
    bool aberto;
}Restaurante;

typedef struct{
    int tamanho;
    Restaurante** restaurantes;
}Colecao_Restaurantes;

char* clonar_string(const char* s){// funcao p clonar a string
    int tamanho = 0;

    while(s[tamanho] != '\0'){// pego o tamanho dela
        tamanho ++;
    }

    char* copia = (char*)malloc(tamanho + 1);// aloco a memoria

    for(int i = 0; i < tamanho; i++){// copio letra por letra do original p copia
        copia[i] = s[i];
    }

    copia[tamanho] = '\0';// fecho a string com o final certo
    
    return copia;
}

char** extrair_campos(char* str, char sep, int* count){// corto a string pelo separador
    int qtd = 1;
    for(int i = 0; str[i] != '\0'; i++){
        if(str[i] == sep){
            qtd++;
        }
    }
    *count = qtd;
    char** partes = (char**)malloc(qtd * sizeof(char));
    int idx = 0;

    char buffer[500] = {0};
    int buf_idx = 0;

    for(int i = 0; i <= strlen(str); i++){
        if(str[i] == sep || str[i] == '\0' || str[i] == '\r' || str[i] == '\n'){
            buffer[buf_idx] = '\0';
            partes[idx++] = clonar_string(buffer);// fecho a string atual
            buf_idx = 0;//reseto o buffer p proxima palavra

            if(str[i] == '\0' || str[i] == '\r' || str[i] == '\n'){
                break;
            }
        }
    }

}

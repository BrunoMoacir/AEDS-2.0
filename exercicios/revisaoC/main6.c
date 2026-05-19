#include <stdio.h>

int main(){
    char s[100];
    scanf("%s", s);

    int i = 0;

    char pilha[100];
    int topo = -1;

    while(s[i] != '\0'){
        if(topo >= 0 && pilha[topo] == s[i]){
            topo --;
        }else{
            topo ++;
            pilha[topo] = s[i];
        }
        i++;
    }
    for(int i = 0; i <=topo; i++){
        printf("%c", pilha[i]);
    }
}
#include <stdio.h>
int main(){
    int n;
    scanf("%d", &n);// leio quantidade

    int pilha[100];

    int topo = -1;
    for(int i = 0; i < n; i++){
        char comando[10];
        scanf("%s", comando);// leio o comando

        if(comando[0] == 'P' && comando[1] == 'U'){
            int x;
            scanf("%d", &x);

            topo = topo + 1;
            pilha[topo] = x;
        }else if(comando[0] == 'P'){
            if(topo == -1){
                printf("EMPTY\n");
            }else{
                topo --;
            }
        }else{
            if(topo == -1){
                printf("EMPTY");
            }else{
                int menor = pilha[0];
                for(int j = 1; j <= topo; j ++){
                    if(pilha[j] < menor){
                        menor = pilha[j];
                    }
                }
                printf("%d\n", menor);
            }
        }
    }
    return 0;
}
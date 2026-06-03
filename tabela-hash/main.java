// hash com area de reserva
int hash(int x){
    return x % m;
}
array[n + m];

void inserir(int x){
    int pos = hash(x);// pego a posicao que vou inserir

    if(array[pos] == -1){// se tiver livre insiro nele
        array[pos] = x;
    }else{
        for(int i = n; i < n + m; i++){// caso a posicao na hash estiver cheia, entro na area de reserva e vou ate alguma posicao livre para inserir o elemento
            if(array[i] == -1){
                array[i] = x;
                break;
            }
        }
    }
}
boolean pesquisar(int x){
    int pos = hash(x);// pego a posicao certa do elemento
    if(array[pos] == x){// se estiver na tabela hash ja retorno
        return true;
    }else if(array[pos] == -1){// se na tabela estiver vazio onde ele deveria estar, retorno falso
        return false;
    }else{
        for(int i = n; i < n + m; i++){//vou para a area de reserva procurar
            if(array[i] == x){
                return true;// achei
            }
        }
        return false;// nao achei
    }
}

void inserir(int x){
    int pos = hash(x);// pego a posicao

    if(array[pos] == -1){// se onde ele deveria estar estiver vazio, ja insiro la
        array[pos] = x;
    }else{
        for(int i = n; i < n + m; i++){// se nao vou ate a area de reserva e procuro um lugar vazio para inserir
            if(array[i] == -1){
                array[i] = x;
                break;
            }
        }
    }
}


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

void remover(int x){
    int pos = hash(x);

    if(array[pos] == x){
        array[pos] = -1;
    }else{
        for(int i = x; i < n + m; i ++){
            if(array[i] == x){
                array[i] = -1;
                break;
            }
        }
    }
}


// hash direta com rehash
int hash(int x){
    return x % tamTabela;
}
int rehash(int x){
    return ++x % tamTabela;
}

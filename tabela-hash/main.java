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
    int pos = hash(x);// pego a posicao

    if(array[pos] == x){// se estiver na tabela eu removo
        array[pos] = -1;
    }else{
        for(int i = x; i < n + m; i ++){// se nao eu procuro ele na area de reserva e removo
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
    return (x + 1) % tamTabela;
}

void inserir(int x){
    int pos = hash(x);// pego a posicao

    if(array[pos] == -1){// se na posicao estiver vazia eu insiro ele la
        array[pos] = x;
    }else{// ja tinha elemento la
        pos = rehash(x);// dou um rehash nele
        if(array[pos] == -1){// vejo se a posicao apos o rehash esta vazia
            array[pos] = x;// insiro
        }
        // se ela tambem estiver ocupada nao faco nada
    }
}

boolean pesquisar(int x){
    int pos = hash(x);// pego a posicao

    if(array[pos] == x){// se encontrei na posicao principal retorno verdadeiro
        return true;
    }else{
        pos = rehash(x);// se nao encontrei, dou um rehash e procuro nele
        if(array[pos] == x){
            return true;
        }
    }
    return false;// nao encontrei em nenhuma das posicoes
}

void remover(int x){
    int pos = hash(x);// pego a posicao

    if(array[pos] == x){// se ele estiver na principal, removo
        array[pos] = -1;
    }else{
        pos = rehash(x);// se nao eu verifico a posicao de rehash
        if(array[pos] == x){// se ele estiver la eu removo
            array[pos] = -1;
        }
    }
}
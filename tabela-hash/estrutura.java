// t1 = hash principal
// se der colisao -> vai para uma posicao da area virtual t2
// t2[0] -> hash com rehash(t3), t2[1] -> lista flexivel, t2[2] -> arv0re binaria
// apos descobrir a posicao em t2 o elemento e enviado para a estrutura correspondente
// se cair em t2[0], tento inserir na hash, se der colisao dou um rehash, e se der colisao com o rehash insiro na arvore binaria de reserva de t3

void inserir(int x){
    int pos = hash(x);// calculo a posicao principal em T1

    if(T1[pos] == -1){// verifico posicao livre
        T1[pos] = x;
    }else{
        int reserva = hashT2(x); // descubro em qual estrutura de t2 colocar

        if(reserva == 0){// mando para a hash de t3
            t3.inserir(x);
        }else if(reserva == 1){// mando para a lista flexivel
            lista.inserirFim(x);
        }else{
            arvore.inserir(x);// insiro na arvore
        }
    }
}

boolean pesquisar(int x){
    int pos = hash(x);

    if(T1[pos] == x){
        return true;
    }

    int reserva = hashT2(x);

    if(reserva == 0){
        return T3.pesquisar(x);
    }else if(reserva == 1){
        return lista.pesquisar(x);
    }else{
        return arvore.pesquisar(x)
    }
}

// METODOS T3

void inserir(int x){
    int pos = hash(x);// descubro a posicao

    if(tabela[pos] == -1){// vejo se a posicao do hash ta livre
        tabela[pos] = x;
    }else{
        pos = rehash(x);
        if(tabela[pos] == -1){// verifico se a posicao do rehash ta livre
            tabela[pos] = x;
        }else{
            raiz = inserirArvore(x, raiz);// insiro na arvore de reserva
        }
    }
}

boolean pesquisar(int x){
    int pos = hash(x);

    if(tabela[pos] == x){
        return true;
    }
    pos = rehash(x);
    if(tabela[pos] == x){
        return true;
    }

    return pesquisarArvore(x,raiz);
}

void remover(int x){
    int pos = hash(x);

    if(tabela[pos] == x){
        tabela[pos] = -1;
    }else{
        pos = rehash(x);
        if(tabela[pos] == x){
            tabela[pos] = -1;
        }else{
            raiz = removerArvore(x,raiz);
        }
    }
}

// METODOS LISTA FLEXIVEL (primeiro,ultimo, prox)
void inserirFim(int x){
    ultimo.prox = new Celula(x);// crio uma celula apos o ultimo
    ultimo = ultimo.prox;// ultimo recebe a nova
}

boolean pesquisar(int x){
    for(Celula i = primeiro; i < ultimo.prox; i = i.prox){
        if(i.elemento == x){
            return true;
        }
    }
    return false;
}

void remover(int x){
    Celula ant = primeiro;// comeco na celula cabeca

    Celula i = primeiro.prox;// primeiro elemento valido

    while(i != null && i.elemento != x){
        ant = i;
        i = i.prox;
    }

    if(i != null){
        ant.prox = i.prox;
        if(i == ultimo){
            ultimo = ant;
        }
    }
}

// METODOS ARVORE BINARIA DE PESQUISA
public void inserir(int x){
    raiz = inserir(raiz,x);
}

private No inserir(No i, int x){
    if(i == null){// encontrei a posicao livre
        i = new No(x);
    }else if(x < i.elemento){
        i.esq = inserir(i.esq, x);
    }else if(x > i.elemento){
        i.dir = inserir(i.dir, x);
    }

    return i;
}

public boolean pesquisar(int x){
    return pesquisar(raiz, x);
}

private boolean pesquisar(No i, int x){
    if(i == null){
        return false;// nao encontrei
    }else if(x == i.elemento){
        return true;
    }else if(x < i.elemento){
        return pesquisar(i.esq, x);
    }else{
        return pesquisar(i.dir,x);
    }
}

public void remover(int x){
    raiz = remover(raiz, x);
}

private No remover(No i, int x){
    if(i == null){// nao encontrei
        return null;
    }else if(x < i.elemento){
        i.esq = remover(i.esq, x);
    }else if(x > i.elemento){
        i.dir = remover(i.dir, x);
    }else if(i.dir == null){// sem filho a direita
        i = i.esq;
    }else if(i.esq == null){// sem filho a esquerda
        i = i.dir;
    }else{// possui 2 filhos
        i.esq = maiorEsq(i, i.esq);
    }
}

private No maiorEsq(No i,No j){
    if(j.dir == null){// encontrei o maior da esquerda
        i.elemento = j.elemento;// copio para o no removido
        j = j.esq;// removo o antigo maior
    }else{
        j.dir = maiorEsq(i,j.dir);
    }
    return j;
}
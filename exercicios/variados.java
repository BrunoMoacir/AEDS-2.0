// lista de pilhas-> contar o total de elementos
public int totalElementos(){
    int total = 0;// contagem de elementos
    for(CelulaLista i = inicio; i != null; i = i.prox){// percorro a lista (cada no tem uma pilha)

        CelulaPilha p = i.topo;// pego o topo da pilha atual

        while(p != null){// percorro ela
            total ++;// conto os elementos
            p = p.prox;// avanco
        }
    }
    return total;// retorno total
}

// lista de pilhas -> retornar a pilha com mais elementos
public int maiorPilha(){
    CelulaLista resp = inicio;// guarda a pilha com maior tamanho

    int maior = 0;// guarda o tamanho da maior pilha

    for(CelulaLista i = inicio; i != null; i = i.prox){// percorro a lista
        int cont = 0;// contador de elementos da pilha
        CelulaPilha p = i.topo;// pego o primeiro elemento da pilha

        while(p != null){// conto os elementos da pilha
            cont++;
            p = p.prox;
        }
        if(cont > maior){// se a contagem for maior que a contagem da maior pilha eu faco a troca
            resp = p;
            maior = cont;
        }
    }
    return resp;
}

// fazer um metodo de inserir no fim na lista dupla circular
public void inserirFim(int x){
    CelulaDupla* nova = novaCelulaDupla(x);// crio uma nova celula

    CelulaDupla* ultimo = primeiro->ant;//pego o ultimo (na fila circular ele fica atras do primeiro)

    nova->prox = primeiro;// nova aponta para o primeiro
    nova->ant = ultimo;// nova aponta pro antigo ultimo

    ultimo->prox = nova;// antigo ultimo aponta pra nova
    primeiro->ant = nova;// primeiro aponta de volta para a nova
}

// contar os numeros pares na matriz flexivel
public int contaPares(){
    int count = 0;
    CelulaLinhaAtual = inicio;

    for(int i = 0; i < linha.; i++){
        Celula colunaAtual = linha;
        for(int j = 0;j < coluna; j++){
            if(i.elemento % 2 == 0){
                count ++;
            }
            colunaAtual = colunaAtual.dir;
        }
        linhaAtual = linhaAtual.inf;
    }
    return count;
}

// na lista dupla, remover todos os elementos negativos (primeiro,ultimo,prox,ant)
public void removeNegativos(){
    CelulaDupla i = primeiro.prox;// pego o primeiro elemento depois da cabeça

    while(i != null){// varro ela toda
        if(i.elemento < 0){// s o elemento for menor que 0
            i.ant.prox = i.prox;

            if(i.prox == null){
                i.prox.ant = i.ant;
            }else{
                ultimo = i.ant;// se era o ultimo
            }
        }
        i = i.prox;
    }
}

// na matriz flexivel, somar apenas as bordas(inicio,inf,sup,dir,esq)
public int somaBorda(){
    int soma = 0;

    Celula linha = inicio;
    int i = 0;
    while(linha != null){
        Celula col = linha;
        int j = 0;

        while(col != null){
            if(i == 0 || i == this.linha - 1|| j == 0 || j == this.linha - 1){
                soma+= col.elemento;
            }
            col = col.dir;
            j++;
        }
        linha = linha.inf;
        i++;
    }
    return soma;
}

// na matriz flexivel, encontrar o maior elemento
public int maiorElemento(){
    Celula linha = inicio;

    int maior = inicio.elemento;

    while(linha != null){

        Celula col = linha;

        while(col != null){
            if(col.elemento > maior){
                maior = col.elemento;
            }
            col = col.dir;
        }
        linha = linha.inf;
    }
    return maior;
}

// lista de matrizes, somo todos os elementos de todas as matrizes-> lista(primeiro,ultimo,prox) matriz(inicio,elemento,esq,inf,dir,sup)
public int somaMatrizes(){
    int soma = 0 ;

    for(CelulaLista i = inicio; i != null; i = i.prox){

        Matriz m = i.matriz;

        Celula linha = m.inicio;

        while(linha != null){
            Celula col = linha;

            while(col != null){
                soma += col.elemento;
                col = col.dir;
            }
            linha = linha.inf;
        }
    }
    return soma;
}

// lista de pilhas -> contar quantas pilhas estao vazias
public int contVazias(){
    int count = 0;

    for(Celula i = inicio; i != null; i = i.prox){
        if(i.topo == null){
            count ++;
        }
}

//lista de pilhas -> contar quantas pilhas tem mais de 3 elementos
public int cont3Elementos(){
    int resp = 0;

    for(Celula i = inicio; i != null; i = i.prox){
        int count = 0;

        CelulaPilha p = i.topo;

        while(p != null){
            count ++;
            p = p.prox;
        }
        if(count > 3){
            resp ++;
        }
    }
    return resp;
}

// lista dupla -> somas elementos cujos valores estejam entre 10 e 50(primeiro,ultimo,prox,ant)
public int somaElementos(){
    int soma = 0;

    for(CelulaDupla i = inicio.prox; i != null; i = i.prox){
        if(i.elemento > 9 && i.elemento < 51){
            soma += i.elemento;
        }
    }
    return soma;
}

// matriz flexivel -> somar apenas elementos impares(inicio,dir,esq,inf,sup)
public int somaImpares(){
    int soma = 0;

    Celula linha = inicio;
    while(linha != null){
        Celula col = linha;
        while(col != null){
            if(col.elemento % 2 != 0){
                soma += col.elemento;
            }
            col = col.dir;
        }
        linha = linha.inf;
    }
    return soma;
}

// matriz flexivel -> verificar se existe um numero x (busca)
public boolean existe(int x){
    boolean presente = falso;

    Celula linha = inicio;
    while(linha != null){
        Celula col = linha;
        while(col != null){
            if(col.elemento == x){
                presente = true;
            }
            col = col.dir;
        }
        linha = linha.inf;
    }
    return presente;
}

// lista de matrizes -> contar quantos pares tem
public int contaPares(){
    int count = 0;
    for(CelulaLista i = inicio; i != null; i = i.prox){
        Matriz m = i.matriz;

        Celula linha = m.inicio;
        while(linha != null){
            Celula col = linha;
            while(col != null){
                if(col.elemento % 2 == 0){
                    count ++;
                }
                col = col.dir;
            }
            linha = linha.inf;
        }
    }
    return count;
}


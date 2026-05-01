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

// lista de filas -> contar quantos elementos tem no total
public int contaElementos(){
    int count = 0;

    for(CelulaLista i = inicio; i != null; i = i.prox){

        // cada NO tem uma fila
        CelulaFila f = i.primeiro;// inicio da fila

        while(f != null){
            count ++;
            f = f.prox;
        }
    }
    return total;
}

// lista de matrizes -> somar apenas as diagonais principais
public int somaDiagonal(){
    int soma = 0;

    for(int CelulaLista i = inicio; i != null; i = i.prox){

        Matriz m = i.matriz;

        Celula c = m.inicio;

        while(c != null){
            soma += c.elemento;

            c = c.inf;// ando com ele 1 para baixo
            if(c != null){// se ele nao for null apos andar p baixo eu ando p direita, mantendo o principio da diagonal principal
                c = c.dir;
            }
        }
    }
    return soma;
}

// ----- ARVORE BINARIA DE PESQUISA-----\\ 
// contar os nós da arvore
public int contarNos(){
    return contarNos(raiz);
}
public int contarNos(No i){
    if(i == null){
        return 0;
    }

    return 1 + contarNos(i.esq) + contarNos(i.dir);// eu conto esse no + esquerda + direita
}

// ALTURA DA ARVORE
public int altura(){
    return altura(raiz);
}
public int altura(No i){
    if(i == null){
        return -1;// base
    }
    int esq = altura(i.esq);
    int dir = altura(i.dir);

    if(esq > dir){
        return 1 + esq;
    }else{
        return 1 + dir;
    }

}

// lista de filas -> retornar quantas filas possuem pelo menos 1 elemento impar
public int contaImpar(){
    int count = 0;

    for(CelulaLista i = primeiro; i != null; i = i.prox){
        CelulaFila f = i.topo;

        boolean impar = false;

        while(f != null){
            if(f.elemento % 2 != 0){
                impar = true;
                break;
            }
            f = f.prox;
        }
        if(impar){
            return count ++;
        }
    }
    return count;
}

// lista dupla-> verificar se a lista esta em ordem crescente
public boolean crescente(){
    for(Celula i = primeiro; i != null && i.prox != null; i = i.prox){
        if(i.elemento > i.prox.elemento){
            return false;
        }
    }
    return true;
}

// matriz flexivel -> contar quantos elementos sao maiores que a media da matriz
publuc int maiorMedia(){
    int count = 0;
    int soma = 0;

    int elementoMaior = 0;

    Celula linha = inicio;
    while(linha != null){
        Celula col = linha;
        while(col != null){
            soma += col.elemento;
            count ++;
            col = col.dir
        }
        linha = linha.inf;
    }

    int media = soma / count;

    linha = inicio;
    while(linha != null){
        col = linha;
        while(col != null){
            if(col.elemento > media){
                elementoMaior ++;
            }
            col = col.dir;
        }
        linha = linha.inf;
    }
    return elementoMaior;
}

// lista de matrizes -> quantas possuem pelo menos 1 numero negativo
public int contaNegativo(){
    int count = 0;

    for(CelulaLista i = inicio; i != null; i = i.prox){
        Matriz m = i.matriz;

        boolean temNegativo = false;

        Celula linha = m.inicio;
        while(linha != null){
            Celula col = linha;
            while(col != null){
                if(col.elemento < 0){
                    temNegativo = true;
                    break;
                }
                col = col.dir;
            }
            linha = linha.inf;
        }
        if(temNegativo){
            count ++;
        }
    }
    return count;
}

// verificar se 2 arvores sao espelho uma da outra
public boolean isEspelho(No a, No b){
    if(a == null && b == null){
        return true;
    }

    if(a == null || b == null){
        return false;
    }

    if(a.elemento != b.elemento){
        return false;
    }

    return isEspelho(a.esq,b.dir) %% isEspelho(a.dir,b.esq);
}

// lista flexivel -> inserir um elemento x antes de cada numero impar
public void insereX(int x){
    Celula ant = primeiro;// referencia
    Celula i = primeiro.prox;// referencia

    while(i != null){
        if(i.elemento % 2 != 0){// se o elemento for impar
            Celula tmp = new Celula(x);// crio a nova celula

            ant.prox = tmp;
            tmp.prox = i;

            ant = tmp;
        }
        ant = i;
        i = i.prox;
    }
}

// pilha flex -> retornar quantos elementos sao maiores que a media -> prox, topo, elemento
public int maiores(){
    int count = 0;
    int soma = 0;

    for(Celula i = topo; i != null; i = i.prox){
        soma += i.elemento;
        
        count ++
    }

    int media = 0;
    media = soma / count;

    count = 0;

    for(Celula j = topo; j != null; i = i.prox){
        if(i.elemento > media){
            count ++;
        }
    }
    return count;
}


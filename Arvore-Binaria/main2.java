public int contaElementos(int x){
    return contaElementos(x,raiz);
}

public int contaElementos(int x, No i){
    int soma = 0;
    if(i == null){
        return 0;
    }else if(i.elemento == x){
        CelulaPilha p = i.topo;

        while(p != null){
            soma += p.elemento;

            p = p.prox;
        }
        return soma;
    }else if(x < i.elemento){
        return contaElementos(x,i.esq);
    }else{
        return contaElementos(x, i.dir);
    }
}

// arvores de pilhas -> somar todos os elementos de todas as pilhas
public int somaElementos(){
    return somaElementos(raiz);
}
public int somaElementos(No i){
    if(i == null){
        return 0;
    }

    int soma = 0;

    CelulaPilha p = i.topo;// percorro a pilha do no atual
    while(p != null){
        soma += p.elemento;
        p = p.prox;
    }

    return soma + somaElementos(i.esq) + somaElementos(i.dir);//somo esquerda + direita
}

// contar multiplos de 3 nas pilhas
public int contarMultiplos(){
    return contarMultiplos(raiz);
}
public int contarMultiplos(No i){
    if(i == null){
        return 0;
    }

    int count = 0;

    CelulaPilha p = i.topo;
    while(p != null){
        if(p.elemento % 3 == 0){
            count ++;
        }
        p = p.prox;
    }

    return count + contarMultiplos(i.esq) + contarMultiplos(i.dir);
}

// retornar o tamanho da MAIOR pilha da arvore
public int maiorPilha(){
    return maiorPilha(raiz);
}
public int maiorPilha(No i){
    if(i == null){
        return 0;
    }

    int tamanho = 0;

    CelulaPilha p = i.topo;

    while(p != null){
        tamanho ++;
        p = p.prox;
    }// calculo tamanho da pilha

    int esq = maiorPilha(i.esq);// faco o mesmo para esquerda
    int dir = maiorPilha(i.dir);// faco o mesmo para direita

    if(esq > maior){
        maior = esq;
    }
    if(dir > maior){
        maior = dir;
    }
    return maior;// retorno o maior
}

// arvore de listas -> contar quantas tem tamanho par
public int contaPar(){
    return contaPar(raiz);
}
public int contaPar(No i){
    if(i == null){
        return 0;
    }

    int count = 0;

    int tamanho = 0;

    for(Celula j = i.primeiro; j != null; j = j.prox){
        tamanho ++;
    }

    if(tamanho % 2 == 0){
        count = 1;
    }

    return count + contaPar(i.esq) + contaPar(i.dir);
}

// arvore de filas -> somar os elementos impares de todas as filas
public int somaImpar(){
    return somaImpar(raiz);
}
public int somaImpar(No i){
    if(i == null){
        return 0;
    }

    int total = 0;

    for(Celula j = i.primeiro; j != null; j = j.prox){
        if(j.elemento % 2 != 0){
            total += j.elemento;
        }
    }
    return total + somaImpar(i.esq) + somaImpar(i.dir);
}

// arvore de pilhas -> quantos nos possuem pilhas com pelo menos 1 elemento negativo
public int contaNo(){
    return contaNo(raiz);
}
public int contaNo(No i){
    if(i == null){
        return 0;
    }

    int qtNegativo = 0;

    for(Celula j = i.topo; j != null; j = j.prox){
        if(j.elemento < 0){
            qtNegativo = 1;
        }
    }
    
    return qtNegativo + contaNo(i.esq) + contaNo(i.dir);
}

// arvore de listas -> retornar a quantidade de elementos que tem em todas as arvores
public int contaElementos(){
    return contaElementos(raiz); 
}
public int contaElementos(No i){
    if(i == null){
        return 0;
    }

    int count = 0;

    CelulaLista l = i.primeiro;
    while(l != null){
        count ++;
        l = l.prox;
    }

    return count + contaElementos(i.esq) + contaElementos(i.dir);
}

//arvore de pilhas -> retorno quantos nos possuem pilha com numero PAR de elementos
public int contaNo(){
    return contaNo(raiz);
}
public int contaNo(No i){
    if(i == null){
        return 0;
    }

    int contador = 0;

    int pilhaPar = 0;

    CelulaPilha p = i.topo;
    while(p != null){
        contador ++;
        p = p.prox;
    }

    if(contador % 2 == 0 && contador != 0){// tiro pilha vazia
        pilhaPar = 1;
    }

    return pilhaPar + contaNo(i.esq) + contaNo(i.dir);
}

// ver se em algum no da lista tem o valor x
public boolean existe(int x){
    return boolean existe(x, raiz);
}
public boolean existe(int x, No i){
    if(i == null){
        return false;
    }

    for(CelulaLista j = primeiro; j != null; j = j.prox){
        if(j.elemento == x){
            return true;
        }
    }

    if(existe(x, i.esq)){
        return true;
    }
    if(existe(x, i.dir)){
        return true;
    }
    
    return false;
}

//lista de pilhas -> retornar celula com maior pilha  lista(primeiro,ultimo,prox) pilha(topo,prox)
public int maiorPilha(){
    CelulaLista resp = inicio;
    int maior = 0;
    for(CelulaLista i = inicio.prox; i != null; i = i.prox){
        int count = 0;
        CelulaPilha p = i.topo;
        while(p != null){
            count ++;
            p = p.prox;
        }
        if(count > maior){
            maior = count;
            resp = i;
        }
    }
    return resp;
}

// no de lista com soma > 100 recursivamente
public int maiorQue100(){
    return maiorQue100(raiz);
}
public int maiorQue100(No i){
    if(i == null){
        return 0;
    }
    int soma = 0;
    for(CelulaLista j = primeiro; j != null; j = j.prox){
        soma += j.elemento;
    }
    int resp = 0;
    if(soma > 100){
        resp = 1;
    }
    return resp + maiorQue100(i.esq) + maiorQue100(i.dir);
}


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


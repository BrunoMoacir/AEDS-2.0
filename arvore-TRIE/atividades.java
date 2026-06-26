// na trie de hash perfeita, contar quantos nos possuem letra minuscula
public int contarMinusculas(){
    return contarMinusculas(raiz);
}
private int contarMinusculas(No no){
    int count = 0;// zera a cada iteracao
    if(no.elemento <= 'a' && no.elemento <= 'z'){// verifico o no atual 
        count ++;
    }
    for(int i = 0; i < no.prox.length; i++){
        if(no.prox[i] != null){
            count += contarMinusculas(no.prox[i]);// somo o resultado do filho
        }
    }
    return count;
}

// na trie hash perfeita, contar quantos nos possuem exatamente um filho
public int contarUmFilho(){
    return contarUmFilho(raiz);
}
private int contarUmFilho(No no){
    int count = 0;// contador de nos com um filho
    int filhos = 0;// contador de filho do no

    for(int i = 0; i < no.prox.length; i++){// conto os filhos
        if(no.prox[i] != null){
            filhos ++;
        }
    }

    if(filhos == 1){
        count ++;
    }

    for(int i = 0; i < no.prox.length; i++){// visito todos os filhos
        if(no.prox[i] != null){
            count += contarUmFilho(no.prox[i]);
        }
    }
    return count;
}

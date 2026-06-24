// na TRIE hash perfeita, contar quantos nos possuem a letra 'A'

public int contarAs(){
    return contarAs(raiz);
}

private int contarAs(No no){
    int resp = 0;

    if(no.elemento == 'A'){
        resp ++;
    }

    for(int i = 0; i < no.prox.length; i++){
        if(no.prox[i] != null){
            resp += contarAs(no.prox[i]);
        }
    }
    return resp;
}

// na trie contar quantas palavras tem
public int contarPalavras(){
    return contarPalavras(raiz);
}

private int contarPalavras(No no){
    int resp = 0;
    if(no.folha){
        resp ++;
    }

    for(int i = 0; i < no.prox.length; i++){
        if(no.prox[i] == null){
            resp += contarPalavras(no.charAt[i]);
        }
    }

    return resp;
}

// TRIE lista flexivel
// contar quantos nos existem na trie
// cada vez que visito um no, eu conto 1, e depois visito os filhos
public int contarNos(){
    return contarNos(raiz);
}
private int contarNos(No no){
    int resp = 1;
    No[] filhos = no.getFilho();
    for(int i = 0; i < filhos.length; i++){
        resp += contarNos(filhos[i]);
    }
    return resp;
}

// contar quantas folhas existem
public int contarFolhas(){
    return contarFolhas(raiz);
}
private int contarFolhas(No no){
    int resp = 0;// inicializo

    if(no.folha){
        resp ++;
    }

    No[] filhos = no.getFilho();

    for(int i = 0; i < filhos.length; i++){
        resp += contarFolhas(filhos[i]);
    }

    return resp;
}

// TRIE na arvore binaria de pesquisa
// contar quantos nos possuem letra maior que M
public int contarMaior(){
    return contarMaior(raiz);
}
private int contarMaior(No no){
    int resp = 0;

    if(no.elemento > 'M'){
        resp ++;
    }

    No[] filhos = no.getFilho();

    for(int i = 0; i < filho.length; i++){
        resp += contarMaior(filho[i]);
    }

    return resp;
}
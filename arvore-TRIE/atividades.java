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

// na trie de lista flexivel contar quantos nos possuem letra maior que M
public int maiorQueM(){
    return maiorQueM(raiz);
}
private int maiorQueM(No no){
    int resp = 0;

    if(no.elemento > 'M'){// verificacao da condicao
        resp ++;// incremento
    }

    No [] filhos = no.getFilhos();
    for(int i = 0; i < filhos.length; i++){// verifico tudo recursivamente
        resp += maiorQueM(filhos[i]);
    }
    return resp;
}
public int tamanho(){
    int tam = 0;
    for(Celula i = 0; i != null; i = i.prox){
        tam ++;
    }
    return tam;
}
public No[] getFilhos(){
    int tam = tamanho();
    No[] resp = new No[tam];// crio vetor do tamanho do tamanho
    int j = 0;
    for(Celula i = 0; i != null; i = i.prox){
        resp[j] = i.no;// copio no da lista pro vetor
        j++;
    }
    return resp;
}

// na trie ABB contar quantas palavras possuem tamanho maior que 5
public int contarMaiorQue5(No no, int nivel){
    int resp = 0;
    if(no.folha){
        if(nivel > 5){
            resp ++;
        }
    }

    No [] filhos = no.getFilho();
    for(int i = 0; i < filho.length; i++){
        resp += contarMaiorQue5(filhos[i], nivel + 1);
    }
    return resp;
}
public int tamanho(){
    return tamanho(raiz);
}
private int tamanho(NoABB no){
    int resp = 0;
    if(no != null){
        resp = 1;// conto atual
        resp += tamanho(no.esq);
        resp += tamanho(no.dir);
    }
    return resp;
}
public No [] getFilho(){
    int tam = tamanho;
    No [] resp = new No[tam];
    preencher(resp,raiz,0);// preencho vetor em ordem
    return resp;
}
public int preencher(No [] resp, NoABB no, int pos){
    if(no != null){
        pos = preencher(resp,no.esq, pos);// esquerda
        resp[pos] = no.elemento;
        pos ++;
        pos = preencher(resp,no.dir,pos);// direita
    }
}

// na avl retornar true ou falso se todos os nos estao balanceados
public boolean todosBalanceados(){
    return todosBalanceados(raiz);
}
private boolean todosBalanceados(No i){
    boolean resp = true;
    if(i != null){
        int fb = altura(i.esq) - altura(i.dir);// calculo o fator de balanceamento
        if(fb < 0){
            fb *= -1;// passo o fator para positivo caso ele seja negativo
        }

        if(fb > 1){
            resp = false;
        }else{
            resp = todosBalanceados(i.esq);

            if(resp){// se pra esquerda ta tudo balanceado olho a direita
                resp = todosBalanceados(i.dir);
            }
        }
    }
    return resp;
}

// na alvinegra implementar metodo que retorna verdadeiro caso nenhum no vermelho tenha filho vermelho
public boolean verificaFilho(){
    return verificaFilho(raiz);
}
private boolean verificaFilho(No i){
    boolean resp = true;
    if(i != null){
        if(i.cor == false){// verifico apenas cor vermelha
            if(i.esq != null && i.esq.cor == false){// se tem filho a esquerda e ele é vermelho
                resp = false;
            }
            if(i.dir != null && i.dir.cor == false){// se tem filho a direita e ele e vermelho
                resp = false;
            }
        }
        resp = verificaFilho(i.esq);// vejo todos da esquerda
        if(resp){// se resp ainda for true verifico os da direita
            resp = verificaFilho(i.dir);
        }
    }
    return resp;
}

// na alvinegra contar os nos vermelhos
public int contarVermelhos(No i){
    int count = 0;
    if(i != null){
        if(i.cor == false){
            count ++;
        }
        count += contarVermelhos(i.esq);
        count += contarVermelhos(i.dir);
    }
    return count;
}

// na trie hash contar quantas palavras terminam com vogal
public int contaVogal(){
    return contaVogal(raiz);
}
private int contaVogal(No no){
    int resp = 0;
    if(no.folha){// so verifico o final das palavrasv (sao marcados como boolean folha = true)
        if(no.elemento == 'A' || no.elemento == 'E' || no.elemento == 'I' || no.elemento == 'O' || no.elemento == 'U'){
            resp ++;
        }
    }
    for(int i = 0; i < no.prox.length; i++){
        if(no.prox[i] != null){
            resp += contaVogal(no.prox[i]);
        }
    }
    return resp;
}

// na trie lista contar quantos nos possuem exatamente 3 filhos
public int contaTresFilhos(){
    return contaTresFilhos(raiz);
}
private int contaTresFilhos(No no){
    int resp = 0;
    No [] filhos = no.getFilho();// transformo a lista em vetor

    if(filhos.length == 3){// se tiver exatamente 3 filhos
        resp ++;
    }

    for(int i = 0; i < filhos.length; i++){// visito cada filho
        resp += contarTresFilhos(filhos[i]);
    }
    return resp;
}
// metodo aux getFilho da lista
public No [] getFilho(){
    int tam = tamanho();
    No [] resp = new No [tam];// crio exatamente do tamanho

    int j = 0;
    for(Celula i = primeiro.prox; i != null; i = i.prox){
        resp[j] = i.no;// copio da lista pro vetor
        j ++;
    }
}
// metodo aux tamanho
public int tamanho(){
    int tam = 0;
    for(Celula i = primeiro.prox; i != null; i = i.prox){
        tam ++;
    }
    return tam;
}
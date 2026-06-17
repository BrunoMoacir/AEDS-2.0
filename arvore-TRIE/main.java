public boolean pesquisar(String s) throws Exception{
    return pesquisar(s,raiz,0);//comeco a pesquisa olhando a primeira letra (posicao 0)
}
private boolean pesquisar(String s, No no, int i){
    boolean resp;// variavel de retorno

    if(no.prox[s.charAt(i)] == null){//verifico se existe um filho correspondente a letra s.charAt(i)
        resp = false;// nao existe, entao nao esta na TRIE
    }else if(i == s.length() - 1){// se existe filho e estou na ultima letra da palavra
        resp = (no.prox[s.charAt(i)].folha == true);// a palavra so existe se o no encontrado estiver marcado como o fim da palavra (folha)
    }else if(i < s.length() - 1){// se existe o filho e ainda tem letras para analisar
        resp = pesquisar(s,no.prox[s.charAt(i)], i + 1);// continuo a pesquisa descendo para o proximo no e avancando para a proxima letra da palavra
    }else{// caso impossivel
        throw new Exception("Erro");
    }

    return resp;
}
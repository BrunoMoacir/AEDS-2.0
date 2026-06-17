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
// insercao na trie
//1. verifico se ja existe um filho com essa letra
// se nao, crio o no
// se for a ultima letra, marco como folha = true
// caso contrario desco para o proximo nivel
public void inserir(String s) throws Exception{
    inserir(s,raiz,0);
}
private void inserir(String s, No no, int i)throws Exception{
    if(no.prox[s.charAt(i)] == null){// se o filho correspondente atual a letra nao existe
        no.prox[s.charAt(i)] = new No(s.charAt(i));// crio o no da letra
        if(i == s.length() = 1){// se essa e a ultima letra da palavra
            no.prox[s.charAt(i)].folha = true;// marco como fim de palavra
        }else{
            inserir(s,no.prox[s.charAt(i)], i + 1);// continuo inserindo o restante da palavra
        }
    }else if(no.prox(s.charAt[i].folha == false && i < s.length() - 1){// se o filho ja existe e ainda há letras para inserir
        inserir(s,no.prox[s.charAt(i)], i + 1);// continuo descendo a arvore
    }else{
        throw new Exception("Erro");// palavra ja existe ou algo deu errado
    }
}

// a ideia do mostrar é enquanto desce na arvore ele vai montando a palavra em uma String s
// quando encontra um no com folha == true ele imprime a palavra completa
public void mostrar(){
    mostrar("", raiz);// comeca o percurso na raiz, a string comeca vazia
}
private void mostrar(String s, No no){
    if(no.folha == true){// se chegar no final imprimo
        System.out.println("Palavra: " + (s + no.elemento));
    }else{
        for(int i = 0; i < no.prox.length; i++){// percorro todos os filhos do no atual
            if(no.prox[i] != null){// se existe um filho na posicao
                mostrar(s + no.elemento, no.prox[i]);// continuo o percurso adicionando a letra atual na string
            }
        }
    }
}
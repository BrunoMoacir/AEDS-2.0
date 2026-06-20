public void inserir(String s) throws Exception{
    inserir(s,raiz,0);
}
private void inserir(String s, No no, int i)throws Exception{
    No filho = no.pesquisar(s.charAt(i));// procuro a letra atual entre os filhos
    if(filho == null){// se nao encontrei
        filho = no.inserir(s.charAt(i));// crio novo filho
        if(i == s.length() -1){//se for a ultima letra
            no.setFilhoFolha(S.charAt(i));// marco como folha = true, fim de palavra
        }else{// continuo inserindo
            inserir(s,filho, i + 1);
        }
    }else if(filho.folha == false && i < s.length() -1){// filho ja existe e tem mais letra
        inserir(s,filho,i + 1);
    }else{
        throw new Exception("erro");
    }
}

public boolean pesquisar(String s){
    return pesquisar(s,raiz,0);
}

private boolean pesquisar(String s, No no, int i){
    boolean resp;

    No filho = no.pesquisar(s.charAt(i));// procuro a letra entre os filhos
    if(filho == null){// nao encontrei
        resp = false;
    }else if(i = s.length() -1){
        resp = filho.folha;// so existe se a ultima letra for folha
    }else{// continuo procurando
        resp = pesquisar(s,filho,i + 1);
    }
    return resp;
}
class CelulaDupla{
    public CelulaDupla(int x) {}
    int elemento;
    CelulaDupla ant;
    CelulaDupla prox;
}
public void inserirInicio(int x){
    CelulaDupla tmp = new CelulaDupla(x);

    tmp.ant = primeiro;
    tmp.prox = primeiro.prox;
    primeiro.prox = tmp;
    if(primeiro == ultimo){
        ultimo = tmp;
    }else{
        tmp.prox.ant = tmp;
    }
    tmp = null;
}
public void inserirFim(int x){
    ultimo.prox = new CelulaDupla(x);
    ultimo.prox.ant = ultimo;
    ultimo = ultimo.prox;
}
public int removerInicio() throws Exception{
    if(primeiro == ultimo){
        throw new Exception("Erro");
    }
    CelulaDupla tmp = primeiro;
    primeiro = primeiro.prox;
    int elemento = primeiro.elemento;
    tmp.prox = primeiro.ant = null;
    return elemento;
}
public void removerFim() throws Exception{
    if(primeiro == ultimo){
        throw new Exception("Erro");
    }
    int resp = ultimo.elemento;
    ultimo = ultimo.ant;
    ultimo.prox.ant = null;
    ultimo.prox =null;
    return resp;
}

public void mostrar(){
    System.out.println("[");
    for(CelulaDupla i = primeiro.prox; i != null; i = i.prox){
        System.out.println(i.elemento + " "););
    }
    System.out.println("[");
}

public void mostrarInverso(){
    System.out.println("[");
    for(CelulaDupla i = ultimo; i != primeiro; i = i.ant){
        System.out.println(i.elemento + " ");
    }
    System.out.println("]");
}

public boolean pesquisar(int x){
    boolean existe = false;
    for(CelulaDupla i = primeiro.prox; i != null; i = i.prox){
        if(i.elemento = x){
            existe = true;
        }
    }
    return existe;
}

public int tamanho(){
    int tamanho = 0;
    for(CelulaDupla i = primeiro; i != ultimo; i = i.prox){
        tamanho ++;
    }
    return tamanho;
}

public void inverteElementos(){
    CelulaDupla i = primeiro.prox;
    CelulaDupla j = ultimo;
    while(i != j && j.prox != i){
        int tmp = i.elemento;// guardo elemento de i
        i.elemento = j.elemento;// pego o de j e copio no i
        j.elemento = tmp;// coloco o elemento de i no j

        i = i.prox;
        j = j.ant;
    }
}

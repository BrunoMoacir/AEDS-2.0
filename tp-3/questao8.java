import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Util{// base para todo o tp2
    public static int paraInt(String s){
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res = res * 10 + (s.charAt(i) - '0');// converto o caractere 5 no numero inteiro 5 usando a tabela ascii, 
        }
        return res;// retorno o inteiro 
    }
    public static double paraDouble(String s){
        double res = 0;
        double div = 1;
        boolean dpsPonto = false;//ponto para saber se ja passei do ponto decimal

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '.'){
                dpsPonto = true;
            }else{
                if(!dpsPonto){// se ainda for a parte inteira, continuo
                    res = res * 10 + (c - '0');
                } else{// se for a parte fracionaria divido por 10 -> 100 ...
                    div *= 10;
                    res = res + (double)(c - '0') / div;
                }
            }
        }
        return res;// retorno o double
    }
    public static String[] extrairCampos(String s, char sep){
        int cont = 1;// conto quantas palavras vao sair
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == sep){
                cont ++;
            }
        }

        String[] partes = new String[cont];// crio o array com o tamanho certo
        int idx = 0;// ponteiro de onde no array estou preenchendo
        String atual = "";// palavra que to montando letra por letra

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == sep){
                partes[idx++]= atual;// quando acho o separador salvo a palavra no array
                atual = "";// limpo a string para comecar a montar a nova palavra
            }else{
                atual += c;// se nao for o separador continuo montando a palavra
            }
        }
        partes[idx] = atual;// salvo o pedaco da palavra q sobrou no final
        return partes;
    }
}

// CLASSE DE ENTIDADE (data, hora, restaurante)
class Data{
    private int ano,mes,dia;

    public Data(){}
    public int getAno(){
        return ano;
    }
    public void setAno(int ano){
        this.ano = ano;
    }
    public int getMes(){
        return mes;
    }
    public void setMes(int mes){
        this.mes = mes;
    }
    public int getDia(){
        return dia;
    }
    public void setDia(int dia){
        this.dia = dia;
    }

    public static Data parseData(String s){
        Data d = new Data();

        String[] p = Util.extrairCampos(s, '-');// uso meu util para cortar a data no formato certo

        // uso o util para transformar pedacos de texto em numeros
        d.setAno(Util.paraInt(p[0]));
        d.setMes(Util.paraInt(p[1]));
        d.setDia(Util.paraInt(p[2]));
        return d;
    }

    public String formatar(){
        return String.format("%02d/%02d/%04d", dia,mes,ano);// preencho com 0 a esqueda o que for preciso
    }
}

class Hora{
    private int hora,minuto;

    public Hora(){}

    public int getHora(){
        return hora;
    }
    public void setHora(int hora){
        this.hora = hora;
    }
    public int getMinuto(){
        return minuto;
    }
    public void setMinuto(int minuto){
        this.minuto = minuto;
    }

    public static Hora parseHora(String s){
        Hora h = new Hora();

        String[] p = Util.extrairCampos(s, ':');// corto a string no formato hh:mm com os dois pontos
        h.setHora(Util.paraInt(p[0]));
        h.setMinuto(Util.paraInt(p[1]));
        return h;
    }

    public String formatar(){
        return String.format("%02d:%02d", hora,minuto);
    }
}

class Restaurante{
    private int id,capacidade,faixaPreco;
    private String nome, cidade;
    private double avaliacao;
    private String[] tiposCozinha;
    private Hora hAb, hFe;
    private Data dAb;
    private boolean aberto;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public double getAvaliacao(){
        return avaliacao;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public void setCapacidade(int capacidade){
        this.capacidade = capacidade;
    }
    public void setAvaliacao(double avaliacao){
        this.avaliacao = avaliacao;
    }
    public void setTiposCozinha(String[] tc){
        this.tiposCozinha = tc;
    }
    public void setFaixaPreco(int fp){
        this.faixaPreco = fp;
    }
    public void setHAb(Hora h){
        this.hAb = h;
    }
    public void setHFe(Hora h){
        this.hFe = h;
    }
    public void setDAb(Data d){
        this.dAb = d;
    }
    public void setAberto(boolean a){
        this.aberto = a;
    }

    public static Restaurante parseRestaurante(String s){
        Restaurante r = new Restaurante();

        String[] p = Util.extrairCampos(s, ',');// corto a linha do csv pelas virgulas

        r.setId(Util.paraInt(p[0]));
        r.setNome(p[1]);
        r.setCidade(p[2]);
        r.setCapacidade(Util.paraInt(p[3]));
        r.setAvaliacao(Util.paraDouble(p[4]));

        r.setTiposCozinha(Util.extrairCampos(p[5], ';'));// corto pelo ponto e virgula

        r.setFaixaPreco(p[6].length());// pego o tamanho da string(ja e a faixa d preco)

        String[] h = Util.extrairCampos(p[7], '-');// o bloco de horario e separado pelo traco
        r.setHAb(Hora.parseHora(h[0]));
        r.setHFe(Hora.parseHora(h[1]));

        r.setDAb(Data.parseData(p[8]));

        if(p[9].compareTo("true") == 0){
            r.setAberto(true);
        }else{
            r.setAberto(false);
        }
        return r;
    }

    public String formatar(){
        // monto o array de cozinhas
        String tc = "[";
        for(int i = 0; i < tiposCozinha.length; i++){
            tc += tiposCozinha[i];
            if(i < tiposCozinha.length - 1){// so coloco virgula se nao for o ultimo
                tc += ",";
            }
        }
        tc += "]";

        // monto a faixa de preco e concateno o $
        String fp = "";
        for(int i = 0; i < faixaPreco; i++){
            fp += "$";
        }

        String abStr;// transformo o boolean em palavra
        if(aberto){
            abStr = "true";
        }else{
            abStr = "false";
        }

        return String.format("[%d ## %s ## %s ## %d ## %s ## %s ## %s ## %s-%s ## %s ## %s]",id, nome, cidade, capacidade, ""+avaliacao, tc, fp, hAb.formatar(), hFe.formatar(), dAb.formatar(), abStr);
    }
}

// COLECAO RESTAURANTES
class ColecaoRestaurantes{
    private int n;// contador de restaurantes
    private Restaurante[] lista;

    public ColecaoRestaurantes(){// construtor
        n = 0;
        lista = new Restaurante[1000];// coloquei limite alto, qqr coisa melhoro dps 
    }

    public int getTamanho(){
        return n;
    }
    public Restaurante[] getRestaurantes(){
        return lista;
    }

    public void lerCsv(String path)throws Exception{
        Scanner sc = new Scanner(new File(path));

        if(sc.hasNextLine()) sc.nextLine();// pulo o cabecalho da primeira linha

        while(sc.hasNextLine()){
            String linha = sc.nextLine();
            if(linha.length() > 0){
                String limpa = "";// limpeza para tirar o \r se preciso (enter)
                for(int i = 0; i < linha.length(); i++){
                    if(linha.charAt(i) != '\r'){
                        limpa += linha.charAt(i);
                    }
                }
                lista[n++] = Restaurante.parseRestaurante(limpa);// salvo o restaurante no espaco atual e avanco o ponteiro
            }
        }
        sc.close();
    }
}

class CelulaDupla{
    public Restaurante elemento;
    public CelulaDupla ant;// ponteiro para celula anterior
    public CelulaDupla prox;// ponteiro para proxima celula

    public CelulaDupla(){
        this(null);
    }
    public CelulaDupla(Restaurante elemento){
        this.elemento = elemento;
        this.ant=this.prox = null;
    }
}

class ListaDupla{
    private CelulaDupla primeiro;// no cabeca
    private CelulaDupla ultimo;
    private int tamanho;

    public ListaDupla(){
        primeiro = new CelulaDupla();// cria o no cabeca vazio
        ultimo = primeiro;
        tamanho = 0;
    }

    public void inserirInicio(Restaurante r){
        CelulaDupla tmp = new CelulaDupla(r);// insiro depois do no cabeca

        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        if(primeiro == ultimo){
            ultimo = tmp;// caso a lista teja vazia ele e o primeiro e o ultimo
        }else{
            tmp.prox.ant = tmp;// o antigo primeiro agora aponta para o novo 
        }
        tamanho ++;
    }

    public void inserirFim(Restaurante r){
        ultimo.prox = new CelulaDupla(r);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
        tamanho ++;
    }

    public void inserir(Restaurante r, int pos) throws Exception{// caminho ate a posicao e abro espaco
        if(pos < 0 || pos > tamanho){
            throw new Exception("erro");
        }
        if(pos == 0){
            inserirInicio(r);
        }else if(pos == tamanho){
            inserirFim(r);
        }else{
            CelulaDupla i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);// vou ate o no anterior a posicao desejada

            CelulaDupla tmp = new CelulaDupla(r);
            tmp.ant = i;
            tmp.prox = i.prox;
            tmp.ant.prox = tmp;
            tmp.prox.ant = tmp;
            tamanho ++;
        }
    }

    public Restaurante removerInicio() throws Exception{// removo quem esta a seguir do no cabeca
        if(primeiro == ultimo){
            throw new Exception("erro");
        }

        CelulaDupla tmp = primeiro.prox;
        Restaurante resp = tmp.elemento;

        primeiro.prox = tmp.prox;
        if(primeiro.prox != null){
            primeiro.prox.ant = primeiro;
        }else{
            ultimo = primeiro;// esvaziou a lista
        }

        tmp.prox = tmp.ant = null;// corto as ligacoes
        tamanho --;

        System.out.println("(R)" + resp.getNome());
        return resp;
    }

    public Restaurante removerFim() throws Exception{
        if(primeiro == ultimo){
            throw new Exception("erro");
        }

        Restaurante resp = ultimo.elemento;// guardo o elemento

        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;
        tamanho --;// diminuo o tamanho

        System.out.println("(R)" + resp.getNome());
        return resp;
    }

    public Restaurante remover(int pos) throws Exception{// vou ate o no e desvio os ponteiros em volta dele
        if(primeiro == ultimo || pos < 0 || pos >= tamanho){
            throw new Exception("erro");
        }
        if(pos == 0){// se a posicao for 0 encaminho para o remover inicio
            return removerInicio();
        }else if(pos == tamanho - 1){// se a pos for a final encaminho para o remover final
            return removerFim();
        }else{
            CelulaDupla i = primeiro.prox;
            for(int j = 0; j < pos; j++, i = i.prox);// caminho ate o no remover

            Restaurante resp = i.elemento;

            // anterior aponta para o prox e o prox aponta para o anterior
            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            i.prox = i.ant = null;
            tamanho --;

            System.out.println("(R)" + resp.getNome());
            return resp;
        }
    }

    // imprimo  lista do inicio ao fim
    public void mostrar(){
        for(CelulaDupla i = primeiro.prox; i != null; i = i.prox){
            System.out.println(i.elemento.formatar());
        }
    }
}

public class questao8{
    public static Restaurante buscarPorId(ColecaoRestaurantes col, int id){;// busco pelo id
        for(int i = 0; i < col.getTamanho(); i++){//ando tudo
            if(col.getRestaurantes()[i].getId() == id){
                return col.getRestaurantes()[i];// retorno o id se achar
            }
        }
        return null;// se andei tudo e nao achei retorno null
    }

    public static void main(String[] args)throws Exception {
        ColecaoRestaurantes col = new ColecaoRestaurantes();
        col.lerCsv("/tmp/restaurantes.csv");

        Scanner sc = new Scanner(System.in);

        ListaDupla lista = new ListaDupla();// crio nova lista

        while(sc.hasNext()){
            String idBusca = sc.next();// pego o id enquanto for diferente de -1
            if(idBusca.compareTo("-1") == 0){
                break;
            }
            int id = Util.paraInt(idBusca);// transformo de string para int
            Restaurante r = buscarPorId(col, id);

            if(r != null){
                lista.inserirFim(r);// insiro no fim 1a fase
            }
        }
        int numOperacoes = Util.paraInt(sc.next());// leio a qt de operacoes

        for(int i = 0; i < numOperacoes; i++){// rodo o quanto de vezes li
            String comando = sc.next();// leio o comando

            if(comando.compareTo("II") == 0){// se for ii eu insiro no inicio
                int id = Util.paraInt(sc.next());
                lista.inserirInicio(buscarPorId(col,id));
            }else if(comando.compareTo("I*") == 0){// se for i eu insiro em qualquer posicao
                int pos = Util.paraInt(sc.next());
                int id = Util.paraInt(sc.next());
                lista.inserir(buscarPorId(col, id),pos);
            }else if(comando.compareTo("IF") == 0){// if eu insiro no fim
                int id = Util.paraInt(sc.next());
                lista.inserirFim(buscarPorId(col, id));
            }else if(comando.compareTo("RI") == 0){// ri eu removo no inicio
                lista.removerInicio();
            }else if(comando.compareTo("R*") == 0){// r* eu removo na posicao
                int pos = Util.paraInt(sc.next());
                lista.remover(pos);
            }else if(comando.compareTo("RF") == 0){// rf eu removo no fim
                lista.removerFim();
            }
        }
        lista.mostrar();// mostro a lista resultante
    }
}
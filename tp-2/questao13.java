import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Util {// base para todo o tp2
    public static int paraInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 10 + (s.charAt(i) - '0');// converto o caractere 5 no numero inteiro 5 usando a tabela ascii,
        }
        return res;// retorno o inteiro
    }

    public static double paraDouble(String s) {
        double res = 0;
        double div = 1;
        boolean dpsPonto = false;// ponto para saber se ja passei do ponto decimal

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                dpsPonto = true;
            } else {
                if (!dpsPonto) {// se ainda for a parte inteira, continuo
                    res = res * 10 + (c - '0');
                } else {// se for a parte fracionaria divido por 10 -> 100 ...
                    div *= 10;
                    res = res + (double) (c - '0') / div;
                }
            }
        }
        return res;// retorno o double
    }

    public static String[] extrairCampos(String s, char sep) {
        int cont = 1;// conto quantas palavras vao sair
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == sep) {
                cont++;
            }
        }

        String[] partes = new String[cont];// crio o array com o tamanho certo
        int idx = 0;// ponteiro de onde no array estou preenchendo
        String atual = "";// palavra que to montando letra por letra

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == sep) {
                partes[idx++] = atual;// quando acho o separador salvo a palavra no array
                atual = "";// limpo a string para comecar a montar a nova palavra
            } else {
                atual += c;// se nao for o separador continuo montando a palavra
            }
        }
        partes[idx] = atual;// salvo o pedaco da palavra q sobrou no final
        return partes;
    }
}

// CLASSE DE ENTIDADE (data, hora, restaurante)
class Data {
    private int ano, mes, dia;

    public Data() {
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public static Data parseData(String s) {
        Data d = new Data();

        String[] p = Util.extrairCampos(s, '-');// uso meu util para cortar a data no formato certo

        // uso o util para transformar pedacos de texto em numeros
        d.setAno(Util.paraInt(p[0]));
        d.setMes(Util.paraInt(p[1]));
        d.setDia(Util.paraInt(p[2]));
        return d;
    }

    public String formatar() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);// preencho com 0 a esqueda o que for preciso
    }
}

class Hora {
    private int hora, minuto;

    public Hora() {
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public static Hora parseHora(String s) {
        Hora h = new Hora();

        String[] p = Util.extrairCampos(s, ':');// corto a string no formato hh:mm com os dois pontos
        h.setHora(Util.paraInt(p[0]));
        h.setMinuto(Util.paraInt(p[1]));
        return h;
    }

    public String formatar() {
        return String.format("%02d:%02d", hora, minuto);
    }
}

class Restaurante {
    private int id, capacidade, faixaPreco;
    private String nome, cidade;
    private double avaliacao;
    private String[] tiposCozinha;
    private Hora hAb, hFe;
    private Data dAb;
    private boolean aberto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setTiposCozinha(String[] tc) {
        this.tiposCozinha = tc;
    }

    public void setFaixaPreco(int fp) {
        this.faixaPreco = fp;
    }

    public void setHAb(Hora h) {
        this.hAb = h;
    }

    public void setHFe(Hora h) {
        this.hFe = h;
    }

    public void setDAb(Data d) {
        this.dAb = d;
    }

    public void setAberto(boolean a) {
        this.aberto = a;
    }

    public Hora getHAb() {
        return hAb;
    }

    public Hora getHFe() {
        return hFe;
    }

    public Data getDAb() {
        return dAb;
    }

    public static Restaurante parseRestaurante(String s) {
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

        r.setAberto(false);

        for (int i = 0; i < p[9].length(); i++) {
            if (p[9].charAt(i) == 't' || p[9].charAt(i) == 'T') {
                r.setAberto(true);
            }
        }
        return r;
    }

    public String formatar() {
        // monto o array de cozinhas
        String tc = "[";
        for (int i = 0; i < tiposCozinha.length; i++) {
            tc += tiposCozinha[i];
            if (i < tiposCozinha.length - 1) {// so coloco virgula se nao for o ultimo
                tc += ",";
            }
        }
        tc += "]";

        // monto a faixa de preco e concateno o $
        String fp = "";
        for (int i = 0; i < faixaPreco; i++) {
            fp += "$";
        }

        String abStr;// transformo o boolean em palavra
        if (aberto) {
            abStr = "true";
        } else {
            abStr = "false";
        }

        return String.format("[%d ## %s ## %s ## %d ## %s ## %s ## %s ## %s-%s ## %s ## %s]", id, nome, cidade,
                capacidade, "" + avaliacao, tc, fp, hAb.formatar(), hFe.formatar(), dAb.formatar(), abStr);
    }
}

class Fila{
    private Restaurante[] array;
    private int primeiro,ultimo;
    private int tamanhoFisico;

    public Fila(int tamanhoDesejado){
        tamanhoFisico = tamanhoDesejado + 1;// pede tamanho 5, entao o array precisa de 6
        array = new Restaurante[tamanhoFisico];
        primeiro = 0;
        ultimo = 0;
    }

    public Restaurante remover() throws Exception{
        if(primeiro == ultimo){
            throw new Exception("Erro");// fila vazia
        }
        Restaurante resp = array[primeiro];

        primeiro = (primeiro + 1) % tamanhoFisico;// ando em circulo com o primeiro

        System.out.println("(R" + resp.getNome());

        return resp;
    }

    public void inserir(Restaurante r) throws Exception{
        if(((ultimo + 1) % tamanhoFisico) == primeiro){// caso a fila circular estiver cheia
            remover();// removo o mais antigo para colocar outro
        }

        array[ultimo] = r;

        ultimo = (ultimo + 1) % tamanhoFisico;// ando em circulo com o ultimo
        // calculo da media
        int soma = 0;
        int cont = 0;
        int i = primeiro;

        while(i != ultimo){// varro a fila circular ate chegar no ultimo el
            soma += array[i].getDAb().getAno();
            cont ++;
            i = (i + 1) % tamanhoFisico;
        }

        int div = soma / cont;// pego a divisao sem decimal
        int resto = soma % cont;// pego o que sobrou

        int media = div;

        if(resto * 2 >= cont){// arredondo caso seja preciso
            media ++;
        }

        System.out.println("(I)" + media);
    }

    public void mostrar(){
        int i = primeiro;
        while(i != ultimo){
            System.out.println(array[i].formatar());
            i = (i + 1) % tamanhoFisico;
        }
    }
}

public class questao13{
    public static Restaurante buscarPorId(ColecaoRestaurantes col, int id){
        for(int i = 0; col.getTamanho(); i++){
            if(col.getRestaurantes()[i].getId() == id){
                return col.getRestaurantes()[i];
            }
        }
        return null;
    }

    public static void main(String[] args)throws Exception {
        ColecaoRestaurantes col = new ColecaoRestaurantes();
        col.lerCsv("/tmp/restaurantes.csv");

        Scanner sc = new Scanner(System.in);

        Fila fila = new Fila(5);// crio fila de tamanho 5

        while(sc.hasNext()){
            String idBusca = sc.next();
            if(idBusca.compareTo("-1") == 0){
                break;
            }
            int id = Util.paraInt(idBusca);// transformo a string para int
            Restaurante r = buscarPorId(col, id);

            if(r != null){
                fila.inserir(r);// insiro e ela mesmo ja trata remocao
            }
        }

        int numOperacoes = Util.paraInt(sc.next());

        for(int i = 0; i < numOperacoes; i++){
            String comando = sc.next();

            if(comando.compareTo("I") == 0){// comando inserir
                int id = Util.paraInt(sc.next());// leio o id
                fila.inserir(buscarPorId(col, id));// insiro depois de buscar
            } else if(comando.compareTo("R") == 0){
                fila.remover();// chamo esse remover pq implementei o print ja nele
            }
        }
        sc.close();

        fila.mostrar();// mostro a fila resultante
    }
}
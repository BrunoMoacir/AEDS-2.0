import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

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

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

        if (p[9].compareTo("true") == 0) {
            r.setAberto(true);
        } else {
            r.setAberto(false);
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

// COLECAO RESTAURANTES
class ColecaoRestaurantes {
    private int n;// contador de restaurantes
    private Restaurante[] lista;

    public ColecaoRestaurantes() {// construtor
        n = 0;
        lista = new Restaurante[1000];// coloquei limite alto, qqr coisa melhoro dps
    }

    public int getTamanho() {
        return n;
    }

    public Restaurante[] getRestaurantes() {
        return lista;
    }

    public void lerCsv(String path) throws Exception {
        Scanner sc = new Scanner(new File(path));

        if (sc.hasNextLine())
            sc.nextLine();// pulo o cabecalho da primeira linha

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha.length() > 0) {
                String limpa = "";// limpeza para tirar o \r se preciso (enter)
                for (int i = 0; i < linha.length(); i++) {
                    if (linha.charAt(i) != '\r') {
                        limpa += linha.charAt(i);
                    }
                }
                lista[n++] = Restaurante.parseRestaurante(limpa);// salvo o restaurante no espaco atual e avanco o
                                                                 // ponteiro
            }
        }
        sc.close();
    }
}

class No{
    public Restaurante elemento;
    public No esq, dir;
    public int nivel;// calculo balanceamento

    public No(Restaurante elemento){
        this(elemento,null,null,1);
    }

    public No(Restaurante elemento, No esq, No dir, int nivel){
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
    }

    public void setNivel(){// calculo o nivel do no
        int nivelEsq = getNivel(esq);
        int nivelDir = getNivel(dir);
        int maiorNivel = nivelEsq;

        if(nivelDir > nivelEsq){
            maiorNivel = nivelDir;
        }

        this.nivel = 1 + maiorNivel;
    }

    public static int getNivel(No no){
        if(no == null){
            return 0;
        }else{
            return no.nivel;
        }
    }
}

class AVL{
    private No raiz;

    public AVL(){
        raiz = null;
    }

    public void pesquisar(String nome){
        System.out.print("raiz ");
        pesquisar(nome,raiz);
    }

    private void pesquisar(String nome, No i){
        if(i == null){
            System.out.println("NAO");// nao achei
        }else{
            questao1.comparacoes ++;// incremento
            int cmp = nome.compareTo(i.elemento.getNome());

            if(cmp == 0){ // achei
                System.out.println("SIM");
            }else if(cmp < 0){
                System.out.print("esq ");// vou para esquerda
                pesquisar(nome,i.esq);// chamada rec
            }else{
                System.out.print("dir ");// vou para direita
                pesquisar(nome, i.dir);
            }
        }
    }

    public void inserir(Restaurante x)throws Exception{
        raiz = inserir(x, raiz);
    }

    private No inserir(Restaurante x, No i) throws Exception{
        if(i == null){
            i = new No (x);// crio novo no
        }else{
            int cmp = x.getNome().compareTo(i.elemento.getNome());

            if(cmp < 0){
                i.esq = inserir(x, i.esq);
            }else if(cmp > 0){
                i.dir = inserir(x, i.dir);
            }else{

            }
        }
        return balancear(i);
    }

    private No balancear(No no)throws Exception{
        if(no != null){
            int fator = No.getNivel(no.dir) - No.getNivel(no.esq);

            if(fator >= -1 && fator <= 1){
                no.setNivel();// se balanceada
            }else if(fator == 2){// se desbalanceada para a direita
                int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);
                if(fatorFilhoDir == -1){
                    no.dir = rotacionarDir(no.dir);
                }
                no = rotacionarEsq(no);
            }else if(fator == -2){// se desbalanceada para a esquerda
                int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);
                if(fatorFilhoEsq == 1){
                    no.esq = rotacionarEsq(no.esq);
                }
                no = rotacionarDir(no);
            }else{
                throw new Exception("Erro no No com fator de balanceamento (" + fator + ") invalido!");
            }
        }
        return no;
    }

    private No rotacionarDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;
        
        no.setNivel(); 
        noEsq.setNivel(); 

        return noEsq;
    }

    private No rotacionarEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        no.setNivel(); 
        noDir.setNivel(); 
        return noDir;
    }

    public void caminharEmOrdem() {
        caminharEmOrdem(raiz);
    }

    private void caminharEmOrdem(No i) {
        if (i != null) {
            caminharEmOrdem(i.esq);
            System.out.println(i.elemento.formatar());
            caminharEmOrdem(i.dir);
        }
    }
}

public class questao1{
    public static int comparacoes = 0;

    public static Restaurante buscarPorId(ColecaoRestaurantes col, int id){
        for(int i = 0; i < col.getTamanho(); i++){
            if(col.getRestaurantes()[i].getId() == id){
                return col.getRestaurantes()[i];
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception{
        ColecaoRestaurantes col = new ColecaoRestaurantes();
        col.lerCsv("/tmp/restaurantes.csv");

        Scanner sc = new Scanner(System.in);
        AVL arvore = new AVL();

        while(sc.hasNext()){// insercao na arvore
            String idBusca = sc.next();
            if(idBusca.compareTo("FIM") == 0 || idBusca.compareTo("-1") == 0){
                break;
            }

            int id = Util.paraInt(idBusca);
            Restaurante r = buscarPorId(col, id);
            
            if(r != null){
                arvore.inserir(r);
            }
        }

        long inicioTempo = System.currentTimeMillis();// comeco a marcar

        while(sc.hasNextLine()){
            String nomeBusca = sc.nextLine();

            if(nomeBusca.length() == 0){
                continue;
            }

            if(nomeBusca.compareTo("FIM") == 0){
                break;
            }

            arvore.pesquisar(nomeBusca);
        }

        long fimTempo = System.currentTimeMillis();// termino

        long tempoTotal = fimTempo - inicioTempo;

        arvore.caminharEmOrdem();// impressao final em ordem

        sc.close();

        FileWriter writer = new FileWriter("885492_arvore_avl.txt");
        writer.write("885492\t" + comparacoes + "\t" + tempoTotal + "\n");
        writer.close();
    }
}
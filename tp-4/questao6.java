import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public int getCapacidade(){
        return capacidade;
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

class NoAVL{
    public Restaurante elemento;
    public NoAVL esq, dir;
    public int nivel;// guardo p calcular nivel balanceamento

    public NoAVL(Restaurante elemento){
        this(elemento,null,null,1);
    }

    public NoAVL(Restaurante elemento, NoAVL esq, NoAVL dir, int nivel){
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
    }

    public void setNivel(){
        int nivelEsq = getNivel(esq);// pego altura esquerda
        int nivelDir = getNivel(dir);// pego altura direita
        int maiorNivel = nivelEsq;

        if(maiorNivel < nivelDir){
            maiorNivel = nivelDir;
        }

        this.nivel = 1 + maiorNivel;// calculo o nivel certo
    }

    public static int getNivel(NoAVL no){
        if(no == null){
            return 0;
        }
        return no.nivel;
    }
}

class AVL{
    private NoAVL raiz;

    public AVL(){
        raiz = null;// comeca vazia
    }

    public Restaurante pesquisar(String nome){
        System.out.print("raiz ");// comeco a procurar pela avl
        return pesquisar(nome,raiz);
    }

    public Restaurante pesquisar(String nome, NoAVL i){
        if(i == null){
            return null;// nao achei
        }else{
            questao6.comparacoes ++;// incremento

            int cmp = nome.compareTo(i.elemento.getNome());

            if(cmp == 0){
                return i.elemento;// achei e retorno ele
            }else if(cmp < 0){
                System.out.print("esq ");
                return pesquisar(nome,i.esq);
            }else {
                System.out.print("dir ");
                return pesquisar(nome,i.dir);
            }
        }
    }
    public void inserir(Restaurante x) throws Exception{
        raiz = inserir(x, raiz);
    }

    private NoAVL inserir(Restaurante x, NoAVL i) throws Exception{
        if(i == null){
            i = new NoAVL(x);// achei o espaco crio o no
        }else{
            int cmp = x.getNome().compareTo(i.elemento.getNome());

            if(cmp < 0){
                i.esq = inserir(x, i.esq);
            }else if(cmp > 0){
                i.dir = inserir(x, i.dir);
            }
            // se fgor igual ignoro e nao faco nada
        }
        return balancear(i);// arrumo a arvore na volta
    }

    private NoAVL balancear(NoAVL no) throws Exception{
        if(no != null){
            int fator = NoAVL.getNivel(no.dir) - NoAVL.getNivel(no.esq);//calculo o fator

            if(fator >= -1 && fator <= 1){
                no.setNivel();// arovre balanceara, atualizo o nivel
            }else if(fator == 2){
                int fatorFilhoDir = NoAVL.getNivel(no.dir.dir) - NoAVL.getNivel(no.dir.esq);
                if (fatorFilhoDir == -1) {
                    no.dir = rotacionarDir(no.dir); // rotacao dupla
                }
                no = rotacionarEsq(no); // rotacao simples
            } else if (fator == -2) { // desbalanceou p esquerda
                int fatorFilhoEsq = NoAVL.getNivel(no.esq.dir) - NoAVL.getNivel(no.esq.esq);
                if (fatorFilhoEsq == 1) {
                    no.esq = rotacionarEsq(no.esq); // rotacao dupla
                }
                no = rotacionarDir(no); // rotacao simples
            } else {
                throw new Exception("Erro fator");
            }
        }
        return no;
    }

    private NoAVL rotacionarDir(NoAVL no) {
        NoAVL noEsq = no.esq;
        NoAVL noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        no.setNivel();    // arrumo o nivel de quem desceu
        noEsq.setNivel(); // arrumo o nivel de quem subiu
        return noEsq;     // retorno a nova raiz desse pedaco
    }

    private NoAVL rotacionarEsq(NoAVL no) {
        NoAVL noDir = no.dir;
        NoAVL noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        no.setNivel();    // arrumo o nivel de quem desceu
        noDir.setNivel(); // arrumo o nivel de quem subiu
        return noDir;     // retorno a nova raiz desse pedaco
    }
}

class No{
    public int chave;
    public AVL subArvore;// a arvore avl
    public No esq, dir;

    public No(int chave){
        this.chave = chave;
        this.subArvore = new AVL();// inicializo a avl vazia assim q crio o no
        this.esq = null;
        this.dir = null;
    }
}

class ArvoreArvore{
    private No raiz;

    public ArvoreArvore(){
        raiz = null;
    }

    public void inserir(Restaurante r) throws Exception {
        int chave = r.getCapacidade() % 15; // calculo a gaveta principal usando modulo
        raiz = inserir(chave, r, raiz);
    }

    private No inserir(int chave, Restaurante r, No i) throws Exception {
        if (i == null) {
            i = new No(chave); // crio o no principal se a gaveta nao existir
            i.subArvore.inserir(r); // coloco o restaurante na avl q acabei de criar
        } else if (chave < i.chave) {
            i.esq = inserir(chave, r, i.esq); // procuro a gaveta na esquerda
        } else if (chave > i.chave) {
            i.dir = inserir(chave, r, i.dir); // procuro a gaveta na direita
        } else {
            i.subArvore.inserir(r); // a gaveta ja existe! so jogo o restaurante na avl dela
        }
        return i;
    }

    public void pesquisar(String nome) {
        System.out.print("RAIZ "); // comeca no no principal (maiusculo pq e a arvore de fora)
        Restaurante r = pesquisar(nome, raiz);

        if (r != null) {
            System.out.println("SIM " + r.formatar()); // achou e imprime com a formatacao final
        } else {
            System.out.println("NAO"); // varreu todas arvores e nao achou nada
        }
    }

    private Restaurante pesquisar(String nome, No i) {
        if (i == null) {
            return null; // cheguei no fim da arvore principal
        }

        // 1. procuro na avl do no principal q to agora
        Restaurante r = i.subArvore.pesquisar(nome);
        if (r != null) {
            return r; // se achei nela corto o caminho e volto c o restaurante
        }

        // 2. se nao tava na avl atual, tento descer p esquerda
        System.out.print("ESQ ");
        r = pesquisar(nome, i.esq);
        if (r != null) {
            return r; // se achou em algum lugar da esquerda, vai voltando
        }

        // 3. se nao tava na esquerda, so sobra tentar a direita
        System.out.print("DIR ");
        r = pesquisar(nome, i.dir);
        return r; // retorna o q achar na direita (seja o restaurante ou null)
    }
}

public class questao6 {
    public static int comparacoes = 0; // variavel global 

    public static Restaurante buscarPorId(ColecaoRestaurantes col, int id) {
        for (int i = 0; i < col.getTamanho(); i++) {
            if (col.getRestaurantes()[i].getId() == id) {
                return col.getRestaurantes()[i];
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        ColecaoRestaurantes col = new ColecaoRestaurantes();
        col.lerCsv("/tmp/restaurantes.csv"); 

        Scanner sc = new Scanner(System.in);
        ArvoreArvore arvoreHibrida = new ArvoreArvore();

        while (sc.hasNext()) {
            String idBusca = sc.next(); // leio ate o proximo espaco
            if (idBusca.compareTo("FIM") == 0 || idBusca.compareTo("-1") == 0) {
                break; // paro de ler ids
            }

            int id = Util.paraInt(idBusca); // converto string p int
            Restaurante r = buscarPorId(col, id);
            
            if (r != null) {
                arvoreHibrida.inserir(r); // jogo na estrutura 
            }
        }

        long inicioTempo = System.currentTimeMillis(); // comeco a marcar tempo

        while (sc.hasNextLine()) {
            String nomeBusca = sc.nextLine();

            int fim = nomeBusca.length() - 1;
            while (fim >= 0 && (nomeBusca.charAt(fim) == '\r' || nomeBusca.charAt(fim) == ' ' || nomeBusca.charAt(fim) == '\n')) {
                fim--; // ando p tras ate achar a ultima letra valida
            }

            if (fim < 0) {
                continue; // lixo (deu ruim antes)
            }

            // monto a string limpa letra por letra
            String nomeLimpo = "";
            for (int i = 0; i <= fim; i++) {
                nomeLimpo += nomeBusca.charAt(i);
            }
            nomeBusca = nomeLimpo;

            if (nomeBusca.compareTo("FIM") == 0) {
                break; // termino as pesquisas
            }

            arvoreHibrida.pesquisar(nomeBusca);
        }

        long fimTempo = System.currentTimeMillis(); // termino de marcar
        long tempoTotal = fimTempo - inicioTempo;

        sc.close();

        FileWriter writer = new FileWriter("885492_hibrida_arvore_arvore.txt");
        writer.write("885492\t" + comparacoes + "\t" + tempoTotal + "\n");
        writer.close();
    }
}
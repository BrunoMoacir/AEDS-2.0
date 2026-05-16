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
    private CelulaDupla primeiro;
    private CelulaDupla ultimo;
    private int tamanho;

    public ListaDupla(){
        primeiro = new CelulaDupla();
        ultimo = primeiro;
        tamanho = 0;
    }

    public void inserirFim(Restaurante r){
        ultimo.prox = new CelulaDupla(r);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
        tamanho ++;
    }

    public void mostrar(){
        for(CelulaDupla i = primeiro.prox; i != null; i = i.prox){
            System.out.println(i.elemento.formatar());
        }
    }

    public CelulaDupla getPrimeiroReal(){
        return primeiro.prox;
    }

    public CelulaDupla getUltimo(){
        return ultimo;
    }

    public int getTamanho(){
        return tamanho;
    }
}

public class questao11{
    public static int comparacoes = 0;
    public static int movimentacoes = 0;

    public static int comparar(Restaurante r1, Restaurante r2){
        comparacoes ++;
        if(r1.getAvaliacao() < r2.getAvaliacao()){
            return -1;
        }
        if(r1.getAvaliacao() > r2.getAvaliacao()){
            return 1;
        }

        comparacoes ++;// incremento
        return r1.getNome().compareTo(r2.getNome());
    }

    public static void quicksort(int esq,int dir, CelulaDupla nodeEsq, CelulaDupla nodeDir){
        while(esq < dir){
            int i = esq, j = dir;
            CelulaDupla nodeI = nodeEsq;
            CelulaDupla nodeJ = nodeDir;

            CelulaDupla nodePivo = nodeEsq;// encontro o pivo caminhando com o ponteiro ate o meio do sub array
            for(int k = 0; k < (esq + dir) / 2 - esq; k++){
                nodePivo = nodePivo.prox;
            }
            Restaurante pivo = nodePivo.elemento;

            while(i <= j){
                while(comparar(nodeI.elemento,pivo) < 0){// caminho pela esquerda
                    nodeI = nodeI.prox;
                    i ++;
                }
                while(comparar(nodeJ.elemento, pivo) > 0){// caminho pela direita
                    nodeJ = nodeJ.ant;
                    j --;
                }
                if(i <= j){// faco o swap
                    Restaurante temp = nodeI.elemento;
                    nodeI.elemento = nodeJ.elemento;
                    nodeJ.elemento = temp;
                    movimentacoes += 3;

                    nodeI = nodeI.prox;
                    i ++;
                    nodeJ = nodeJ.ant;
                    j --;
                }
            }

            if(esq < j){// lado esquerdo
                quicksort(esq, j, nodeEsq, nodeDir);
            }

            esq = i;// lado direito vai ser no proximo ciclo do while
            nodeEsq = nodeI;
        }
    }

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
        ListaDupla lista = new ListaDupla();

        while(sc.hasNext()){
            String idBusca = sc.next();
            if(idBusca.compareTo("-1") == 0){
                break;
            }
            int id = Util.paraInt(idBusca);
            Restaurante r = buscarPorId(col, id);

            if(r != null){
                lista.inserirFim(r);
            }
        }
        sc.close();

        long inicioTempo = System.currentTimeMillis();// inicio tempo

        if(lista.getTamanho() > 0){
            quicksort(0, lista.getTamanho() - 1, lista.getPrimeiroReal(), lista.getUltimo());// chamo o quicksort passando 0, n-1, e os ponteiros
        }

        long fimTempo = System.currentTimeMillis();// paro otempo
        long tempoTotal = fimTempo - inicioTempo;// pego o tempo total

        lista.mostrar();// mostro a lista ordenada

        FileWriter writer = new FileWriter("775492_quicksort_flexivel.txt");
        writer.write("885492\t" + comparacoes + "\t" + movimentacoes + "\t" + tempoTotal + "\n");
        writer.close();
    }
}


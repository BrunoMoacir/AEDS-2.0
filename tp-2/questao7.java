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
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCidade(){
        return cidade;
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

public class questao7{
    static int comparacoes = 0;
    static int movimentacoes = 0;

    public static void mergeSort(Restaurante[] array, int esq, int dir){
        if(esq < dir){
            int meio = (esq + dir) / 2;// acho a metade
            
            mergeSort(array, esq, meio);// ordeno a metade da esquerda
            mergeSort(array,meio + 1, dir);// ordeno a metade da direita

            intercalar(array, esq, meio, dir);// junto as metades ordenadas
        }
    }
    
    public static void intercalar(Restaurante[] array, int esq, int meio, int dir){
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        Restaurante[] a1 = new Restaurante[n1];// array temporarios para guardar pedacos
        Restaurante[] a2 = new Restaurante[n2];

        for(int i = 0; i < n1; i++){// copio os dados originais para o array temporario
            a1[i] = array[esq + 1];
            movimentacoes ++;// acho que copia conta como movimentacao
        }
        for(int j = 0; j < n2; j++){
            a2[j] = array[meio + 1 + j];
            movimentacoes ++;
        }

        int i = 0, j = 0, k = esq;// ponteiros para os array temp

        while(i < n1 && j < n2){// enquanto tiver elemento dos dois lados
            comparacoes ++;
            int compCidade = a1[i].getCidade().compareTo(a2[j].getCidade());

            if(compCidade < 0){// se a cidade da esqueda for menor (alfabeto) ela desce 
                array[k++] = a1[i++];
                movimentacoes ++;
            }else if(compCidade > 0){// se a cidade da direita for menor ela desce
                array[k++] = a2[j++];
                movimentacoes ++;
            }else{// se elas forem iguais eu comparo os nomes
                comparacoes ++;
                if(a1[i].getNome().compareTo(a2[j].getNome()) <= 0){
                    array[k++] = a1[i++];
                    movimentacoes ++;
                }else{
                    array[k++] = a2[j++];
                    movimentacoes ++;
                }
            }
        }
        while(i < n1){// se sobro alguem na metade esquerda desce pro arr principal
            array[k++] = a1[i++];
            movimentacoes ++;
        }

        while(j < n2){// se sobrou alguem na metade direita desce
            array[k++] = a2[j++];
            movimentacoes ++;
        }
    }

    public static void main(String[] args)throws Exception {
        long inicioTempo = System.currentTimeMillis();

        ColecaoRestaurantes col = new ColecaoRestaurantes();
        col.lerCsv("/tmp/restaurantes.csv");

        Scanner sc = new Scanner(System.in);

        Restaurante[] array = new Restaurante[1000];
        int n = 0;

        while(sc.hasNext()){
            String idBusca = sc.next();

            if(idBusca.compareTo("-1") == 0){
                break;
            }

            int id = Util.paraInt(idBusca);

            for(int i = 0; i < col.getTamanho(); i++){
                if(col.getRestaurantes()[i].getId() == id){
                    array[n++] = col.getRestaurantes()[i];
                    break;
                }
            }
        }
        sc.close();

        mergeSort(array, 0, n - 1);

        for(int i = 0; i < n; i++){
            System.out.println(array[i].formatar());
        }

        long fimTempo = System.currentTimeMillis();
        long tempoTotal = fimTempo - inicioTempo;

        FileWriter log = new FileWriter("885492_mergesort.txt");
        log.write("885492\t" + comparacoes + "\t" + movimentacoes + "\t" + tempoTotal);
        log.close();
    }
}
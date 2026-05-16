import java.util.Scanner;

class Celula{
    public int elemento;
    public Celula inf, sup, esq, dir;// ponteiros para andar 

    public Celula(){
        this(0);
    }

    public Celula(int elemento){
        this.elemento = elemento;
        this.inf = this.sup = this.dir = this.esq = null;
    }
}

class Matriz{
    private Celula inicio;// ponteiro p celula 0,0
    private int linha,coluna;

    public Matriz(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;

        if(linha == 0 || coluna == 0){
            return;
        }

        inicio = new Celula();// crio a celula 0 0 
        Celula atual = inicio;

        for(int j = 1; j < coluna; j++){// monto a primeira linha toda
            Celula nova = new Celula();
            atual.dir = nova;
            nova.esq = atual;
            atual = nova;
        }

        Celula linhaAcima = inicio;
        for(int i = 1; i < linha; i++){// monto as outras linhas
            Celula novaLinhaInicio = new Celula();// crio o primeiro elemento da linha e junto com o de cima
            novaLinhaInicio.sup = linhaAcima;
            linhaAcima.inf = novaLinhaInicio;

            Celula atualLinha = novaLinhaInicio;
            Celula atualAcima = linhaAcima.dir;

            for(int j = 1; j < coluna; j++){//vou andandopara a direita e criando o resto da linha
                Celula nova = new Celula();

                atualLinha.dir = nova;// esq-dir
                nova.esq = atualLinha;

                nova.sup = atualAcima;// cima-baixo
                atualAcima.inf = nova;

                atualLinha = atualLinha.dir;// avanco os ponteiros
                atualAcima = atualAcima.dir;
            }
            linhaAcima = novaLinhaInicio;// desco o ponteiro guia para a prox iteracao
        }
    }

    public void ler(Scanner sc){
        Celula linha = inicio;
        while(linha != null){
            Celula atual = linha;
            while(atual != null){
                atual.elemento = sc.nextInt();
                atual = atual.dir;
            }
            linha = linha.inf;
        }
    }

    public void mostrar(){
        Celula linha = inicio;
        while(linha != null){
            Celula atual = linha;
            while(atual != null){
                System.out.println(atual.elemento + " ");
                atual = atual.dir;
            }
            System.out.println();
            linha = linha.inf;
        }
    }

    public void mostrarDiagonalPrincipal(){
        if(this.linha != this.coluna){// n e matriz quadrada
            return;
        }

        Celula atual = inicio;
        while(atual != null){
            System.out.println(atual.elemento + " ");
            atual = atual.dir;// vou para direita
            if(atual != null){// vejo se e null ou nao
                atual = atual.inf;// desco 1
            }
        }
        System.out.println();
    }

    public void mostrarDiagonalSecundaria() {
        if (this.linha != this.coluna){// vejo se e quadrada
            return;
        }

        Celula atual = inicio;
        while (atual.dir != null) {
            atual = atual.dir;// posiciono no final da primeira linha
        }

        while (atual != null) {
            System.out.print(atual.elemento + " ");// imprimo
            atual = atual.esq;// vou p esquerda
            if (atual != null) {// vejo se e valido
                atual = atual.inf;// desco
            }
        }
        System.out.println();
    }

    public Matriz somar(Matriz m){
        Matriz resp = new Matriz(this.linha, this.coluna);

        Celula ptrRespLinha = resp.inicio;
        Celula ptrA_linha = this.inicio;
        Celula ptrB_linha = m.inicio;

        while(ptrA_linha != null){
            Celula ptrResp = ptrRespLinha;
            Celula ptrA = ptrA_linha;
            Celula ptrB = ptrB_linha;

            while(ptrA != null){
                ptrResp.elemento = ptrA.elemento + ptrB.elemento;

                ptrResp = ptrResp.dir;
                ptrA = ptrA.dir;
                ptrB = ptrB.dir;
            }
            ptrRespLinha = ptrRespLinha.inf;
            ptrA_linha = ptrA_linha.inf;
            ptrB_linha = ptrB_linha.inf;
        }
        return resp;
    }

    public Matriz multiplicar(Matriz m) {
        Matriz resp = new Matriz(this.linha, m.coluna);
        
        Celula ptrRespLinha = resp.inicio;
        Celula ptrA_Linha = this.inicio;

        while (ptrA_Linha != null) {
            Celula ptrResp = ptrRespLinha;
            Celula ptrB_Coluna = m.inicio; // b vai por colunas

            while (ptrB_Coluna != null) {
                int soma = 0;
                Celula ptrA = ptrA_Linha;
                Celula ptrB = ptrB_Coluna;
                
                // Multiplica a linha de A pela coluna de B
                while (ptrA != null && ptrB != null) {
                    soma += ptrA.elemento * ptrB.elemento;
                    ptrA = ptrA.dir; // a anda p direita
                    ptrB = ptrB.inf; // b anda p baixo
                }
                ptrResp.elemento = soma;
                
                ptrResp = ptrResp.dir;
                ptrB_Coluna = ptrB_Coluna.dir; // pulo p a proxima coluna
            }
            ptrRespLinha = ptrRespLinha.inf;
            ptrA_Linha = ptrA_Linha.inf;
        }
        return resp;
    }
}

public class questao9{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(sc.hasNextInt()){
            int casos = sc.nextInt();//pego a qt de casos de teste

            for(int c = 0; c < casos; c ++){
                int l1 = sc.nextInt();
                int c1 = sc.nextInt();
                Matriz m1 = new Matriz(l1,c1);// li matriz 1
                m1.ler(sc);

                int l2 = sc.nextInt();
                int c2 = sc.nextInt();
                Matriz m2 = new Matriz(l2,c2);// li matriz 2
                m2.ler(sc);

                m1.mostrarDiagonalPrincipal();
                m2.mostrarDiagonalSecundaria();

                Matriz soma = m1.somar(m2);
                soma.mostrar();

                Matriz mult = m1.multiplicar(m2);
                mult.mostrar();
            }
        }
        sc.close();
    }
}
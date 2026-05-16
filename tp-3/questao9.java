import java.util.Scanner;

class Celula {
    public int elemento;
    public Celula inf, sup, esq, dir;// ponteiros para andar

    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        this.inf = this.sup = this.dir = this.esq = null;
    }
}

class Matriz {
    private Celula inicio;// ponteiro p celula 0,0
    private int linha, coluna;

    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;

        if (linha <= 0 || coluna <= 0)
            return;

        inicio = new Celula();// crio celula 0 0

        // monto a primeira linha
        Celula atual = inicio;
        for (int j = 1; j < coluna; j++) {
            Celula nova = new Celula();
            atual.dir = nova;// ligo esq-dir
            nova.esq = atual;
            atual = nova;
        }

        Celula linhaAnterior = inicio;// ponteiro guia

        // monto as outras linhas
        for (int i = 1; i < linha; i++) {

            Celula novaLinha = new Celula();// crio primeiro elemento da linha
            linhaAnterior.inf = novaLinha;// junto
            novaLinha.sup = linhaAnterior;

            Celula atualNova = novaLinha;
            Celula atualSup = linhaAnterior;

            for (int j = 1; j < coluna; j++) {// vou andando p direita criando o resto

                Celula nova = new Celula();

                atualNova.dir = nova;// ligo esq dir
                nova.esq = atualNova;

                atualSup = atualSup.dir;// avanco ponteiro de cima

                atualSup.inf = nova;// ligo cima baixo
                nova.sup = atualSup;

                atualNova = nova;//avanco o ponteiro da linha atual
            }

            linhaAnterior = linhaAnterior.inf;// desco o ponteiro p proxima iteracao
        }
    }

    public void ler(Scanner sc) {
        for (Celula lin = inicio; lin != null; lin = lin.inf) {
            for (Celula col = lin; col != null; col = col.dir) {
                col.elemento = sc.nextInt();
            }
        }
    }

    public void mostrar() {
    for (Celula lin = inicio; lin != null; lin = lin.inf) {
        for (Celula col = lin; col != null; col = col.dir) {
            System.out.print(col.elemento);
            if (col.dir != null) System.out.print(" ");
        }
        System.out.println();
    }
}

    public void mostrarDiagonalPrincipal() {
        if (this.linha != this.coluna) {// nao e matriz quadrada
            return;
        }

        Celula atual = inicio;
        while (atual != null) {
            System.out.print(atual.elemento);
            atual = atual.dir;// vou para direita
            if (atual != null) {// vejo se e null ou nao
                atual = atual.inf;// desco 1
                if(atual != null){
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }

    public void mostrarDiagonalSecundaria() {
        if (this.linha != this.coluna) {// vejo se e quadrada
            return;
        }

        Celula atual = inicio;
        while (atual.dir != null) {
            atual = atual.dir;// posiciono no final da primeira linha
        }

        while (atual != null) {
            System.out.print(atual.elemento);// imprimo
            atual = atual.esq;// vou p esquerda
            if (atual != null) {// vejo se e valido
                atual = atual.inf;// desco
                if(atual != null){
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }

    public Matriz somar(Matriz m) {
        Matriz resp = new Matriz(this.linha, this.coluna);

        Celula ptrRespLinha = resp.inicio;
        Celula ptrA_linha = this.inicio;
        Celula ptrB_linha = m.inicio;

        while (ptrA_linha != null) {
            Celula ptrResp = ptrRespLinha;
            Celula ptrA = ptrA_linha;
            Celula ptrB = ptrB_linha;

            while (ptrA != null) {
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

public class questao9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int casos = sc.nextInt();// pego a qt de casos de teste
            for (int c = 0; c < casos; c++) {

                int l1 = sc.nextInt();
                int c1 = sc.nextInt();
                Matriz m1 = new Matriz(l1, c1);// crio e leio a matriz 1
                m1.ler(sc);

                Matriz m2 = new Matriz(l1, c1);
                m2.ler(sc);

                m1.mostrarDiagonalPrincipal();// diagonal principal m1
                m2.mostrarDiagonalSecundaria();// diagonal sec m2

                m1.somar(m2).mostrar();
                m1.multiplicar(m2).mostrar();
            }
        }
        sc.close();
    }
}

public class main {
    // minha celula tem os ponteiros esq,dir,sup,inf, alem do elemento
    
    class Matriz{
        private Celula inicio;
        private int linha,coluna;
    }
    // cada celula sabe seu elemento, quem ta em cima, em baixo, na direita e na esquerda

    public class Matriz soma(Matriz m){
        if(this.linha != m.linha || this.coluna != m.coluna){// verifico se e valido para soma
            return null;
        }

        Matriz resp = new Matriz(linha,coluna);
        // ponteiro para as 3 matrizes
        Celula a = this.inicio;
        Celula b = m.inicio;
        Celula c = c.inicio;

        for(int i = 0; i < linha; i++){
            Celula ai = a;
            Celula bi = b;
            Celula ci = c;

            for(int j = 0; j < coluna; j ++){
                ci.elemento = ai.elemento + bi.elemento;
                
                // ando para a direita, caminho ate o fim da linha
                ai = ai.dir;
                bi = bi.dir;
                ci = ci.dir;
            }// termino a linha
            // desco 1 linha
            a = a.inf.
            b = b.inf;
            c = c.inf;
        }
        return resp;
    }
}

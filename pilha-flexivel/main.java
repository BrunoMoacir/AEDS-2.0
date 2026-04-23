public class main {

    class Celula {
        public int elemento;
        public Celula prox;

        public Celula() {
            this(0);
        }

        public Celula(int elemento) {
            this.elemento = elemento;
            this.prox = null;
        }
    }

    class Pilha {
        private Celula topo;

        public Pilha() {
            topo = null;
        }

        public void inserir(int x) {
            Celula tmp = new Celula(x);// coloco o elemento a ser inserido em uma variavel temporaria
            tmp.prox = topo;// faço o proximo elemento do temporario apontar para o topo original
            topo = tmp;// topo recebe a temporaria
            tmp = null;// anulo a temporaria
        }
        public int remover()throws Exception{
            if(topo == null){// se o topo for null, a pilha ta vazia
                throw new Exception("Erro");
            }
            int elemento = topo.elemento;// guardo o elemento que vai ser retirado
            Celula tmp = topo;// guardo o topo que vai ser retirado em uma celula temporaria
            topo = topo.prox;// topo vai receber o novo topo
            tmp.prox = null;
            tmp = null;
            return elemento;
        }
        public void mostrar() {
            Celula i;// declaro indice como celula
            System.out.println("[");
            for(i = topo; i != null; i = i.prox){// enquanto for diferente de null
                System.out.println(i.elemento + " ");// imprimo
            }
            System.out.println("]");
        }
        public int somaElementos() throws Exception{
            int soma = 0;// variavel de soma iniciada em 0
            for(Celula i = topo; i != null; i = i.prox){// for enquanto i != null
                soma += i.elemento;// somo elementos
            }
            return soma;// retorno
        }
        public int somaElementosRec(){
            return somaElementosRec(topo);
        }
        public int somaElementosRec(Celula i){
            if(i == null){
                return 0;
            }else{
                return i.elemento + somaElementosRec(i.prox);
            }
        }
        public int maiorElemento()throws Exception{
            if(topo == null){
                throw new Exception("Erro");
            }
            int maior = topo.elemento;
            for(Celula i = topo.prox; i != null; i = i.prox){
                if(i.elemento > maior){
                    maior = i.elemento;
                }
            }
            return maior;
        }
        public int maiorElementoRec(){
            return maiorElementoRec(topo);
        }
        public int maiorElementoRec(Celula i){
            if(i.prox == null){
                return i.elemento;
            }
            int maior = maiorElementoRec(i.prox);
            if(i.elemento > maior){
                return i.elemento;
            }else{
                return maior;
            }
        }
        public void mostrarRec(){
            System.out.println("[");
            mostrarRec(topo);
            System.out.println("]");
        }
        public void mostrarRec(Celula i){
            if(i == null){
                return;
            }else{
                System.out.println(i.elemento + "");
                mostrarRec(i.prox);
            }
        }
        
    }
}
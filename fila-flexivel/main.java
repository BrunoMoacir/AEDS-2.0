public class main {

    class Celula {
        public Celula(int x) {
        }
        public int elemento;// elemento da celula
        public Celula prox;// aponta a celula para prox
    }

    class Fila {
        private Celula primeiro;
        private Celula ultimo;
        
        public Fila(){
            primeiro = new Celula();
            ultimo = primeiro;// comeco ambas apontam para cabeca
        }

        public void inserir(int x){
            ultimo.prox = new Celula(x);
            ultimo = ultimo.prox;
        }

        public int remover() throws Exception{
            if(primeiro == ultimo){
                throw new Exception("Erro");// fila vazia
            }
            Celula tmp = primeiro;// crio uma celula tmp pegando o elemento q vai sair
            primeiro = primeiro.prox;// primeiro recebe o seu prox
            int elemento = primeiro.elemento;// guardo o elemento novo
            tmp.prox = null;// libero
            tmp = null;// libero
            return elemento;// retorno o elemento
        }

        public void mostrar(){
            System.out.println("[");
            Celula i;
            for(i = primeiro.prox; i != null; i = i.prox){
                System.out.println(i.elemento + " ");
            }
            System.out.println("]");
        }

        public int maiorElemento() throws Exception{
            if(primeiro == ultimo){
                throw new Exception("Erro");
            }
            Celula i;
            int maior = primeiro.prox.elemento;
            for(i = primeiro.prox; i != null; i = i.prox){
                if(i.elemento > maior){
                    maior = i.elemento;
                }
            }
            return maior;
        }
        // retornar o terceiro elemento supondo que ele existe
        public int terceiroElemento(){
            return primeiro.prox.prox.prox.elemento;
        }

        public void inverteElementos(){
            Celula fim = ultimo;
            while(primeiro != fim){
                Celula nova = new Celula(primeiro.prox.elemento);
                nova.prox = fim.prox;
                fim.prox = nova;
                Celula tmp = primeiro.prox;
                primeiro.prox = tmp.prox;
                nova = tmp = tmp.prox = null;
                if(ultimo == fim){
                    ultimo = ultimo.prox;
                }
            }
            fim = null;
        }

        public int contaParesEMultiplos5Rec(){
            return contaParesEMultiplos5Rec(primeiro.prox);
        }
        public int contaParesEMultiplos5Rec(Celula i){
            if(i == null){
                return 0;
            }else{
                if(i.elemento % 2 == 0 && i.elemento % 5 == 0){
                    return 1 + contaParesEMultiplos5Rec(i.prox);
                }else{
                    return contaParesEMultiplos5Rec(i.prox);
                }
            }
        }
    }


}
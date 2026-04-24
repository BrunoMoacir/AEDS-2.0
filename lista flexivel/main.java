public class main {
    class Celula{
        public Celula(int x) {
            //TODO Auto-generated constructor stub
        }
        public Celula() {
            //TODO Auto-generated constructor stub
        }
        public int elemento;
        public Celula prox;
    }
    
    class Lista{
        private Celula primeiro, ultimo;

        public Lista(){
            primeiro = new Celula();// celula cabeca
            ultimo = primeiro;// lista vazia = ultimo apont pro primeiro
        }

        public int tamanho(){
            int cont = 0;
            for(Celula i = primeiro; i != ultimo.prox; i = i.prox){
                cont ++;
            }
            return cont;
        }

        public void inserirInicio(int x){
            Celula tmp = new Celula(x);// crio uma nova celula com o elemento
            tmp.prox = primeiro.prox;// aponto pro antigo primeiro
            primeiro.prox = tmp;//cabeca aponta pro novo
            if(primeiro == ultimo){// novo tambem e ultimo
                ultimo = tmp;
            }
            tmp = null;// libero o tmp
        }

        public void inserirFim(int x){
            ultimo.prox = new Celula(x);// crio celula depois do ultimo
            ultimo = ultimo.prox;// atualizo o ultimo
        }
        
        public int removerInicio() throws Exception{
            if(primeiro == ultimo){
                throw new Exception("Erro");// lista vazia
            }
            Celula tmp = primeiro;// guardo o primeiro
            primeiro = primeiro.prox;// primeiro se atualiza(avanca)
            int resp = primeiro.elemento;// guardo o elemento
            tmp.prox = null;
            tmp = null;
            return resp;// retorno o elemento
        }
        
        public int removerFInal()throws Exception{
            if(primeiro == ultimo){
                throw new Exception ("Erro");
            }
            Celula i;// crio celula de referencia
            for(i = primeiro; i.prox != ultimo; i = i.prox);// posiciono ela no penultimo elemento
            int resp = ultimo.elemento;// guardo o elemento
            ultimo = i;// ultimo recebe o penultimo
            i = null;
            ultimo.prox = null;
            return resp;
        }

        public void inserir(int x, int pos) throws Exception{
            int tamanho = tamanho();

            if(pos < 0 || pos > tamanho){
                throw new Exception("Erro");// posicao invalida
            }else if(pos == 0){// se a posiaco for 0 insiro no inicio
                inserirInicio(x);
            }else if(pos == tamanho){// se a posicao for igual o tamanho insiro no final
                inserirFim(x);
            }else {
                Celula i = primeiro;
                for(int j = 0; j < pos; j++, i = i.prox);// vou com a celula i ate o anterior a posicao
                Celula tmp = new Celula(x);// crio a nova celula em uma temporaria
                tmp.prox = i.prox;// encaixo ela
                i.prox = tmp;// encaixo ela
                tmp = null;
            }
        }

        public int remover(int pos) throws Exception{
            int resp;
            int tamanho = tamanho();
            if(primeiro == ultimo){
                throw new Exception("Erro");
            }else if(pos < 0 || pos >= tamanho){
                throw new Exception("Erro")
            }else if(pos == 0){
                removerInicio();
            }else if(pos == tamanho - 1){
                removerFInal();
            }else{
                Celula i = primeiro;
                for(int j = 0; j < pos; j++, i = i.prox);// caminho ate a posicao anterior da q quero
                Celula tmp = i.prox;// crio uma temporaria guardando a que vou remover
                resp = tmp.elemento;// pego o elemento dela
                i.prox = tmp.prox;// removo
                tmp.prox = null;
                i = null;
                return resp;
            }
        }

        public void mostar(){
            System.out.println("[");
            Celula i;
            for(i = primeiro.prox; i != ultimo.prox; i = i.prox){
                System.out.println(i.elemento + " ");
            }
            System.out.println("]");
        }

        public int removeSegundaPosicao() throws Exception{
            if(primeiro == ultimo || primeiro.prox.prox == null){
                throw new Exception("Erro");
            }
            Celula primeiroE = primeiro.prox;
            Celula segundoE = primeiro.prox.prox;
            int elemento = segundoE.elemento;
            primeiroE.prox = segundoE.prox;
            if(segundoE == ultimo){
                ultimo = primeiroE;
            }
            return elemento;
        }

        public int somarElementos() throws Exception{
            if(primeiro == ultimo){
                throw new Exception("Erro");
            }
            int soma = 0;
            for(Celula i = primeiro.prox; i != ultimo.prox; i = i.prox){// o certo e i != null, pois tecnicamente o ultimo.prox e nulo
                soma += i.elemento;
            }
            return soma;
        }

        public int contaPares(){
            int cont = 0;
            for(Celula i = primeiro.prox; i != null; i = i.prox){
                if(i.elemento % 2 == 0){
                    cont ++;
                }
            }
            return cont;
        }
        public int maiorElementoRec(){
            return maiorElementoRec(primeiro.prox);
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

        public void removePares(){
            Celula i = primeiro;

            while(i != null){
                if(i.prox.elemento % 2 == 0){
                    Celula tmp = i.prox;
                    i.prox = tmp.prox;

                    if(tmp == ultimo){
                        ultimo = i;
                    }
                    tmp.prox = null;
                    tmp = null;
                }else{
                    i = i.prox;
                }
            }
        }
    }
}

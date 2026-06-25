// BUBBLE SORT ADAPTADO
int n = tamanho;
int array[];

for(int i = n; i > 0; i --){
    for(int j = 0; j < i; j++){
        if(array[j] < array[j + 1]){
            int tmp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = tmp;
        }
    }
}

// FILA
int[] fila = new int[1000];

int inicio = 0;
int fim = 0;
int tamanho = 0;

// INSERIR
fila[fim] = x;
fim = fim + 1;
tamanho = tamanho + 1;

// REMOVER
int resp = fila[inicio];
inicio = inicio + 1;
tamanho --;

// VERIFICAR VAZIA
if(tamanho == 0) ou if(inicio == fim)

// MOSTRAR
for(int i = inicio; i < fim; i++){
    syso(fila[i]);
}


// PILHA
int [] pilha = new int[1000];
int topo = -1;

// INSERIR
topo = topo + 1;
pilha[topo] = x;

// REMOVER
int resp = pilha[topo];
topo = topo - 1;

// MOSTRAR
for(int i = topo; i >= 0; i--){
    syso(pilha[i]);
}

// VERIFICAR VAZIA
if(topo == -1)

// LISTA 
int[] lista = new int [1000];
int n = 0;

// inserir no fim
lista[n] = x;
n++;

// inserir no inicio
for(int i = n; i > 0; i --){
    lista[i] = lista[i - 1];
}
lista[0] = x;
n++;

// inserir em posicao
for(int i = n; i > pos; i --){
    lista[i] = lista[i - 1];
}
lista[pos] = x;
n ++;

// ARVORE RAPIDA
public class implementacoesRapidas{
    static class No{
        String elemento;
        No esq;
        No dir;

        public No(String s){
            elemento = s;
            esq = null;
            dir = null;
        }
    }

    public static inserir(String s, No i){
        if(i == null){
            i = new No(s);
        }else if(s.compareTo(i.elemento) < 0){
            i.esq = inserir(s,i,esq);
        }else if(s.compareTo(i.elemento) > 0){
            i.dir = inserir(s,i.dir);
        }
        return i;
    }

    public static boolean pesquisar(String s, No i){
        boolean existe;
        if(i == null){
            existe = false;
        }else if(s.compareTo(i.elemento) == 0){
            existe = true;
        }else if(s.compareTo(i.elemento) < 0){
            existe = pesquisar(s,i.esq);
        }else{
            existe = pesquisar(s,i.dir);
        }
        return existe;
    }

    public static void caminharCentral(No i){
        if(i != null){
            caminharCentral(i.esq);
            System.out.println(i.elemento);
            caminharCentral(i.dir);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        No raiz = null;

        String palavra = sc.next();
        while(palavra.compareTo("FIM") != 0){
            ...
        }
    }
}
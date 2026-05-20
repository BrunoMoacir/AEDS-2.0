import java.util.Scanner;
// chegar nome -> entra na fila
// chamar -> atendo o proximo
// fila -> imprimo a qt de pessoas que estao na fla

class Fila{
    String[] dados;
    int frente,fim,tam;
    public Fila(int cap){
        dados = new String [cap];
        frente = 0;
        tam = 0;
    }
    public void enqueue(String s){
        dados[fim++] = s;
        tam ++;
    }
    public String dequeue(){
        tam --;
        return dados[frente++];
    }
    public int tamanho(){
        return tam;
    }
    public boolean vazia(){
        return tam == 0;
    }
}
public class filaBanco{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            Fila f = new Fila(1000);
            for(int i = 0; i < n; i++){
                String op = sc.next();
                if(op.charAt(0) == 'C' && op.charAt(2) == 'E'){
                    f.enqueue(sc.next());
                }else if(op.charAt(0) == 'C' && op.charAt(2) == 'A'){
                    if(f.vazia()){
                        System.out.println("FILA VAZIA");
                    }else{
                        System.out.println(f.dequeue());
                    }
                }else{
                    System.out.println(f.tamanho());
                }
            }
        }
    }
}
import java.util.Scanner;

public class questao8 {
    public static boolean ehValida(String str) {
        if (str.length() <= 7) {// se tiver menos de 8 caracteres nem entra
            return false;
        }

        int minuscula = 0, maiuscula = 0, numero = 0, charEspecial = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {// se tiver minuscula incrementa
                minuscula++;
            }
            if (c >= 'A' && c <= 'Z') {// se tiver maiuscula incrementa
                maiuscula++;
            }
            if (c >= '0' && c <= '9') {// se tiver numero incrementa
                numero++;
            } else {
                charEspecial++;// caso nao seja nenhum dos acimas e especial
            }
        }
        if (minuscula == 0 || maiuscula == 0 || numero == 0 || charEspecial == 0) {// caso alguma regra esteja zerada, as regras nao estao sendo cumpridas
            return false;
        } else {
            return true;// caso contrario, ok
        }
    }

    public static boolean isFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');// le ate chegar no FIM
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        while (!(isFim(str))) {// enquanto nao for FIM
            if (ehValida(str)) {// mando a string para a funcao verificando tudo
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            str = sc.next();
        }

    }
}

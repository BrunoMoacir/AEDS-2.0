import java.util.Scanner;

public class questao8 {
    public static boolean ehValida(String str) {
        if (str.length() <= 7) {
            return false;
        }

        int minuscula = 0, maiuscula = 0, numero = 0, charEspecial = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                minuscula++;
            }
            if (c >= 'A' && c <= 'Z') {
                maiuscula++;
            }
            if (c >= '0' && c <= '9') {
                numero++;
            } else {
                charEspecial++;
            }
        }
        if (minuscula == 0 || maiuscula == 0 || numero == 0 || charEspecial == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(3) == 'M');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        while (!(isFim(str))) {
            if (ehValida(str)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            str = sc.next();
        }

    }
}

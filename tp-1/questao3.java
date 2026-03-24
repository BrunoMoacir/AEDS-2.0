public class questao3 {
    public static void main(String[] args) {
        String linha = MyIO.readLine();

        while (!isFim(linha)) {// ler ate ser diferente de FIM
            // tudo comeca como true
            boolean vogais = true;
            boolean consoantes = true;
            boolean inteiros = true;
            boolean real = true;

            int pontos = 0;// contagem de ponto e virgula

            for(int i = 0; i < linha.length(); i++){// passo por toda a string vendo cada char
                char c = linha.charAt(i);

                boolean ehVogal = (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
                                   c=='A'||c=='E'||c=='I'||c=='O'||c=='U');// vejo se e vogal

                boolean ehLetra = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');// vejo se e letra

                if (!ehVogal) vogais = false;

                if (!ehLetra || ehVogal) consoantes = false;

                if (!(c >= '0' && c <= '9')) inteiros = false;// classifico

                if (c == '.' || c == ',') {
                    pontos++;
                } else if (!(c >= '0' && c <= '9')) {
                    real = false;
                }
            }

            if (pontos > 1) real = false;

            if (vogais) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if (consoantes) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if (inteiros) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if (real) MyIO.println("SIM");
            else MyIO.println("NAO");

            linha = MyIO.readLine();
        }
    }

    public static boolean isFim(String linha){// funcao para detectar o fim
        return (linha.length() == 3 &&
                linha.charAt(0) == 'F' &&
                linha.charAt(1) == 'I' &&
                linha.charAt(2) == 'M');
    }
}
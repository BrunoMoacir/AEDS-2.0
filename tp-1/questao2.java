import java.util.Random;

class questao2 {
    public static void main(String[] args) {
        Random gerador = new Random();//config
        gerador.setSeed(4);

        String linha = MyIO.readLine();

        while (linha != null && !linha.equals("FIM")) {// ler ate o fim do arquivo ou a palavra FIM

            char letraOriginal = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));// sorteio
            char letraNova = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

            String textoAlterado = alterar(linha, letraOriginal, letraNova);// metodo que faz a troca

            MyIO.println(textoAlterado);

            linha = MyIO.readLine();
        }

    }

    public static String alterar(String texto, char letraOriginal, char letraNova) {// recebe a string e as duas letras sorteadas
        String resultado = "";

        for (int i = 0; i < texto.length(); i++) {// percorre a string caractere por caractere
            char caractereAtual = texto.charAt(i);

            // se o caractere atual for igual a primeira letra sorteada troca pela segunda
            if (caractereAtual == letraOriginal) {
                resultado += letraNova;
            } else {
                // caso contrario, apenas copia o caractere atual para o resultado
                resultado += caractereAtual;
            }
        }

        return resultado;
    }
}

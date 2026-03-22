public class questao1 {

    public static void main(String[] args) {
        String linha = MyIO.readLine();
        while (linha != null && linha.length() > 0){// enquanto tiver coisa para ler
            // chamada funcao
            String mensagemCriptografada = cifrar(linha);
            
            MyIO.println(mensagemCriptografada);

            linha = MyIO.readLine();
        }
    }

    //funcao para cifrar
    public static String cifrar(String texto) {
        String resultado = "";

        for (int i = 0; i < texto.length(); i++) {
            char novaLetra = (char) (texto.charAt(i) + 3);// pego a letra atual e somo 3 posicoes
            resultado += novaLetra;// concateno ate dar a palavra completa
        }

        return resultado;
    }
}
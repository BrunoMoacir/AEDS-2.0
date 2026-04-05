public class PalindromoFilaCircular {

    public boolean isPalindromo(){
        boolean palindromo = true;
        int i = primeiro;// o i recebe o primeiro elemento da fila circular
        int j = (ultimo + 1) % array.length();// j recebe o ultimo elemento da fila circular, pois apenas ultimo aponta para a PROXIMA POSICAO LIVRE
        while(i != j && (i + 1) % array.length() != j){ // enquanto o i for diferente do j (o meio nao ter sido alcancado ainda) e os ponteiros i e j nao se cruzarem
            if(array[i] != array[j]){// se forem diferente nao e palindromo
                palindromo = false;
            }
            i = (i + 1) % array.length();// o i vai para a proxima posicao
            j = (j - 1 + array.length())%array.length();// o j vai 1 posicao para tras
        }


    }
    
}

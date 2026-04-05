public class palindromoLista {
    public boolean palindromo (String s){
        boolean palindromo = true;
        Lista lista = new Lista(s.length());

        for(int i = 0; i < s.length; i++){
            lista.array[i] = s.charAt(i);
            lista.n++
        }

        int i = 0;
        int j = lista.n - 1;

        while(i != j){
            if(lista.array[i] != lista.array[j]){
                palindromo = false;
            }
            i ++;
            j--;
        }
        return palindromo;
    }    
}

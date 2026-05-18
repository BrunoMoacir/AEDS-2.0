//BUBBLE SORT PADRAO ORDEM CRESCENTE
for(int i = n - 1; i > 0; i--){
    for(int j = 0; j < 0; j ++){
        if(array[j] > array[j + 1]){
            int tmp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = tmp;
        }
    }
}


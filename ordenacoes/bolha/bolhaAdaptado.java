public class bolhaAdaptado {

    int vet[50];
    int n = 20;

    for(int i = n - 1; i > 0; i--){
        for(int j = 0; j < i; j++){
            if(vet[j] < vet[j + 1]){
                int tmp = vet[j];
                vet[j] = vet[j + 1];
                vet[j + 1] = tmp;
            }
        }
    }
    
}

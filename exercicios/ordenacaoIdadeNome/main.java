import java.util.Scanner;

public class main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String [] nome = new String [n];
		double [] altura = new double[n];

		for(int i = 0; i < n; i++){
			nome[i] = sc.next();
			altura[i] = sc.nextDouble();
		}

		for(int j = n - 1; j > 0; j --){
			for(int k = 0; k < j; k++){
				if(altura[k] < altura [k + 1]){
					double tmp = altura[k];
					altura [k] = altura[k + 1];
					altura[k + 1] = tmp;
					
					String tmp2 = nome[k];
					nome[k] = nome[k + 1];
					nome[k + 1] = tmp2;				
				}
			}
		}
		for(int b = 0; b < n; b++){
			System.out.println(nome[b] + " " + altura[b]);
		}
	}
}

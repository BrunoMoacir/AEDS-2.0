import java.util.Scanner;

public class main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String [] fila = new String[n];

		for(int i = 0; i < n; i++){
			fila[i] = sc.next();
		}

		int ini = 0;
		int fim = n;

		if(ini < fim){
			ini ++;
		}
		for(int i = ini; i < n; i++){
			System.out.println(fila[i] + " ");
		}
	}
}

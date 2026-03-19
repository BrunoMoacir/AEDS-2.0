import java.util.Scanner;

public class main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(sc.hasNext()){
			int comando;
			int [] array = new int[n];
			for(int i = 0; i < n; i++){
				comando = sc.nextInt();
				array[i] = sc.nextInt();
				System.out.println(array[i] + " ");
			}
			
		}
		sc.close();
	}
}

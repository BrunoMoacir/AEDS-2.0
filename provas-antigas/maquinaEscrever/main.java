import java.util.Scanner;

public class main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		char numDefeito;
		String numeros;
		numDefeito = sc.nextInt();
		numeros = sc.next();
		while(numDefeito != 0){
			int i = 0;
			while(i < numeros.length()){
				char c = numeros.charAt(i);
				if(c != numDefeituoso){
					System.out.printf("%c", numeros.charAt(i));
				}
				i++;
			}
			numDefeito = sc.nextInt();
			numeros = sc.next();
		}
	}
}

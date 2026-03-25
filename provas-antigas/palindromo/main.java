import java.util.Scanner;

public class main{
	public static void main(String [] args){
		boolean palindromo = true;
		Scanner sc = new Scanner(System.in);

		String palavra = sc.next();

		int i = 0, j = palavra.length() - 1;

		while(i < j){
			if(palavra.charAt(i) != palavra.charAt(j)){
				palindromo = false;
			}
			i ++; j--;
		}
		if(palindromo){
			System.out.println("sim");
		}else{
			System.out.println("Nao");
		}
	}
}

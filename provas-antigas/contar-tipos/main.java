import java.util.Scanner;

public class main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		int numeros = 0,letras = 0, outros = 0;

		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c >= 'a' && c <='z' || c >= 'A' && c <= 'Z'){
				letras ++;
			}else if(c >= '0' && c <= '9'){
				numeros ++;
			} else{
				outros ++;
			}
		}
		System.out.print(numeros + " "+ letras + " " + outros);
	}
}

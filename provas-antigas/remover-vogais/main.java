import java.util.Scanner;

public class main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			String s = sc.next();

			for(int i = 0; i < s.length(); i++){
				char c = s.charAt(i);
				if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U'){
					System.out.print(c);
				}
			}
		}
		System.out.println();
	}
}

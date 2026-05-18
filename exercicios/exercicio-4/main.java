import java.util.Scanner;

class Funcionario{
	String nome;
	int salario;

	Funcionario(String nome, int salario){
		this.nome = nome;
		this.salario = salario;
	}

	public String getNome(){
		return nome;
	}

	public int getSalario(){
		return salario;
	}
}

public class main{
	public static void main(String [] args){

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();// consumir quebra de linha

		Funcionario [] funcionarios = new Funcionario[n];

		for(int i = 0; i < n; i++){
			String nome = sc.next();
			int idade = sc.nextInt();
			funcionarios[i] = new Funcionario(nome,idade);
		}

		// ordenacao bolha
		for(int j = n - 1; j >= 0; j--){
			for(int k = 0; k < j; k++){
				if(funcionarios[k].getSalario() > funcionarios[k + 1].getSalario()){
					Funcionario tmp = funcionarios[k];
					funcionarios[k] = funcionarios[k + 1];
					funcionarios[k+1] = tmp;
				}
			}
		}
		for(int b = 0; b < n; b++){
			System.out.println(funcionarios[b].getNome() + " " + funcionarios[b].getSalario());
		}
	}
}

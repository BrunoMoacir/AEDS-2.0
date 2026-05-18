import java.util.Scanner;

//ler atletas com nome e peso e ordenalos pelo peso
class Atleta{
	public String nome;
	public int peso;

	Atleta(String nome, int peso){
		this.nome = nome;
		this.peso = peso;
	}

	public String getNome(){
		return nome;
	}

	public int getPeso(){
		return peso;
	}
}

public class main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		int qtAtletas = sc.nextInt();
		sc.nextLine();// consumir quebra de linha
		
		Atleta[] atletas = new Atleta[qtAtletas];// crio um vetor de atletas
		
		for(int i = 0; i < qtAtletas; i++){
			String nome = sc.next();
			int idade = sc.nextInt();
			atletas[i] = new Atleta(nome,idade);// crio um atleta no espaco i do vetor
		}

		// ordenacao bubble sort, caso empate pelo peso desempatar pelo nome
		for(int j = qtAtletas - 1; j > 0; j --){
			for(int k = 0; k < j; k++){
				if(atletas[k].getPeso() < atletas[k + 1].getPeso()){
					Atleta tmp = atletas[k];
					atletas[k] = atletas[k + 1];
					atletas[k + 1] = tmp;
				}else if(atletas[k].getPeso() == atletas[k + 1].getPeso()){
					if(atletas[k].getNome().compareTo(atletas[k + 1].getNome()) > 0){// no compare to compara em ordem alfabetica, > 0 retorna se a primeira vem depois da segunda
													 // > 0 troca se quiser ordem alfabetica crescente
													 // < 0 troca se quiser ordem alfabetica decrescente
						Atleta tmp = atletas[k];
						atletas[k] = atletas[k + 1];
						atletas[k + 1] = tmp;
					}
				}
			}
		}
		for(int b = 0; b < qtAtletas; b ++){
			System.out.println(atletas[b].getNome() + " " + atletas[b].getPeso());
		}
		
	}
}

import java.util.Scanner;

public class Menu {
	Opcao[] opcoes = new Opcao[10];

	int numOpcoes = 0;
	int escolha = 0;
	
	Scanner resp = new Scanner(System.in);

	public void addOption(Opcao opcao) {

		opcoes[numOpcoes] = opcao;
		numOpcoes++;
	}//fecha addOption

	public void show() {		
		for (int i = 0; i < numOpcoes; i++) {
			System.out.println("["+ i + "] "+opcoes[i].getTexto());
		}
		System.out.println("ESCOLHA UMA OPÇÃO: ");
		this.escolha = this.resp.nextInt();
	}//fecha show

	public int getOption() {
		return this.escolha;		
	}//fecha getOption
	
}//close class

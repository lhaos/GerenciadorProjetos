import java.util.Scanner;

public class Remocoes {
	
	Funcionario func = null;
	Projeto proj = null;
	
	public String digita(String texto){
		Scanner ler  = new Scanner(System.in);
		System.out.println(texto);
			return ler.next();
	}//fecha digita

	public void removeFunc(Vetor<Funcionario> vFunc) {
		vFunc.getVetor();
		int ind = Integer.parseInt(digita("Digite o indice do funcionario que deseja remover: "));
		vFunc.remove(ind);
	}

	public void removeProj(Vetor<Projeto> vProj) {
		vProj.getVetor();
		int ind = Integer.parseInt(digita("Digite o indice do projeto que deseja remover: "));
		vProj.remove(ind);
	}
	
	
	
}

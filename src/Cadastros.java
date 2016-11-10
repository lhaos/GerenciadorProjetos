import java.time.LocalDate;
import java.util.Scanner;

public class Cadastros {
	Funcionario func = null;
	Competencias comp = null;
	Colaboradores col = null;
	Projeto proj = null;
	
	public String digita(String texto){
		Scanner ler  = new Scanner(System.in);
		System.out.println(texto);
			return ler.next();
	}//fecha digita
	
	public Funcionario cadastroFunc(Vetor<Competencias> vComp){
		Funcionario func = new Funcionario(digita("Digite o nome do funcionario: "), 
				Double.parseDouble(digita("Digite o salario do funcionario: ")),
				Integer.parseInt(digita("Informe o numero de competencias")));
		func.insereCompetencias(vComp);
		
		return func;
		
	}//fecha metodo para cadastrar funcionario
	
	public Projeto cadastroProj(Vetor<Competencias> vComp){
		Projeto proj = new Projeto(digita("Digite o nome do Projeto: "),
				LocalDate.parse((digita("Digite a data de inicio no formato AAAA-MM-DD"))),
				LocalDate.parse((digita("Digite a data final no formato AAAA-MM-DD"))),
				Integer.parseInt(digita("Informe o numero de competencias")));
		
		proj.insereCompetencias(vComp);
		
		return proj;
	}//fecha cadastro de projeto

	public Competencias cadastroComp() {
		Competencias comp = new Competencias(digita("Digite o nome da competencia"));
		return comp;
	}//fecha cadastro de competencias
	
	
	
	
}//fecha classe

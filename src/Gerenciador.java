import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;

public class Gerenciador {
	
	Cadastros cad = new Cadastros();
	Remocoes rem = new Remocoes();
	
	FuncionariosParser pFunc = new FuncionariosParser();
	CompetenciasParcer pComp = new CompetenciasParcer();
	ColaboradoresParser pCol = new ColaboradoresParser();
	ProjetoParser pProj = new ProjetoParser();
	
	Funcionario func = null;
	Competencias comp = null;
	Colaboradores col = null;
	Projeto proj = null;
	
	Vetor<Funcionario> vFunc = new Vetor<>();
	Vetor<Competencias> vComp = new Vetor<>();
	Vetor<Projeto> vProj = new Vetor<>();
	Vetor<Colaboradores> vCol = new Vetor<>();

	public static void main(String[] args) {
		
		try {
			(new Gerenciador()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}

	}//close main
	
	private void run() throws FileNotFoundException {
		importarArquivo("src/arquivos/funcionarios.csv", func, pFunc, vFunc);
		importarArquivo("src/arquivos/projetos.csv", proj, pProj, vProj);
		importarArquivo("src/arquivos/competencias.csv", comp, pComp, vComp);
		importarArquivo("src/arquivos/colaboradores.csv", col, pCol, vCol);
		
		Menu menu = new Menu();
		
		Opcao verFunc = new Opcao("Ver Funcionarios");
		Opcao verProj = new Opcao("Ver Projetos");
		Opcao verComp = new Opcao("Ver Competencias");
		Opcao verColab = new Opcao("Ver Colaboradores");
		Opcao deletFunc = new Opcao("Deletar Funcionarios");
		Opcao deletProj = new Opcao("Deletar Projetos");
		Opcao cadProj = new Opcao("Cadastrar Projeto");
		Opcao cadFunc = new Opcao("Cadastrar Funcionario");
		Opcao cadComp = new Opcao("Cadastrar competencias");
		Opcao sair = new Opcao("Sair");

		menu.addOption(sair);
		menu.addOption(verFunc);
		menu.addOption(verProj);
		menu.addOption(verComp);
		menu.addOption(verColab);
		menu.addOption(deletFunc);
		menu.addOption(deletProj);
		menu.addOption(cadProj);
		menu.addOption(cadFunc);
		menu.addOption(cadComp);
		
		do {
			menu.show();
		switch (menu.getOption()) {
			case 0:
					System.exit(0);
				break;
			case 1:
					System.out.println("\nRelação de Funcionários:\n");
					vFunc.getVetor();
				break;
			case 2:
					System.out.println("\nRelação de Projetos:\n");
					vProj.getVetor();
				break;
			case 3:
					System.out.println("\nRelação de Competencias:\n");
					vComp.getVetor();
				break;
			case 4:
					System.out.println("\nRelação de Colaboradores:\n");
					vCol.getVetor();
				break;
			case 5:
				rem.removeFunc(vFunc);
				break;
			case 6:
				rem.removeProj(vProj);
			break;
			case 7:
				 vProj.append(cad.cadastroProj(vComp));
			break;	
			case 8:
				 vFunc.append(cad.cadastroFunc(vComp));
			break;	
			case 9:
					vComp.append(cad.cadastroComp());
				break;
			default:
				System.out.println("\nOpção inválida");
			}//fecha switch
		} while (true);
		
	}//fecha run 
	
	private <V> void importarArquivo(String arquivo, V objeto, Parser parser,Vetor<V> vetor) throws FileNotFoundException {
		LeitorCSV<V> leitor = new LeitorCSV<>(arquivo, parser);
		leitor.skipLine();
		
		while (leitor.hasNext()) {
			objeto = leitor.readObject();
			vetor.append(objeto);
		}//fecha while
		leitor.close();
	}//fecha verArquivo

}//close class

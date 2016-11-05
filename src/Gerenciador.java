import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gerenciador {
	
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
		//testaFuncionarios();
		//testaColaboradores();
		//testaCompetencias();
		//testaProjetos();
		/*
		Menu menu = new Menu();
		
		Opcao verFunc = new Opcao("Ver Funcionarios");
		Opcao verProj = new Opcao("Ver Projetos");
		Opcao verComp = new Opcao("Ver Competencias");
		Opcao verColab = new Opcao("Ver Colaboradores");
		Opcao deletFunc = new Opcao("Deletar Funcionarios");
		Opcao deletProj = new Opcao("Deletar Projetos");
		Opcao cadFunc = new Opcao("Cadastrar Funcionario");
		Opcao sair = new Opcao("Sair");

		menu.addOption(verFunc);
		menu.addOption(verProj);
		menu.addOption(verComp);
		menu.addOption(verColab);
		menu.addOption(deletFunc);
		menu.addOption(deletProj);
		menu.addOption(cadFunc);
		menu.addOption(sair);
		
		do {
			menu.show();
		switch (menu.getOption()) {
			case 1:
					System.out.println("\nRelação de Funcionários:\n");
					VetorFuncionarios.getVetor();
				break;
			case 2:
					System.out.println("\nRelação de Projetos:\n");
					VetorProjetos.getVetor();
				break;
			case 3:
					System.out.println("\nRelação de Competencias:\n");
					VetorCompetencias.getVetor();
				break;
			case 4:
					System.out.println("\nRelação de Colaboradores:\n");
					VetorColaboradores.getVetor();
				break;
			case 5:
					VetorFuncionarios.remove(Integer.parseInt(digita("Digite um indice do funcionario "
						+ "que deseja remover")));
				break;
			case 6:
				VetorProjetos.remove(Integer.parseInt(digita("Digite um indice do projeto "
					+ "que deseja remover")));
			break;
			case 7:
				 cadastraFuncionario();
			break;	
			default:
				System.exit(0);
			}//fecha switch
		} while (true);*/
		
	}//fecha run

	private void testaProjetos() throws FileNotFoundException {
		Parser<Projeto> parser = new ProjetoParser();
		LeitorCSV<Projeto> leitor = new LeitorCSV<>("src/arquivos/projetos.csv", parser);
		leitor.skipLine();
		while(leitor.hasNext()){
			Projeto projeto = leitor.readObject();
			System.out.println(projeto);
		}
		leitor.close();
		
	}//close project tester
	
	

	private void testaFuncionarios() throws FileNotFoundException {
		Parser<Funcionario> parser = new FuncionariosParser();
		LeitorCSV<Funcionario> leitor = new LeitorCSV<>("src/arquivos/funcionarios.csv", parser);
		leitor.skipLine();
		while(leitor.hasNext()){
			Funcionario funcionario = leitor.readObject();
			System.out.println(funcionario);
		}
		leitor.close();
	}//close funcionarios tester
	
	private void testaCompetencias() throws FileNotFoundException {
		Parser<Competencias> parser = new CompetenciasParcer();
		LeitorCSV<Competencias> leitor = new LeitorCSV<>("src/arquivos/competencias.csv", parser);
		leitor.skipLine();
		while(leitor.hasNext()){
			Competencias competencia = leitor.readObject();
			System.out.println(competencia);
		}
		leitor.close();
	}//close competencias tester
	
	private void testaColaboradores() throws FileNotFoundException{
		Parser<Colaboradores> parser = new ColaboradoresParser();
		LeitorCSV<Colaboradores> leitor = new LeitorCSV<>("src/arquivos/colaboradores.csv", parser);
		leitor.skipLine();
		while(leitor.hasNext()){
			Colaboradores colaborador = leitor.readObject();
			System.out.println(colaborador);
		}
		leitor.close();
	}//close colaboradores tester 
	
	private <V> void importarArquivo(String arquivo, V objeto, Parser parser,Vetor<V> vetor) throws FileNotFoundException {
		LeitorCSV<V> leitor = new LeitorCSV<>(arquivo, parser);
		leitor.skipLine();
		
		while (leitor.hasNext()) {
			objeto = leitor.readObject();
			System.out.println(objeto);
			//vetor.append(objeto);
		}//fecha while
		leitor.close();
	}//fecha verArquivo

}//close class

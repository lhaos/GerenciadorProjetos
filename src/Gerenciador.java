import java.io.FileNotFoundException;

public class Gerenciador {

	public static void main(String[] args) {
		
		try {
			(new Gerenciador()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}

	}//close main
	
	private void run() throws FileNotFoundException {
		//testaFuncionarios();
		//testaColaboradores();
		//testaCompetencias();
		testaProjetos();
	}

	private void testaProjetos() throws FileNotFoundException {
		Parser<Projeto> parser = new ProjetoParser();
		LeitorCSV<Projeto> leitor = new LeitorCSV<>("src/arquivos/projetos.csv", parser);
		leitor.skipLine();
		while(leitor.hasNext()){
			Projeto projeto = leitor.readObject();
			System.out.println("chegou aq");
			System.out.println(projeto);
		}
		leitor.close();
		
	}//close project tester
/**
	private void testaFuncionarios() throws FileNotFoundException {
		Parser<Funcionario> parser = new FuncionariosParser();
		LeitorCSV<Funcionario> leitor = new LeitorCSV<>("src/arquivos/funcionarios.csv", parser);
		leitor.skipLine();
		while(leitor.hasNext()){
			
		}
		leitor.close();
	}//close funcionarios tester

	private void testaCompetencias() throws FileNotFoundException {
		Parser<Competencias> parser = new CompetenciasParcer();
		LeitorCSV<Competencias> leitor = new LeitorCSV<>("src/arquivos/competencias.csv", parser);
		leitor.skipLine();
		while(leitor.hasNext()){
			
		}
		leitor.close();
	}//close competencias tester

	private void testaColaboradores() throws FileNotFoundException{
		Parser<Colaboradores> parser = new ColaboradoresParser();
		LeitorCSV<Colaboradores> leitor = new LeitorCSV<>("src/arquivos/colaboradores.csv", parser);
		leitor.skipLine();
		while(leitor.hasNext()){
			
		}
		leitor.close();
	}//close colaboradores tester 
	**/

}//close class

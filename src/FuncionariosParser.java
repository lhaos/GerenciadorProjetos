import java.util.Scanner;

public class FuncionariosParser implements Parser<Funcionario> {

	@Override
	public Funcionario parse(String dados) {
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		String nome = arquivo.next();
		double salario = Double.parseDouble(arquivo.next());
		int num_comp = Integer.parseInt(arquivo.next());
		
		Funcionario funcionario = new Funcionario(nome, salario, num_comp);
		
		for(int i = 0; i < num_comp; i++){
			String v = arquivo.next();
			funcionario.setCompetencias(i,v);
		}//fecha for
		
		arquivo.close();
		return funcionario;
		
	}

}

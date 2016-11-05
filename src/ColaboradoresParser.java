import java.util.Scanner;

public class ColaboradoresParser implements Parser<Colaboradores> {

	@Override
	public Colaboradores parse(String dados) {
		
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		String nome_proj = arquivo.next();
		String nome_func = arquivo.next();
		String comp = arquivo.next();
		
		Colaboradores colaborador = new Colaboradores(nome_proj, nome_func, comp);
		
		arquivo.close();
		return colaborador;
	}

}

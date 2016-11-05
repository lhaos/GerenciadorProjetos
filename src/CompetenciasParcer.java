import java.util.Scanner;

public class CompetenciasParcer implements Parser<Competencias> {

	@Override
	public Competencias parse(String dados) {
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		String comp = arquivo.next();
		
		Competencias competencias = new Competencias(comp);
		
		arquivo.close();
		return competencias;
	}

}

import java.util.Scanner;

public class CompetenciasParcer implements Parser<Competencias> {

	@Override
	public Competencias parse(String dados) {
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		int num_comp = 0;
		
		while(arquivo.hasNext()){
			num_comp++;
			System.out.println("teste");
		}
		
		Competencias competencias = new Competencias(num_comp);
		
		for(int i = 0; i < num_comp; i++){
			String v = arquivo.next();
			competencias.setCompetencias(i,v);
		}
		
		arquivo.close();
		return competencias;
	}

}

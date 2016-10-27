import java.time.LocalDate;
import java.util.Scanner;
public class ProjetoParser implements Parser<Projeto> {
	
	public Projeto parse(String dados){
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		String nome = arquivo.next();
		LocalDate data_inicio = LocalDate.parse(arquivo.next());
		LocalDate data_fim = LocalDate.parse(arquivo.next());
		int num_competencias = Integer.parseInt(arquivo.next());
		
		Projeto projeto = new Projeto(nome, data_inicio, data_fim, num_competencias);
		
		for(int i = 0; i <= num_competencias; i++){
			String v = arquivo.next();
			projeto.setCompetencias(i,v);
		}//fecha for
		
		arquivo.close();
		return projeto;
		
	}
	
}//close class

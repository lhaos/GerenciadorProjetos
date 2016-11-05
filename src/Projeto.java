import java.time.LocalDate;
import java.util.Scanner;

public class Projeto {
	
	Scanner ler = new Scanner(System.in);
	
	private String nome;
	private LocalDate data_inicio;
	private LocalDate data_fim;
	private int num_competencias;
	private String[] competencia;
	private int indice = 0;
	
	public Projeto(String nome, LocalDate data_inicio, LocalDate data_fim,
			int num_competencias){
		this.nome = nome;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.num_competencias = num_competencias;
		this.competencia = new String[this.num_competencias];
	}
	
	public void setCompetencias(int num, String comp){
		if(num < 0 || num >= competencia.length)
			throw new ArrayIndexOutOfBoundsException(num);
		this.competencia[num] = comp;
	}
	
	private String mostraCompetencias(){
		String comp = "";
		for(int i = 0; i < num_competencias; i++){
			
			if(i == (num_competencias-1)){
				comp += this.competencia[i];
			}else{
				comp += this.competencia[i]+" - ";
			}
			
		}//fecha for
		return comp;
	}//fecha mostraCompetencias()
	
	@Override
	public String toString() {
		
		return "Projeto: " + this.nome + "\nInicio: " + this.data_inicio + 
				"\nFim: " + this.data_fim + "\nNúmero de competencias: " + this.num_competencias
				+ "\nCompetencias: [ "
				+ mostraCompetencias() + "]"+"\n----------------------------------------";
		
	}

	public void insereCompetencias(Vetor<Competencias> vComp) {
		
		vComp.getVetor();
		do{
			System.out.println("Informe o nome da competencia: " + (this.indice+1));
			String comp = ler.next();
			
				if(this.indice  < competencia.length){
					competencia[indice] = comp;
					indice++;
				}//fecha if
						
		}while(indice < competencia.length);
		
	}
	
}

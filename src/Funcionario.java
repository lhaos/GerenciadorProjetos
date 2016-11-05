
public class Funcionario {

	private String[] competencia;
	private String nome;
	private double salario;
	private int num_comp;

	public Funcionario(String nome, double salario, int num_comp) {
		this.nome = nome;
		this.salario = salario;
		this.num_comp = num_comp;
		this.competencia = new String[this.num_comp];
	}

	public void setCompetencias(int num, String comp) {
		if(num < 0 || num >= competencia.length)
			throw new ArrayIndexOutOfBoundsException(num);
		this.competencia[num] = comp;
	}
	
	private String mostraCompetencias(){
		String comp = "";
		for(int i = 0; i < num_comp; i++){
			
			if(i == (num_comp-1)){
				comp += this.competencia[i];
			}else{
				comp += this.competencia[i]+" - ";
			}
			
		}//fecha for
		return comp;
	}//fecha mostraCompetencias()
	
	@Override
	public String toString() {
		
		return "Funcionario: "+this.nome+"\nSalario: "+this.salario+"\nCompetencias: ["
		+mostraCompetencias()+" ]"+"\n------------------------------------------------";
		
	}

}//close class

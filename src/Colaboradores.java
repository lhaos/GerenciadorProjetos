
public class Colaboradores {

	private String proj;
	private String func;
	private String comp;

	public Colaboradores(String nome_proj, String nome_func, String comp) {
		this.proj = nome_proj;
		this.func = nome_func;
		this.comp = comp;
	}
	
	@Override
	public String toString() {
		
		return "Projeto: "+this.proj+
				"\nFuncionario: "+this.func+
				"\nCompetencia: "+this.comp+
				"\n----------------------------------------------------";
		
	}

}

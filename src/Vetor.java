
public class Vetor <V> {
	private V[] dados = (V[])new Object[10];
	private int numElements = 0;
	
	public void append(V valor){
		aumentaEspaco();
		dados[numElements] = valor;
		numElements++;
	}

	private void aumentaEspaco() {
		if(numElements >= dados.length){
			@SuppressWarnings("unchecked")
			V[] temp = (V[]) new Object[dados.length*2];
			for(int i = 0; i < dados.length; i++){
				temp[i] = dados[i];
			}//close for
			dados = temp;
		}
	}//close method for new lenght
	
	public V get(int index){
		validaIndex(index);
		return dados[index];
	}//fecha get
	

	public void getVetor(){
		for(int i = 0; i < dados.length; i++){
			if(dados[i] != null){
				System.out.println(i + "º" +"\n");
				System.out.println(dados[i]);
			}//fecha if
		}//fecha for
	}//fecha getVetor
	
	public int size() {
		return numElements;
	}//fecha size
	
	public void insert(int index, V valor) {
		validaIndex(index);
		aumentaEspaco();
		for(int i = numElements; i > index; i--){
			dados[i] = dados[i-1];			
		}
		dados[index] = valor;
		numElements++;
	}//fecha insert

	private void validaIndex(int index) {
		if(index < 0 || index >= dados.length){
			throw new ArrayIndexOutOfBoundsException(index);
		} 
	}//fecha valida index
	
	public void remove(int index) {
		validaIndex(index);
		for (int i = index; i < numElements; i++) {
				if(dados[i+1] == null){
					dados[i] = null;
				}else{
				dados[i] = dados[i+1];
				}//fecha if-else
		}
		numElements--;
	}//fecha remove

	public boolean testeIgual(String comp) {//incorreto, dps tento a correcao
		boolean fim = false;
		for(int i = 0; i < dados.length; i++){
			if(dados[i].equals(comp)){
				fim = true;
			}
		}
		return fim;
	}//fecha metodo
	
	
	
}//close class

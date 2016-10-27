
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
			V[] temp = (V[]) new Object[dados.length*2];
			for(int i = 0; i < dados.length; i++){
				temp[i] = dados[i];
			}//close for
			dados = temp;
		}
	}//close method for new lenght
	
	
	
}//close class

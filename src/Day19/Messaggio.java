package Day19;

public class Messaggio {
	
	private int indice;
	private String value;
	
	
	public Messaggio(int indice, String value) {
		super();
		this.indice = indice;
		this.value = value;
	}
	
	
	public int getIndice() {
		return indice;
	}


	public void setIndice(int indice) {
		this.indice = indice;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "Cella [indice=" + indice + ", value =" + value + "]";
	}
	
	
	

}

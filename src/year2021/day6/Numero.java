package year2021.day6;

public class Numero {
	Integer numero;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Numero [numero=" + numero + "]";
	}

	public Numero(Integer numero) {
		super();
		this.numero = numero;
	}
	

}

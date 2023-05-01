package year2022.day7;

public class Archivio {

	String tipo;
	int value;
	String nome;
	String parent;
	
	public Archivio() {
		// TODO Auto-generated constructor stub
	}

	public Archivio(String tipo, int value, String nome, String parent) {
		super();
		this.tipo = tipo;
		this.value = value;
		this.nome = nome;
		this.parent = parent;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Archivio [tipo=" + tipo + ", value=" + value + ", nome=" + nome
				+ ", parent=" + parent + "]";
	}
	
	

}

package year2022.day20;

public class Numero implements Comparable<Numero>{

	int posizione;
	long valore;
	
	public Numero(int posizione, long valore) {
		// TODO Auto-generated constructor stub
		this.posizione= posizione;
		this.valore=valore;
	}

	@Override
	public int compareTo(Numero arg0) {
		// TODO Auto-generated method stub
		return (this.posizione - arg0.posizione);
	}

	@Override
	public String toString() {
		return "Numero [posizione=" + posizione + ", valore=" + valore + "]";
	}

}

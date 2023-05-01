package year2022.day15;

public class Assi implements Comparable<Assi>{

	int X;
	int Y;
	
	public Assi(int X, int Y) {
		// TODO Auto-generated constructor stub
		this.X= X;
		this.Y=Y;
	}

	@Override
	public int compareTo(Assi arg0) {
		// TODO Auto-generated method stub
		return (this.X - arg0.X);
	}

}

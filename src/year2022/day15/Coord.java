package year2022.day15;

public class Coord {
	long X1;
	long	X2;
	long	Y1;
	long 	Y2;
	long	R;
	
	
	public Coord() {
		// TODO Auto-generated constructor stub
			
	}
	
	public Coord(long X1,long	X2,	long	Y1,	long 	Y2,	long	R) {
		// TODO Auto-generated constructor stub
		this.X1=X1;
		this.X2=X2;
		this.Y1=Y1;
		this.Y2=Y2;
		this.R=R;	
	}
	
	public Coord(int XR,int	YR) {
		// TODO Auto-generated constructor stub
		this.X1=XR;
		
		this.Y1=YR;
		
			
	}


	public long getX1() {
		return X1;
	}


	public void setX1(long x1) {
		X1 = x1;
	}


	public long getX2() {
		return X2;
	}


	public void setX2(long x2) {
		X2 = x2;
	}


	public long getY1() {
		return Y1;
	}


	public void setY1(long y1) {
		Y1 = y1;
	}


	public long getY2() {
		return Y2;
	}


	public void setY2(long y2) {
		Y2 = y2;
	}


	public long getR() {
		return R;
	}


	public void setR(long r) {
		R = r;
	}
	
	//returns Manhattan distance to coord o
	public int dist1(Coord o) {
		return (int) ( Math.abs(X1 - o.getX1()) + Math.abs(Y1 - o.getY1()));
	}
	
	public int dist2(Coord o) {
		return (int) ( Math.abs(X1 - o.getX2()) + Math.abs(Y1 - o.getY2()));
	}

}

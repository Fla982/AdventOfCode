package year2021.day9;

import java.util.Map;

public class adiacente {
	public final static String floor = ".";
	
	public static Cella getPostoAdiacente(Cella direzione, int row, int columne, Map<Cella,String> postiAeroplano){
		Cella cella = new Cella(direzione.getRow()+row, direzione.getColumn()+columne);
		
		while(floor.equals("" +postiAeroplano.get(cella)) ){
			cella = new Cella(cella.getRow()+row, cella.getColumn()+columne);
		}
		
		return cella;
	}
}

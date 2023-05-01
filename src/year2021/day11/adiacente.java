package year2021.day11;

import java.util.Map;

public class adiacente {
	public final static String floor = ".";
	
	public static Cella getPostoAdiacente(Cella direzione, int row, int columne){
		Cella cella = new Cella(direzione.getRow()+row, direzione.getColumn()+columne);
		
		
		
		return cella;
	}
	
	public static Flash calcolaAdiacente(Cella direzione, int row, int columne, Map<Cella,Flash> lights){
		Cella cella = new Cella(direzione.getRow()+row, direzione.getColumn()+columne);
		
		if (lights.get(cella).isFlash()==true) return new Flash(0,true);
		if((int) lights.get(cella).getValue()!=0){
			if ((int) lights.get(cella).getValue() == 9){
				return new Flash(0,true);
			}
			else
				return new Flash((int) lights.get(cella).getValue() +1, false);
		}
		return new Flash(1,false);
	}
}

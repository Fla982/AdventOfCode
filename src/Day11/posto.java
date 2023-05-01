package Day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class posto {
	
	public final static String empty = "L";
	public final static String occupied = "#";
	public final static String floor = ".";
	
	public static String calculateNewValue(Cella seat, String value, Map<Cella,String> postiAeroplano, int lasRow, int lastColumn)
	{
		String newValue = null;
		
		List<Cella> puntiAdiacenti = new ArrayList<Cella>();
		List<String> postiAdiacenti  = new ArrayList<String>();
		
		System.out.println("Value: " + value);
		puntiAdiacenti.add(new Cella(seat.getRow(),seat.getColumn() + 1));
		puntiAdiacenti.add(new Cella(seat.getRow(),seat.getColumn() -1 ));
		puntiAdiacenti.add(new Cella(seat.getRow()+ 1,seat.getColumn()));
		puntiAdiacenti.add(new Cella(seat.getRow()+ 1,seat.getColumn()+1));
		puntiAdiacenti.add(new Cella(seat.getRow()+1 ,seat.getColumn()-1));
		puntiAdiacenti.add(new Cella(seat.getRow()-1, seat.getColumn()));
		puntiAdiacenti.add(new Cella(seat.getRow()-1, seat.getColumn()+1));
		puntiAdiacenti.add(new Cella(seat.getRow()-1, seat.getColumn()-1));
		System.out.println("Punti Adiacenti: " + puntiAdiacenti.toString());
		if (value.equals(empty))
		{
			
			for (Cella c: puntiAdiacenti){
				
				if (postiAeroplano.get(c) != null) postiAdiacenti.add(postiAeroplano.get(c));
				
			}
			for (String posto: postiAdiacenti){
				if (posto.equals(occupied))
					newValue = value;
				
			}
			if (newValue == null)
				newValue = occupied;
		}
		if (value.equals(occupied)){
			int conta = 0;
			for (Cella c: puntiAdiacenti){
				System.out.println("Valore posto adiacente: " +  postiAeroplano.get(c));
				if (postiAeroplano.get(c) != null) postiAdiacenti.add(postiAeroplano.get(c));
				
			}
			for (String posto: postiAdiacenti){
				if (posto.equals(occupied))
					conta++;
			}
			if (conta >= 4) newValue = empty; else newValue = value;
				
		}
		if (value.equals(floor)) newValue = value;
			
		return newValue;
	}
		
	public static  String calculateNewValue2(Cella seat, String value, Map<Cella,String> postiAeroplano, int lasRow, int lastColumn)
	{
		String newValue = null;
		
		List<Cella> puntiAdiacenti = new ArrayList<Cella>();
		List<String> postiAdiacenti  = new ArrayList<String>();
		
		System.out.println("Value: " + value);
		/*puntiAdiacenti.add(new Cella(seat.getRow(),seat.getColumn() + 1));
		puntiAdiacenti.add(new Cella(seat.getRow(),seat.getColumn() -1 ));
		puntiAdiacenti.add(new Cella(seat.getRow()+ 1,seat.getColumn()));
		puntiAdiacenti.add(new Cella(seat.getRow()+ 1,seat.getColumn()+1));
		puntiAdiacenti.add(new Cella(seat.getRow()+1 ,seat.getColumn()-1));
		puntiAdiacenti.add(new Cella(seat.getRow()-1, seat.getColumn()));
		puntiAdiacenti.add(new Cella(seat.getRow()-1, seat.getColumn()+1));
		puntiAdiacenti.add(new Cella(seat.getRow()-1, seat.getColumn()-1));*/
		
		puntiAdiacenti.add( adiacente.getPostoAdiacente(new Cella(seat.getRow(),seat.getColumn() ), 0, 1, postiAeroplano));
		puntiAdiacenti.add(adiacente.getPostoAdiacente(new Cella(seat.getRow(),seat.getColumn()  ),0, -1, postiAeroplano));
		puntiAdiacenti.add(adiacente.getPostoAdiacente(new Cella(seat.getRow(),seat.getColumn()),1,0,postiAeroplano));
		puntiAdiacenti.add(adiacente.getPostoAdiacente(new Cella(seat.getRow(),seat.getColumn()),1,1,postiAeroplano));
		puntiAdiacenti.add(adiacente.getPostoAdiacente(new Cella(seat.getRow() ,seat.getColumn()),1,-1,postiAeroplano));
		puntiAdiacenti.add(adiacente.getPostoAdiacente(new Cella(seat.getRow(), seat.getColumn()),-1,0,postiAeroplano));
		puntiAdiacenti.add(adiacente.getPostoAdiacente(new Cella(seat.getRow(), seat.getColumn()),-1,1,postiAeroplano));
		puntiAdiacenti.add(adiacente.getPostoAdiacente(new Cella(seat.getRow(), seat.getColumn()),-1,-1,postiAeroplano));
		System.out.println("Punti Adiacenti: " + puntiAdiacenti.toString());
		if (value.equals(empty))
		{
			
			for (Cella c: puntiAdiacenti){
				
				if (postiAeroplano.get(c) != null) postiAdiacenti.add(postiAeroplano.get(c));
				
			}
			for (String posto: postiAdiacenti){
				if (posto.equals(occupied))
					newValue = value;
				
			}
			if (newValue == null)
				newValue = occupied;
		}
		if (value.equals(occupied)){
			int conta = 0;
			for (Cella c: puntiAdiacenti){
				System.out.println("Valore posto adiacente: " +  postiAeroplano.get(c));
				if (postiAeroplano.get(c) != null) postiAdiacenti.add(postiAeroplano.get(c));
				
			}
			for (String posto: postiAdiacenti){
				if (posto.equals(occupied))
					conta++;
			}
			if (conta >= 5) newValue = empty; else newValue = value;
				
		}
		if (value.equals(floor)) newValue = value;
			
		return newValue;
	}

	static Cella getPostoAdiacente(Cella direzione, int row, int columne, Map<Cella,String> postiAeroplano){
		Cella cella = new Cella(row + direzione.getRow(), columne + direzione.getColumn());
		while(postiAeroplano.get(cella).equals(floor) ){
			cella = new Cella(cella.getRow()+row, cella.getColumn()+columne);
		}
		
		return cella;
	}
	
}

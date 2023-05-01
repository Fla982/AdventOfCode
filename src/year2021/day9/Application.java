package year2021.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {

	static String finito = "";
	static int occupati = 0;

	public static void main(String[] args) {
		
		String path = "d:\\levels.txt";
		int maxRow = 0;	
		int maxColumn = 0;
		int uguali = 0;
		Map<Cella,String> postoAeroplano = new HashMap<Cella,String>();
		Map<Cella,String> postoAeroplanoNuovo = new HashMap<Cella,String>();
		String[] previousSeats = new String[95];
		String[] newSeats = new String[95] ;
		List<Integer> list = new ArrayList<>();
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				
				System.out.println("Fila " + i + ": " + line+ "");
				for (int c=0; c < line.length(); c++){
					postoAeroplano.put(new Cella(i,c), String.valueOf(line.charAt(c)));
					if (maxColumn < c) maxColumn = c;
				}
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			maxRow = i;
			maxColumn = maxColumn++;
			System.out.println("Max Row: "+ maxRow);
		    System.out.println("Max Column: " + maxColumn);
		    
			// compare lists
		    Iterator <Cella> it = postoAeroplano.keySet().iterator();       //keyset is a method
			String newValue;
			while(it.hasNext())  
			{  
				
				String riga = "";
				int r = 0;
				Cella key=(Cella)it.next();  
				System.out.println("Seats no.: "+key.toString()+"     value: "+postoAeroplano.get(key));
				newValue = posto.calculateNewValue(key, postoAeroplano.get(key), postoAeroplano, 0, 0);
				if (newValue.equals("SI")) list.add(Integer.valueOf(postoAeroplano.get(key)));
				System.out.println("New Value: " + newValue);
				
				//newSeats[key.getRow()].substring(key.getColumn(),key.getColumn()+1).replace(newSeats[key.getRow()].substring(key.getColumn(),key.getColumn()+1), newValue); 
				
			}
		   
			
			  
			// conta posti occupati
			for (Integer numero: list){
				occupati = occupati +1 + numero;
			}
			
			
			System.out.println("TOTALE POSTI OCCUPATI: " + occupati);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

package Day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application2 {

	static String finito = "";
	static int occupati = 0;

	public static void main(String[] args) {
		
		String path = "d:\\airplane.txt";
		int maxRow = 0;	
		int maxColumn = 0;
		int uguali = 0;
		Map<Cella,String> postoAeroplano = new HashMap<Cella,String>();
		Map<Cella,String> postoAeroplanoNuovo = new HashMap<Cella,String>();
		String[] previousSeats = new String[95];
		String[] newSeats = new String[95] ;
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				newSeats[i] = line;
				previousSeats[i] = "";
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
		    while (finito.equals("SI") == false){
		    	// calculate new seats
				
				Iterator <Cella> it = postoAeroplano.keySet().iterator();       //keyset is a method
				String newValue;
				while(it.hasNext())  
				{  
					
					String riga = "";
					int r = 0;
					Cella key=(Cella)it.next();  
					System.out.println("Seats no.: "+key.toString()+"     value: "+postoAeroplano.get(key));
					newValue = posto.calculateNewValue2(key, postoAeroplano.get(key), postoAeroplano, 0, 0);
					System.out.println("New Value: " + newValue);
					postoAeroplanoNuovo.put(key, newValue);
					//riga = riga + postoAeroplano.get(key);
					System.out.println("Vecchia fila: " + newSeats[key.getRow()]);
					String strBeforeChar = newSeats[key.getRow()].substring(0, key.getColumn());
					String strAfterChar  = newSeats[key.getRow()].substring(key.getColumn() + 1);
					String newStr  = strBeforeChar + newValue + strAfterChar;
					newSeats[key.getRow()] = newStr;
					System.out.println("Nuova fila: " + newStr);
					//newSeats[key.getRow()].substring(key.getColumn(),key.getColumn()+1).replace(newSeats[key.getRow()].substring(key.getColumn(),key.getColumn()+1), newValue); 
					
				}
				for(int z = 0; z <= maxRow-1; z++){
				
					if (previousSeats.length == newSeats.length )
					{
						System.out.println("Previous: " + previousSeats[z]);
						System.out.println("New: " + newSeats[z]);
						String previous = previousSeats[z];
						String next = newSeats[z];
						if (previous.equals(next))	uguali++;
						else {
							previousSeats[z] = next;
						
						}
					}
				}
				//if (postoAeroplano.equals(postoAeroplanoNuovo)) finito = "SI";
				
				if (uguali == maxRow) finito = "SI";
				else {
					uguali = 0; 
					//postoAeroplano = new HashMap<Cella,String>(); 
					postoAeroplano.putAll(postoAeroplanoNuovo);
					System.out.println("Posti aeroplano: " + postoAeroplano.toString());
					//postoAeroplanoNuovo= new HashMap<Cella,String>();
				}
		    }
			
			  
			// conta posti occupati
			if( finito.equals("SI"))
			{
				/*for(int z = 0; z < newSeats.length; z++)
				{
					for(int p = 0; p < newSeats[z].length(); p++){
						if (newSeats[z].charAt(p) == '#') occupati++;
					}
				}*/
				Iterator <Cella> it = postoAeroplanoNuovo.keySet().iterator();       //keyset is a method
				String newValue;
				while(it.hasNext())  
				{  
					
					String riga = "";
					int r = 0;
					Cella key=(Cella)it.next();  
					
					if (postoAeroplanoNuovo.get(key).equals("#")) occupati++;
					System.out.println("Seats no.: "+key.toString()+"     value: "+postoAeroplanoNuovo.get(key) + " occupati: " + occupati);
				}
			}
			
			
			System.out.println("TOTALE POSTI OCCUPATI: " + occupati);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

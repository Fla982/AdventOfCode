package year2021.day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import year2021.day11.*;


public class Application2 {

	static String finito = "";
	static final int step = 100;
	static Map<Cella,Flash> lights = new LinkedHashMap<Cella,Flash>();
	static int maxRow = 0;	
	static int maxColumn = 10;

	public static void main(String[] args) {
		
		String path = "d:\\flash.txt";
		
		int totale = 0;
		//Map<Cella,Flash> lights = new HashMap<Cella,Flash>();
		

		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				System.out.println("Fila " + i + ": " + line+ "");
				for (int c=0; c < line.length(); c++){
					lights.put(new Cella(i,c), new Flash(Integer.parseInt(String.valueOf(line.charAt(c))),false));
					
				}
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			maxRow = i;
			//maxColumn = maxColumn++;
			System.out.println("Max Row: "+ maxRow);
		    System.out.println("Max Column: " + maxColumn);
		    
			// steps
		    for (int z = 1; z < step+1; z++){
		    	Iterator <Cella> it = lights.keySet().iterator();       //keyset is a method
				String newValue;
				while(it.hasNext())  
				{  
					
					String riga = "";
					int r = 0;
					maxRow = 0;
					Cella key=(Cella)it.next();  
					System.out.println("Seats no.: "+key.toString()+"     value: "+lights.get(key));
					if (lights.get(key).isFlash() == false){
						if ((int) lights.get(key).getValue()==9){
							lights.put(key, new Flash(0,true));
							//calcola adiacenti
							if (lights.get(adiacente.getPostoAdiacente(key, 0, 1)) != null) lights.put(key, calcolaAdiacente2(key, 0, 1));
							if (lights.get(adiacente.getPostoAdiacente(key, 0, -1)) != null) lights.put(key, calcolaAdiacente2(key, 0, -1));
							if (lights.get(adiacente.getPostoAdiacente(key, 1, 0)) != null) lights.put(key, calcolaAdiacente2(key, 1, 0));
							if (lights.get(adiacente.getPostoAdiacente(key, -1, 0)) != null) lights.put(key, calcolaAdiacente2(key, -1, 0));
							if (lights.get(adiacente.getPostoAdiacente(key,  1, 1)) != null) lights.put(key, calcolaAdiacente2(key, 1, 1));
							if (lights.get(adiacente.getPostoAdiacente(key, 1, -1)) != null) lights.put(key, calcolaAdiacente2(key, 1, -1));
							if (lights.get(adiacente.getPostoAdiacente(key, -1, 1)) != null) lights.put(key, calcolaAdiacente2(key, -1, 1));
							if (lights.get(adiacente.getPostoAdiacente(key, -1, -1)) != null) lights.put(key, calcolaAdiacente2(key, -1, -1));
						}
						else{
							r = (int) lights.get(key).getValue() +1;
							lights.put(key, new Flash(r,false));
						}
					}
				}
				// conteggio
				Iterator <Cella> it2 = lights.keySet().iterator();       //keyset is a method
				
				while(it2.hasNext())  
				{  
					
					String riga = "";
					int r = 0;
					Cella key=(Cella)it2.next();
					if ((int) lights.get(key).getValue() == 0) {
						lights.put(key, new Flash(0,false));
						totale = totale +1 ;
					}
				}
				System.out.println("Conteggio step " + z + ": " + totale);
		    }
			
			System.out.println("TOTALE POSTI OCCUPATI: " + totale);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}
	public static Flash calcolaAdiacente2(Cella direzione, int row, int columne) throws Exception{
			Cella cella = new Cella(direzione.getRow()+row, direzione.getColumn()+columne);
		try {	
			if (direzione.getRow() == 1 && direzione.getColumn()==1){
				System.out.println("qui");
			}
			if (maxRow == maxColumn){
				maxRow = 0;
				return new Flash(0,true);
				
			}
			if (lights.get(cella).isFlash()==true) return new Flash(0,true);
			if((int) lights.get(cella).getValue()!=0){
				if ((int) lights.get(cella).getValue() == 9){
					maxRow ++;
					lights.put(cella, new Flash(0,true));
					
					if (lights.get(adiacente.getPostoAdiacente(cella, 0, 1)) != null) lights.put(cella, calcolaAdiacente2(cella, 0, 1));
					if (lights.get(adiacente.getPostoAdiacente(cella, 0, -1)) != null) lights.put(cella, calcolaAdiacente2(cella, 0, -1));
					if (lights.get(adiacente.getPostoAdiacente(cella, 1, 0)) != null) lights.put(cella, calcolaAdiacente2(cella, 1, 0));
					if (lights.get(adiacente.getPostoAdiacente(cella, -1, 0)) != null) lights.put(cella, calcolaAdiacente2(cella, -1, 0));
					if (lights.get(adiacente.getPostoAdiacente(cella,  1, 1)) != null) lights.put(cella, calcolaAdiacente2(cella, 1, 1));
					if (lights.get(adiacente.getPostoAdiacente(cella, 1, -1)) != null) lights.put(cella, calcolaAdiacente2(cella, 1, -1));
					if (lights.get(adiacente.getPostoAdiacente(cella, -1, 1)) != null) lights.put(cella, calcolaAdiacente2(cella, -1, 1));
					if (lights.get(adiacente.getPostoAdiacente(cella, -1, -1)) != null) lights.put(cella, calcolaAdiacente2(cella, -1, -1));
					return new Flash(0,true);
				}
				else
					return new Flash((int) lights.get(cella).getValue() +1, false);
			}
			return new Flash(1,false);
		
		}	
	
		catch(Exception e) {
	
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		return null;
	}

}

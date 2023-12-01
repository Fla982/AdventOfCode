package year2023.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Application2 {

	public enum Numbers {
	    ONE ("1"), TWO ("2"), THREE("3"), FOUR("4"),
	    FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9");
	    
	    public final String label;

	    private Numbers(String label) {
	        this.label = label;
	    }
	}
	

	public static void main(String[] args) {
		
		String path = "d:\\trabucco.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			int somma = 0;
			int i = 0;
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				int maxInt = 0;
				int minInt = 0;
				Map<Integer, Integer> mappa = new TreeMap<>();
				for(int d = 0; d < line.length(); d++){
					String parola = line.substring(d);
					if (parola.indexOf(Numbers.ONE.name().toLowerCase()) > -1)
						mappa.put(parola.indexOf(Numbers.ONE.name().toLowerCase())+d, Integer.parseInt(Numbers.ONE.label));
					if (parola.indexOf(Numbers.TWO.name().toLowerCase()) > -1)
						mappa.put(parola.indexOf(Numbers.TWO.name().toLowerCase())+d, Integer.parseInt(Numbers.TWO.label));
					if (parola.indexOf(Numbers.THREE.name().toLowerCase()) > -1)
						mappa.put(parola.indexOf(Numbers.THREE.name().toLowerCase())+d, Integer.parseInt(Numbers.THREE.label));
					if (parola.indexOf(Numbers.FOUR.name().toLowerCase()) > -1)
						mappa.put(parola.indexOf(Numbers.FOUR.name().toLowerCase())+d, Integer.parseInt(Numbers.FOUR.label));
					if (parola.indexOf(Numbers.FIVE.name().toLowerCase()) > -1)
						mappa.put(parola.indexOf(Numbers.FIVE.name().toLowerCase())+d, Integer.parseInt(Numbers.FIVE.label));
					if (parola.indexOf(Numbers.SIX.name().toLowerCase()) > -1)
						mappa.put(parola.indexOf(Numbers.SIX.name().toLowerCase())+d, Integer.parseInt(Numbers.SIX.label));
					if (parola.indexOf(Numbers.SEVEN.name().toLowerCase()) > -1)
						mappa.put(parola.indexOf(Numbers.SEVEN.name().toLowerCase())+d, Integer.parseInt(Numbers.SEVEN.label));
					if (parola.indexOf(Numbers.EIGHT.name().toLowerCase()) > -1)
						mappa.put(parola.indexOf(Numbers.EIGHT.name().toLowerCase())+d, Integer.parseInt(Numbers.EIGHT.label));
					if (parola.indexOf(Numbers.NINE.name().toLowerCase()) > -1)
						mappa.put(parola.indexOf(Numbers.NINE.name().toLowerCase())+d, Integer.parseInt(Numbers.NINE.label));
					if (parola.indexOf(Numbers.ONE.label) > -1)
						mappa.put(parola.indexOf(Numbers.ONE.label)+d, Integer.parseInt(Numbers.ONE.label));
					if (parola.indexOf(Numbers.TWO.label) > -1)
						mappa.put(parola.indexOf(Numbers.TWO.label)+d, Integer.parseInt(Numbers.TWO.label));
					if (parola.indexOf(Numbers.THREE.label) > -1)
						mappa.put(parola.indexOf(Numbers.THREE.label)+d, Integer.parseInt(Numbers.THREE.label));
					if (parola.indexOf(Numbers.FOUR.label) > -1)
						mappa.put(parola.indexOf(Numbers.FOUR.label)+d, Integer.parseInt(Numbers.FOUR.label));
					if (parola.indexOf(Numbers.FIVE.label) > -1)
						mappa.put(parola.indexOf(Numbers.FIVE.label)+d, Integer.parseInt(Numbers.FIVE.label));
					if (parola.indexOf(Numbers.SIX.label) > -1)
						mappa.put(parola.indexOf(Numbers.SIX.label)+d, Integer.parseInt(Numbers.SIX.label));
					if (parola.indexOf(Numbers.SEVEN.label) > -1)
						mappa.put(parola.indexOf(Numbers.SEVEN.label)+d, Integer.parseInt(Numbers.SEVEN.label));
					if (parola.indexOf(Numbers.EIGHT.label) > -1)
						mappa.put(parola.indexOf(Numbers.EIGHT.label)+d, Integer.parseInt(Numbers.EIGHT.label));
					if (parola.indexOf(Numbers.NINE.label) > -1)
						mappa.put(parola.indexOf(Numbers.NINE.label)+d, Integer.parseInt(Numbers.NINE.label));
					
				}
				
				for (Integer key: mappa.keySet()) {
				    System.out.println(key + "=" + mappa.get(key));
				    if (minInt == 0)
				    	minInt = mappa.get(key);
				    maxInt = mappa.get(key);
				}
				
				somma = somma + Integer.parseInt(String.valueOf(minInt) + String.valueOf(maxInt));
				System.out.println("Riga " + i + ": Value: " + line + " minInt: " + minInt + " maxInt: " + maxInt);
				
				i++;
			}
			
			
			System.out.println("MAX SOMMA: " + somma);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

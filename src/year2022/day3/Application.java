package year2022.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Application {



	public static void main(String[] args) {
		
		String path = "d:\\rucksacks.txt";
		Alfabeto alfabeto = new Alfabeto();
		int punteggio = 0;
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line;
			String[] binary = new String[1000];
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				String primo = line.substring(0, line.length() / 2);
				String secondo = line.substring(line.length() / 2, line.length());
				
				
				System.out.println("Riga " + i + ": value: " + line + " " );
				System.out.println("Primo: " + primo + " Secondo: " + secondo);
				for (String character: alfabeto.alfabeto.keySet()){
					if (primo.contains(character) && secondo.contains(character)){
						System.out.println("Trovato " + character);
						punteggio = punteggio + alfabeto.alfabeto.get(character);
					}
				}
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			System.out.println("TOTALE : " + punteggio); 
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

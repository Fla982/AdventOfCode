package year2022.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application2 {


	static int gamma = 0;
	static  int epsilon = 0;

	public static void main(String[] args) {
		
		String path = "d:\\rucksacks.txt";
		int punteggio = 0;	
		Alfabeto alfabeto = new Alfabeto();
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			int tre = 0;
			String line;

			List<String> group = new ArrayList<>();

			// read airplane seats
			while ((line = br.readLine()) != null) {
				if (group.size() == 3){
					for (String character: alfabeto.alfabeto.keySet()){
						if (group.get(0).contains(character) && group.get(1).contains(character) && group.get(2).contains(character)){
							System.out.println("Trovato " + character);
							punteggio = punteggio + alfabeto.alfabeto.get(character);
						}
					}
					System.out.println("Size: "+ group.size());
					group = new ArrayList<>();
					System.out.println("Size: "+ group.size());
				}
				
				group.add(line);
				
				
				
				System.out.println("Riga " + i + ": value: " + line + " " );
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			for (String character: alfabeto.alfabeto.keySet()){
				if (group.get(0).contains(character) && group.get(1).contains(character) && group.get(2).contains(character)){
					System.out.println("Trovato " + character);
					punteggio = punteggio + alfabeto.alfabeto.get(character);
				}
			}
			System.out.println("TOTALE : " + punteggio); 
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

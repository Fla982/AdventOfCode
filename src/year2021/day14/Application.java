package year2021.day14;

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
	static int totale = 0;
	static final int TONDA =  3;
	static final int QUADRATA = 57 ;
	static final int GRAFFA = 1197 ;
	static final int XML = 25137 ;
	

	public static void main(String[] args) {
		
		String path = "d:\\polymer.txt";
		int increased = 0;	
		int previousNumber = 0 ;
		int nextNumber = 0;
		Integer list[] = new Integer[2000];
		Map<String,String> pair = new HashMap<>();
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			List<String> simboli = new ArrayList<>();
			String character = "";
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				if (line.indexOf("->") > -1){
					String[] key = line.split("->");
					pair.put(key[0].trim(), key[1].trim());
				}
				else if (i == 0){
					character = line;
				}
				System.out.println("Riga " + i + ": Value: " + line);
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			for(int h = 1; h < 11; h++){
				String sottostringa = "";
				String newCharacter = "";
				for(int e = 0; e < character.length()-1; e++){
					sottostringa = (String) character.substring(e, e+2);
					newCharacter = newCharacter + String.valueOf(character.charAt(e)) + pair.get(sottostringa);
					if (e == character.length()-2) newCharacter = newCharacter+ String.valueOf(character.charAt(e+1));
				}
				character = newCharacter;
				
				System.out.println("Time: " + h + " polymer: " + character);
			}
			Map<String,Integer> characters = new HashMap<>();
			int n = 0;
			for(int a = 0; a < character.length(); a++){
				if (characters.get(String.valueOf(character.charAt(a))) == null){
					characters.put(String.valueOf(character.charAt(a)), 1);
				}
				else{
					n = characters.get(String.valueOf(character.charAt(a))) ;
					characters.put(String.valueOf(character.charAt(a)), n+1);
					
				}
					
				//characters.put(String.valueOf(character.charAt(a)), characters.get(String.valueOf(character.charAt(a))) == null ? 1 : characters.get(character.charAt(a)) +1) ;
			}
			
			System.out.println("TOTALE INCREASED: " + characters);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

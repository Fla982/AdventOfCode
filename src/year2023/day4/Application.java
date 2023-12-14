package year2023.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {

	

	public static void main(String[] args) {
		
		String path = "d:\\scratchcard.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			int somma = 0;
			int i = 0;
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				String[] array1 = line.split(":");	
				String[] array2 = array1[1].split("\\|");
				String[] array3 = array2[0].trim().split(" ");
				int winning = 0;
				for (int g = 0; g < array3.length; g++){
					String numero = array3[g].trim();
					String[] biglietto = array2[1].split(" "); 
					for (int h = 0; h < biglietto.length; h++){
						if (biglietto[h].trim().equals(numero) && numero.length() > 0){
							if (winning == 0)
								winning = 1;
							else
								winning = winning*2;
							
						}	
					}
					
					
				}
				System.out.println("winning: " + winning);
				somma += winning;
				
				//somma = somma + Integer.parseInt(String.valueOf(minInt) + String.valueOf(maxInt));
				System.out.println("Riga " + i + ": Value: " + line);
				
				
			}
			
			
			System.out.println("MAX SOMMA: " + somma);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

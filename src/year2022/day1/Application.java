package year2022.day1;

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
		
		String path = "d:\\snacks.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			int somma = 0;
			int maxSomma = 0;
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty() && line != null)
					somma = somma +Integer.valueOf(line);
				else {
					if (somma >= maxSomma) maxSomma =somma;
					somma = 0;
				}
							
				
				//System.out.println("Riga " + i + ": Value: " + list[i]);
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			
			System.out.println("MAX SOMMA: " + maxSomma);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

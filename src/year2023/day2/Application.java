package year2023.day2;

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
		
		String path = "d:\\bags.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			int somma = 0;
			int i = 0;
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				String[] array1 = line.split(":");	
				String[] array2 = array1[1].trim().split(";");
				boolean impossible = false;
				for (int g = 0; g < array2.length; g++){
					String[] array = array2[g].trim().split(",");
					for( int h = 0; h < array.length; h++){
						String[] value = array[h].trim().split(" ");
						if (array[h].trim().endsWith("red")){
							if (Integer.valueOf(value[0].trim())> 12) impossible = true;
						}
						else if (array[h].trim().endsWith("green")){
							if (Integer.valueOf(value[0].trim())> 13) impossible = true;
							
						}
						else if (array[h].trim().endsWith("blue")){
							if (Integer.valueOf(value[0].trim())> 14) impossible = true;
							
						}
					}
				}
				if (impossible == false) {
					String[] ID = array1[0].trim().split(" ");
					somma += Integer.valueOf(ID[1].trim());
				}
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

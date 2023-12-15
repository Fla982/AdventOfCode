package year2023.day15;

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
		
		String path = "d:\\ascii.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			int somma = 0;
			int i = 0;
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				String[] array = line.split(",");
				for (int h = 0; h < array.length; h++){
					String valore = array[h];
					int current = 0;
					for(int d = 0; d < valore.length(); d++){
						char c = valore.charAt(d);
						try
						{
							current = current +(int) c;
							current = current *17;
							current = current % 256;
							
							
								
						}
						catch (Exception e)
						{
							System.out.println(c + " non è u numero");
						}
					}	
					System.out.println(h + " current : " + current);
					somma += current;
				}
				
				
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

package year2023.day1;

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
				for(int d = 0; d < line.length(); d++){
					char c = line.charAt(d);
					try
					{
						int n = Integer.parseInt(String.valueOf(c));
						if (minInt == 0)
							minInt = n;
						maxInt = n;
						
							
					}
					catch (Exception e)
					{
						System.out.println(c + " non è u numero");
					}
				}
				somma = somma + Integer.parseInt(String.valueOf(minInt) + String.valueOf(maxInt));
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

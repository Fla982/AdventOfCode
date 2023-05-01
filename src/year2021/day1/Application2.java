package year2021.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application2 {

	static String finito = "";
	static int occupati = 0;

	public static void main(String[] args) {
		
		String path = "d:\\boat.txt";
		int increased = 0;	
		int previousNumber = 0 ;
		int nextNumber = 0;
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				previousNumber = nextNumber;
				nextNumber = Integer.valueOf(line);
				if (previousNumber > 0)
				{

					if (nextNumber > previousNumber ) increased++;
				}
				
				
				System.out.println("Riga " + i + ": Previous: " + previousNumber + " Next:  " + nextNumber + " Increase:  " + increased);
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			
			
			System.out.println("TOTALE INCREASED: " + increased);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

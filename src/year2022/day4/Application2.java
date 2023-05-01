package year2022.day4;

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
		
		String path = "d:\\pair.txt";
		int minPrimo = 0;	
		int maxPrimo = 0 ;
		int minSecondo = 0;
		int maxSecondo = 0;
		int contatore = 0;
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line;
			
			// read airplane seats
			while ((line = br.readLine()) != null) {
				String[] binary = line.split(",");	
				minPrimo = Integer.valueOf(binary[0].split("-")[0]);
				maxPrimo = Integer.valueOf(binary[0].split("-")[1]);
				minSecondo = Integer.valueOf(binary[1].split("-")[0]);
				maxSecondo = Integer.valueOf(binary[1].split("-")[1]);
				
				if  ((minPrimo > maxSecondo && maxPrimo> maxSecondo) || (minSecondo > maxPrimo && maxSecondo > maxPrimo)) System.out.println("no overlap"); 
				else contatore++;
				
				System.out.println("Riga " + i + ": value: " + line + " " );
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			System.out.println("TOTALE : " + contatore); 
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

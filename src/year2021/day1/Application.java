package year2021.day1;

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
	static int occupati = 0;

	public static void main(String[] args) {
		
		String path = "d:\\boat.txt";
		int increased = 0;	
		int previousNumber = 0 ;
		int nextNumber = 0;
		Integer list[] = new Integer[2000];
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				list[i] = Integer.valueOf(line);
								
				
				System.out.println("Riga " + i + ": Value: " + list[i]);
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			for (int z = 0; z+3 < list.length; z++){
				int previous3 = list[z]+list[z+1]+list[z+2];
				int next3 = list[z+1]+list[z+2]+list[z+3];;
				if (previous3 < next3)
					increased++;
			}
			
			System.out.println("TOTALE INCREASED: " + increased);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

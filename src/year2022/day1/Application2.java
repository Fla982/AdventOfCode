package year2022.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Application2 {

	

	public static void main(String[] args) {
		
		String path = "d:\\snacks.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			int somma = 0;
			int maxSomma = 0;
			SortedSet<Integer> sortedList = new TreeSet<Integer>(Collections.reverseOrder());
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty() && line != null)
					somma = somma +Integer.valueOf(line);
				else {
					sortedList.add(somma);
					somma = 0;
				}
							
				
				//System.out.println("Riga " + i + ": Value: " + list[i]);
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			List newList = new ArrayList<>(sortedList);
			System.out.println("PRIMO: " + sortedList.first());	
			System.out.println("SECONDO: " + newList.get(1));	
			System.out.println("TERZO: " + newList.get(2));	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

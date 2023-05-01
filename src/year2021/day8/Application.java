package year2021.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {


	static final int TWO = 2;
	static final int FOUR = 4;
	static final int THREE= 3;
	static final int SEVEN = 7;

	public static void main(String[] args) {
		
		String path = "d:\\segment.txt";
		int sommaCrab1 = 0;	
		int sommaCrab2 = 0 ;
		int sommaCrab3 = 0;
		int sommaCrab10 = 0;
		int[] crab2 = new int[1000];
		int[] crab1= new int[1000];
		int[]crab3= new int[1000];
		int[] crab10= new int[1000];
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			int somma = 0;
			String line;
			
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				//String[] inizio = line.split(" | ");
				String[] fine = line.trim().split(" ");
				
				
				System.out.println("Riga " + i + ": value: " + fine.length + " " );
				
				for (int d = 11; d < fine.length; d++)
				{
					if (fine[d].length() == TWO ){
						somma++;
					}
					if ( 
							fine[d].length() == FOUR  ){
						somma++;
					}
					if (
							fine[d].length() == THREE ){
						somma++;
					}
					if (
							fine[d].length() == SEVEN ){
						somma++;
					}
					System.out.println("Riga: " + d + " somma : " + somma);
				}
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			System.out.println("TOTALE SEGMENT: " + somma);			
			
			
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

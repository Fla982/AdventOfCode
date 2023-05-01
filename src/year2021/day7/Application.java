package year2021.day7;

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


	static int gamma = 0;
	static  int epsilon = 0;

	public static void main(String[] args) {
		
		String path = "d:\\crab.txt";
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
			
			String line;
			
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				String[] inizio = line.split(",");
				
				
				
				System.out.println("Riga " + i + ": value: " + inizio.length + " " );
				
				for (int z = 0; z < inizio.length; z++){
					crab1[z] = Integer.valueOf(inizio[z]);
					crab2[z] = Integer.valueOf(inizio[z]);
					crab3[z] = Integer.valueOf(inizio[z]);
					crab10[z] = Integer.valueOf(inizio[z]);
				}
				System.out.println("Riga 1000: value: " + crab1[999] + " " );
				i++;
				//if (maxRow < i) maxRow = i;
			}
			// crab 1
			for(int c = 0; c< crab1.length; c++ ){
				sommaCrab1 = 0;
				for(int p = 0; p< crab1.length; p++ ){
					
					int l = Math.abs(crab1[p]-c);
					sommaCrab1 = sommaCrab1 + l;
				}
				System.out.println("Tot Crab " + c + ": " + sommaCrab1);
			}
			
			
			
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

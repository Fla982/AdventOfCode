package year2022.day6;

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
		
		String path = "d:\\pair.txt";
		
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line;
			String newLine = "";
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				
				for(int z = 0; z < line.length(); z++){
					newLine = newLine+line.charAt(z)+",";
				}
				
				
				System.out.println("Riga " + i + ": value: " + line + " " );
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
					
			System.out.println("Total : " + newLine + " " );
			
			
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

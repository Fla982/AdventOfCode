package year2021.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {

	static final String UP = "up";
	static final String DOWN = "down";
	static final String FORWARD = "forward";
	static int horizontal = 0;
	static  int vertical = 0;

	public static void main(String[] args) {
		
		String path = "d:\\submarine.txt";
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
				
				if (line.indexOf(DOWN) >= 0)
				{
					vertical += Integer.valueOf(line.split(" ")[1].trim());
					
				}else if (line.indexOf(UP) >= 0){
					vertical -= Integer.valueOf(line.split(" ")[1].trim());
					
				}else if (line.indexOf(FORWARD)>=0){
					horizontal += Integer.valueOf(line.split(" ")[1].trim());
				}
				
				
				System.out.println("Riga " + i + ": horizontal: " + horizontal + " vertical : " + vertical);
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			
			
			System.out.println("TOTALE INCREASED: " + vertical * horizontal);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

package year2021.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {


	static int gamma = 0;
	static  int epsilon = 0;

	public static void main(String[] args) {
		
		String path = "d:\\binary.txt";
		int increased = 0;	
		int previousNumber = 0 ;
		int nextNumber = 0;
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line;
			String[] binary = new String[1000];
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				binary[i] = line;
				
				
				
				System.out.println("Riga " + i + ": value: " + line + " " );
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			String gammaBinary = "";
			String epsilonBinary = "";
			
			int numberOne = 0;
			int numberZero = 0;
			for (int a = 0; a< 12; a++){
				numberOne = 0;
				numberZero = 0;
				for (int l = 0; l< binary.length; l++){
					if (String.valueOf(binary[l].charAt(a)).equals("1")) numberOne++;
					else numberZero++;	
				}	
				if (numberOne > numberZero){
					gammaBinary = gammaBinary + "1";
					epsilonBinary = epsilonBinary + "0";
				}
				else{
					gammaBinary = gammaBinary + "0";
					epsilonBinary = epsilonBinary + "1";
				}
					
			}

			System.out.println("Gamma Binary: " + gammaBinary + " Epsilon Binary: " + epsilonBinary);
			
			
			 gamma = Integer.parseInt(gammaBinary, 2);
			 epsilon = Integer.parseInt(epsilonBinary, 2);
			System.out.println("TOTALE : " + gamma * epsilon); 
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

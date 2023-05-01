package year2021.day3;

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
			List<String> oxygenList = new ArrayList<>();
			List<String> co2List = new ArrayList<>();
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				binary[i] = line;
				oxygenList.add(line);
				co2List.add(line);
				
				
				System.out.println("Riga " + i + ": value: " + line + " " );
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			String oxygenBinary = "";
			String co2Binary = "";
			//oxygen generator rating
			int numberOne = 0;
			int numberZero = 0;
			for (int a = 0; a< 12; a++){
			//for (String s: oxygenList){	
				numberOne = 0;
				numberZero = 0;
				for (String s: oxygenList){
				//for (int l = 0; l< s.length(); l++){
					if (String.valueOf(s.charAt(a)).equals("1")) numberOne++;
					else numberZero++;	
				}	
				if (numberOne == numberZero) oxygenBinary = oxygenBinary + "1";
				else if (numberOne > numberZero){
					oxygenBinary = oxygenBinary + "1";
					//epsilonBinary = epsilonBinary + "0";
				}
				else{
					oxygenBinary = oxygenBinary + "0";
					//epsilonBinary = epsilonBinary + "1";
				}
				for(int d = oxygenList.size()-1; d >= 0; d--){
					if (oxygenList.get(d).startsWith(oxygenBinary)==false) oxygenList.remove(d);
				}
				System.out.println("Oxygen List size: "  + a);
				if ( oxygenList.size() == 1) a = 12;
					
			}
			//CO2 scrubber rating
			for (int a = 0; a< 12; a++){
				//for (String s: oxygenList){	
					numberOne = 0;
					numberZero = 0;
					for (String s: co2List){
					//for (int l = 0; l< s.length(); l++){
						if (String.valueOf(s.charAt(a)).equals("1")) numberOne++;
						else numberZero++;	
					}	
					if (numberOne == numberZero) co2Binary = co2Binary + "0";
					else if (numberOne > numberZero){
						co2Binary = co2Binary + "0";
						//epsilonBinary = epsilonBinary + "0";
					}
					else{
						co2Binary = co2Binary + "1";
						//epsilonBinary = epsilonBinary + "1";
					}
					for(int d = co2List.size()-1; d >= 0; d--){
						if (co2List.get(d).startsWith(co2Binary)==false) co2List.remove(d);
						//System.out.println("co2List size: " + co2List.size());
					}
					System.out.println("CO2 List size: "  + a);
					if ( co2List.size() == 1) a = 12;
				}
			
			System.out.println("Oxygen Binary: " + oxygenList.get(0) + " CO2 Binary: " + co2List.get(0));
			System.out.println("FINAL OXYGEN SIZE: " + oxygenList.size());
			System.out.println("FINAL CO2 SIZE: " + co2List.size());
			 gamma = Integer.parseInt(oxygenList.get(0), 2);
			 epsilon = Integer.parseInt(co2List.get(0), 2);
			System.out.println("TOTALE : " + gamma * epsilon); 
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

package year2021.day10;

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
	static int totale = 0;
	static final int TONDA =  3;
	static final int QUADRATA = 57 ;
	static final int GRAFFA = 1197 ;
	static final int XML = 25137 ;
	

	public static void main(String[] args) {
		
		String path = "d:\\parentesti.txt";
		int increased = 0;	
		int previousNumber = 0 ;
		int nextNumber = 0;
		Integer list[] = new Integer[2000];
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			List<String> simboli = new ArrayList<>();
			String character = "";
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				simboli = new ArrayList<>();
				for (int z = 0; z < line.length(); z++){
					character = String.valueOf(line.charAt(z));
					
					if (character.equals("{") || character.equals("(") || character.equals("[") || character.equals("<")){
						simboli.add(character);
					}
					else if (character.equals("}")){
						 if (simboli.get(simboli.size()-1).equals("{")){
							simboli.remove(simboli.size()-1);
						}
						else{
							totale = totale + GRAFFA;
							z = line.length();
						}
					}
					else if (character.equals("]")){
						 if (simboli.get(simboli.size()-1).equals("[")){
							simboli.remove(simboli.size()-1);
						}
						else{
							totale = totale + QUADRATA;
							z = line.length();
						}
					}
					else if (character.equals(")")){
						 if (simboli.get(simboli.size()-1).equals("(")){
							simboli.remove(simboli.size()-1);
						}
						else{
							totale = totale + TONDA;
							z = line.length();
						}
					}
					else if (character.equals(">")){
						 if (simboli.get(simboli.size()-1).equals("<")){
							simboli.remove(simboli.size()-1);
						}
						else{
							totale = totale + XML;
							z = line.length();
						}
					}
				}
								
				
				System.out.println("Riga " + i + ": Value: " + line);
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			
			
			System.out.println("TOTALE INCREASED: " + totale);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

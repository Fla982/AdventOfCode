package year2021.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application2 {

	static int coefficient = 5;
	static long totale = 0;
	static final int TONDA =  1;
	static final int QUADRATA = 2 ;
	static final int GRAFFA = 3 ;
	static final int XML = 4 ;
	static List<Long> finale = new ArrayList<>();


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
			List<String> incompleti = new ArrayList<>();
			String character = "";
			String line;
			String errata = "";
			// read airplane seats
			while ((line = br.readLine()) != null) {
				simboli = new ArrayList<>();
				errata = "";
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
							errata = "SI";
						}
					}
					else if (character.equals("]")){
						 if (simboli.get(simboli.size()-1).equals("[")){
							simboli.remove(simboli.size()-1);
						}
						else{
							totale = totale + QUADRATA;
							z = line.length();
							errata = "SI";
						}
					}
					else if (character.equals(")")){
						 if (simboli.get(simboli.size()-1).equals("(")){
							simboli.remove(simboli.size()-1);
						}
						else{
							totale = totale + TONDA;
							z = line.length();
							errata = "SI";
						}
					}
					else if (character.equals(">")){
						 if (simboli.get(simboli.size()-1).equals("<")){
							simboli.remove(simboli.size()-1);
						}
						else{
							totale = totale + XML;
							z = line.length();
							errata = "SI";
						}
					}
				}
								
				totale = 0;
				System.out.println("Riga " + i + ": Value: " + line);
				if (!errata.equals("SI")) {
					incompleti = new ArrayList<>();
					
					
					for (int g = simboli.size()-1; g >= 0; g--){
						if (simboli.get(g).equals("<")){
							incompleti.add(">");
						}
						else if (simboli.get(g).equals("(")){
							incompleti.add(")");
						}
						else if (simboli.get(g).equals("[")){
							incompleti.add("]");
						}
						else if (simboli.get(g).equals("{")){
							incompleti.add("}");
						}
					}
					for(String simbolo: incompleti){
						totale = totale * coefficient;
						if (simbolo.equals(")")){
							totale = totale + TONDA;
						}
						else if (simbolo.equals("]")){
							totale = totale + QUADRATA;
						}
						else if (simbolo.equals("}")){
							totale = totale + GRAFFA;
						}
						else if (simbolo.equals(">")){
							totale = totale + XML;
						}

					}
					finale.add(totale);
					
				}
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			
			
			System.out.println("TOTALE INCREASED: " + finale);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

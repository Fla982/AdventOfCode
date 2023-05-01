package year2022.day25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {

	
	public static void main(String[] args) {
		
		String path = "d:\\snafu.txt";
		long totale = 0;	
		
		Integer list[] = new Integer[2000];
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line; 
			
			// read airplane seats
			while ((line = br.readLine()) != null) {
				long somma = 0;
				int t = 0;
				for (int j = line.length(); j>0; j--){
					String value = String.valueOf(line.charAt(j-1));
					long v = calcolaScore(value, t);
					somma = somma +v;
					t++;
				}
				
				System.out.println("Riga " + i + ": Value: " + line + " - Somma: " + somma);
				totale = totale + somma;
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			
			
			System.out.println("TOTALE INCREASED: " + totale);	
			
			String num = numBuilder(totale);
			System.out.println("TOTALE TRADUCTED: " + num);
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}
	
	public static  long calcolaScore(String value, int time){
		int risultato = 0;
		if (value.equals("-")) risultato = -1;
		else if (value.equals("=")) risultato = -2;
		else risultato = Integer.parseInt(value);
		double multiply =  Math.pow(5,time);
		
		return (long) (risultato * multiply);
	}
	
	 public static String numBuilder(long num) {
	        if(num == 0)
	            return "";
	        int divisione = (int) (num % 5) ; 
	        if (divisione == 0){
	        	return numBuilder(num / 5) + "0";
	        }
	        else if (divisione  == 1){
	        	return numBuilder(num / 5) + "1";
	        }
	        else if (divisione == 2){
	        	return numBuilder(num / 5) + "2";
	        }
	        else if (divisione == 3){
	        	return numBuilder((num + 2) / 5L) + "=";
	        }
	        else if (divisione ==4){
	        	return numBuilder((num + 1) / 5L) + "-";
	        }
	        else return null;
	        
	    }

}

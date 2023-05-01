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

public class Application2 {

	static final int ZERO = 0;
	static final int ONE = 1;
	static final int TWO = 2;
	static final int FOUR = 4;
	static final int THREE= 3;
	static final int FIVE = 5;
	static final int SIX = 6;
	static final int SEVEN = 7;
	static final int EIGHT = 8;
	static final int NINE = 9;

	public static void main(String[] args) {
		
		String path = "d:\\segment.txt";
		int sommaCrab1 = 0;	
		int sommaCrab2 = 0 ;
		int sommaCrab3 = 0;
		int sommaCrab10 = 0;
		String[] segment = new String[10];
		String[] segments= new String[200];
		int[]crab3= new int[1000];
		int[] crab10= new int[1000];
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			int somma = 0;
			String line;
			for (int o = 0; o < segments.length; o++){
				segments[o] = "";
			}
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				//String[] inizio = line.split(" | ");
				String[] fine = line.trim().split(" ");
				for (int o = 0; o < segment.length; o++){
					segment[o] = "";
				}
				
				
				System.out.println("Linea " + i + ": value: " + fine.length + " " );
				
				int totaleNumeri = 0;
				for (int d = 0; d < 10; d++)
				{
					if (fine[d].length() == TWO ){
						totaleNumeri++;
						segment[ONE] = fine[d];//1
						
					}
					if ( 
							fine[d].length() == FOUR  ){
						totaleNumeri++;
						segment[FOUR] = fine[d];//4
					}
					if (
							fine[d].length() == THREE ){
						totaleNumeri++;
						segment[SEVEN] = fine[d];//7
					}
					if (
							fine[d].length() == SEVEN ){
						totaleNumeri++;
						segment[EIGHT] = fine[d];//8
					}
					if( fine[d].length() == FIVE){
						if (segment[ONE].length()>0 && segment[THREE].length() == 0){
							String val = segment[ONE];
							int uguali = 0;
							for(int j = 0; j < val.length(); j++){
								if(fine[d].indexOf(val.charAt(j)) > -1){
									uguali++;
								}
							}
							if (uguali == segment[ONE].length()){
								segment[THREE] = fine[d];//3
								totaleNumeri++;
							}
							
						}
						if (segment[ONE].length()>0  && segment[FOUR].length() > 0) {
							String val = segment[FOUR];
							int uguali = 0;
							for(int j = 0; j < val.length(); j++){
								if(fine[d].indexOf(val.charAt(j)) > -1){
									uguali++;
								}
							}
							String val2 = segment[ONE];
							int uguali2 = 0;
							for(int j = 0; j < val2.length(); j++){
								if(fine[d].indexOf(val2.charAt(j)) > -1){
									uguali2++;
								}
							}
							if ( !segment[THREE].equals(fine[d])&&(segment[FOUR].length() -uguali) == 1){
								segment[FIVE] = fine[d];//5
								totaleNumeri++;
							}
							if ( (segment[FOUR].length() -uguali) == 2){
								segment[TWO] = fine[d];//2
								totaleNumeri++;
							}
						}
					}
					else if (fine[d].length() == SIX){
						if (segment[ONE].length()>0 && segment[FOUR].length() > 0) {
							String val = segment[ONE];
							int uguali = 0;
							for(int j = 0; j < val.length(); j++){
								if(fine[d].indexOf(val.charAt(j)) > -1){
									uguali++;
								}
							}
							if (uguali != val.length()){
								segment[SIX] = fine[d];//6
								totaleNumeri++;
							}
							else{
								String val2 = segment[FOUR];
								int uguali2 = 0;
								for(int j = 0; j < val2.length(); j++){
									if(fine[d].indexOf(val2.charAt(j)) > -1){
										uguali2++;
									}
								}
								if (uguali2 == segment[FOUR].length()){
									segment[NINE] = fine[d];//9
									totaleNumeri++;
								}
								else{
									segment[ZERO] = fine[d];//0
									totaleNumeri++;
								}
							}
							
						}
						
					}
					
					if (d == 9){
						if ( segment[0].isEmpty() ||
							segment[1].isEmpty() || segment[2].isEmpty() || segment[3].isEmpty() || 
							segment[4].isEmpty() || segment[5].isEmpty() || segment[6].isEmpty() ||
							segment[7].isEmpty() || segment[8].isEmpty() || segment[9].isEmpty() ){
						d=-1;}
						
					}

					if (i == 5) 
						System.out.println("qua");
					
					//System.out.println("Riga: " + d + " somma : " + segment.toString());
				}
				String codice = "";
				int totaleUguali = 0;
				for (int d = 11; d < fine.length; d++){
					
					for(int c = 0; c < segment.length; c++){
						codice = segment[c];
						if (codice.length() == fine[d].length()){
							for(int e = 0; e < codice.length(); e++){
								if (fine[d].indexOf(codice.charAt(e))> -1 ){
									totaleUguali++;
								}
							}
							
							if (totaleUguali == codice.length()){
								segments[i] = segments[i] + String.valueOf(c);
								totaleUguali = 0;
							}
							else totaleUguali = 0;	
						}
						
						
					}
					System.out.println("Segment: " + d + " value: " +fine[d]+ " number: " + segments[i]);
				}
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			for(int f = 0; f < segments.length; f++){
				somma = somma + Integer.valueOf(segments[f]);
			}
			
			System.out.println("TOTALE SEGMENT: " + somma);			
			
			
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

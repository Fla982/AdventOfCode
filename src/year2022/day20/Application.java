package year2022.day20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Application {

	static String finito = "";
	static int startPlayer1 = 9;
	static int startPlayer2 = 3;
	static final int limit = 10;
	static int totalScorePlayer1 = 0;
	static int totalScorePlayer2 = 0;
	static int totalTimesPlayer1 = 0;
	static int totalTimesPlayer2 = 0;
	
	
	public static void main(String[] args) {
		
		String path = "d:\\mix.txt";
		List<Numero> listNumeri = new LinkedList<>();
		List<Numero> listNumeriOriginale = null;
		Integer list[] = new Integer[2000];
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			int startIndex = 0;
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
								
				
				System.out.println("Riga " + i + ": Value: " + line);
				listNumeri.add(new Numero(i, Integer.parseInt(line)));
				if(Integer.parseInt(line) == 0){
					System.out.println("Index of null: " + i);
					startIndex = i;
				}
				i++;
				//if (maxRow < i) maxRow = i;
			}
			listNumeriOriginale = new ArrayList<>(listNumeri);
			for(Numero numero: listNumeriOriginale){
				int posizioneOld = listNumeri.indexOf(numero);
				long valore = numero.valore;
				//if (valore>=0){
					listNumeri.remove(posizioneOld);
					int newPosizione = (int) Math.floorMod(posizioneOld+valore, listNumeri.size());
					listNumeri.add(newPosizione,numero) ;
					
				//}
				//else{
					
				//}
			}
			
			for(Numero numero: listNumeri){
				
				
				if (numero.valore == 0) {
					System.out.println("SONO QUI");
					startIndex = listNumeri.indexOf(numero);
				}
					
				System.out.println( numero.toString());	
			}
			System.out.println("------------------------------------------");
			if (startIndex > 0){
				System.out.println(listNumeri.get((startIndex+1000)%listNumeri.size()).toString());
				System.out.println(listNumeri.get((startIndex+2000)%listNumeri.size()).toString());
				System.out.println(listNumeri.get((startIndex+3000)%listNumeri.size()).toString());
			}	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}
	
	public static int calcolaScore(int value){
		int risultato = value;
		while (risultato > 10){
			risultato = risultato -10;
		}
		return risultato;
	}

}

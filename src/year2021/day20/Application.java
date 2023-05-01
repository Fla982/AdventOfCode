package year2021.day20;

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
	static int startPlayer1 = 9;
	static int startPlayer2 = 3;
	static final int limit = 10;
	static int totalScorePlayer1 = 0;
	static int totalScorePlayer2 = 0;
	static int totalTimesPlayer1 = 0;
	static int totalTimesPlayer2 = 0;
	
	
	public static void main(String[] args) {
		
		String path = "d:\\boat.txt";
		int die1 = 1;	
		int die2 = 2 ;
		int die3 = 3;
		boolean player1 = true;
		Integer list[] = new Integer[2000];
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
								
				
				System.out.println("Riga " + i + ": Value: " + line);
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			int z = 0;
			while (totalScorePlayer1 < 1000 && totalScorePlayer2 < 1000){
				if (player1 == true){
					player1 = false;
					
					startPlayer1 = calcolaScore(startPlayer1 + die1 + die2 + die3);
					
					totalScorePlayer1 = totalScorePlayer1 + startPlayer1;
					totalTimesPlayer1 = totalTimesPlayer1 + 3;
					System.out.println("Player 1 rolls " + die1 +"+" + die2 + "+" + die3 + " and moves to space " + startPlayer1 + " for a total score of " + totalScorePlayer1 + ".");
				}
				else{
					player1 = true;
					
					startPlayer2 = calcolaScore(startPlayer2 + die1 + die2 + die3);
					
					totalScorePlayer2 = totalScorePlayer2 + startPlayer2;
					totalTimesPlayer1 = totalTimesPlayer1 + 3;
					System.out.println("Player 2 rolls " + die1 +"+" + die2 + "+" + die3 + " and moves to space " + startPlayer2 + " for a total score of " + totalScorePlayer2 + ".");
				}
				//if ((die1+3)==100) die1 = 1; else die1 = die1 +3;
				//if ((die2+3)==101) die2 = 2; else die2 = die2 +3;
				//if ((die3+3)==102) die3 = 3; else die3 = die3 +3;
				die1 = die1 +3;
				die2 = die2 +3;
				die3 = die3 +3;
				z++;
			}
			
			
			if (totalScorePlayer2 > totalScorePlayer1){
				System.out.println("TOTALE INCREASED: " + totalScorePlayer1 * totalTimesPlayer1);
			}
			else {
				System.out.println("TOTALE INCREASED: " + totalScorePlayer2 * totalTimesPlayer1);
			}
			
			
			//System.out.println("TOTALE INCREASED: " + increased);	
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

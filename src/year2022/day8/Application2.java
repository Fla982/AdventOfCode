package year2022.day8;

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


	static final int TWO = 2;
	static final int FOUR = 4;
	static final int THREE= 3;
	static final int SEVEN = 7;

	public static void main(String[] args) {
		
		String path = "d:\\treehouse.txt";
		
		int[][] matrix = new int[99][99];
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			int somma = 392;
			int maxScore = 0;
			String line;
			
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				//String[] inizio = line.split(" | ");
				for (int l = 0; l <= line.length()-1; l++){
					
					matrix[i][l] = Integer.parseInt(String.valueOf(line.charAt(l)));
				}
				
				
				System.out.println("Riga " + i + ": value: " + line + " " );
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			for (int r = 1; r <= 99-2; r++){
				for (int c = 1; c <= 99-2; c++){
					
					int value = matrix[r][c];
					
					int visibleLeft = 0;
					int visibleRight = 0;
					int visibleTop = 0;
					int visibleBottom = 0;
					///LEFT
					for(int left = c-1; left >= 0; left--){
						int confrontoLeft = matrix[r][left];
						if (confrontoLeft>=value){
							visibleLeft++;
							break;
						}
						else visibleLeft++;
					}
					///RIGHT
					for(int right = c+1; right <= 98; right ++){
						int confrontoRight = matrix[r][right];
						if (confrontoRight >=value) {
							visibleRight++;
							break;
						}
						else visibleRight++;
					}
					///TOP
					for(int top = r-1; top >= 0; top--){
						int confrontoTop = matrix[top][c];
						if (confrontoTop >=value) {
							visibleTop++;
							break;
						}
						else visibleTop++;
					}
					///BOTTOM
					for (int bottom = r+1; bottom <= 98; bottom++){
						int confrontoBottom = matrix[bottom][c];
						if (confrontoBottom >=value) {
							visibleBottom++;
							break;
						}
						else visibleBottom++;
					}
					int score = visibleLeft * visibleRight * visibleTop * visibleBottom ;
					System.out.println("Valore: " + value + " Riga: " + r + " Colonna: " +c + " Score: " + score);
					if (score > maxScore )maxScore =  score;
				}
			}
			
			System.out.println("TOTALE SEGMENT: " + maxScore);			
			
			
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

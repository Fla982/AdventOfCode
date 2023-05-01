package year2022.day14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {

	final static int LEFT = -1;
	final static int RIGHT = 1;
	final static int UP = -1;
	final static int DOWN = 1;
	final static String MOVE_LEFT = "LEFT";
	final static String MOVE_RIGHT = "RIGHT";
	final static String MOVE_UP = "UP";
	final static String MOVE_DOWN = "DOWN";
	

	public static void main(String[] args) {
		
		String path = "d:\\rocks.txt";

		String cave[][] = new String[1000][1000];

		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			int move = 0;
			String moveName = "";
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				String coordinate [] = line.split(" -> ");
				for (int z = 0; z <= coordinate.length-2; z++){
					String start[] = coordinate[z].split(",");
					String end[] = coordinate[z+1].split(",");
					
					int cStart = Integer.parseInt(start[0]);
					int cEnd = Integer.parseInt(end[0]);
					int rStart = Integer.parseInt(start[1]);
					int rEnd = Integer.parseInt(end[1]);
					if (cStart < cEnd ){move = RIGHT; moveName=MOVE_RIGHT;}
					else if (cStart > cEnd) {move = LEFT;moveName=MOVE_LEFT;}
					else if (rStart < rEnd) {move = DOWN;moveName= MOVE_DOWN;}
					else if (rStart > rEnd) {move = UP;moveName= MOVE_UP;}
					else System.out.println("ERROR");
					
					if (moveName.equals(MOVE_LEFT) || moveName.equals(MOVE_RIGHT)){
						for(int j = cStart; cStart > cEnd ?  j-cEnd >= 0: cEnd-j >= 0 ; j = move+j){
							cave[rStart][j] = "#";
						}
					}
					if (moveName.equals(MOVE_UP) || moveName.equals(MOVE_DOWN)){
						for(int j = rStart; rStart > rEnd ? j-rEnd >= 0: rEnd-j >= 0; j = j+move){
							cave[j][cStart]="#";
						}
					}
				}
				
				System.out.println("Riga " + i + ": Value: " + line);
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
						
			System.out.println("TOTALE INCREASED: " + cave.toString());	
			/// AIR
			for (int r = 0; r <= 999; r++){
				for (int c = 0; c<= 999; c++){
					if ( cave[r][c] == null){
						cave[r][c] = ".";
					}
				}
			}
			for (int r = 0; r <= 999; r++){
				//System.out.println(Arrays.deepToString(cave[r])+"\n" );
				for (int c = 0; c<= 999; c++){
					
						//System.out.println(cave[r][c] );
					
				}
			}
			
			//SAND
			/*int o = 0;
			while(o <= 50000){
				boolean apposto = false;
				int r = 0;
				int c = 499;
				while (!apposto){
					if (cave[r][c].equals(".")) r++;
					else {
						int x = 0;
						int y = 0;
						while (!apposto || r+x > 999 || c+y < 0 ){
							if (cave[r+x][c+y].equals("."))
							{
								apposto = true;
								cave[r+x][c+y] = "o";
							}
							x++;
							y--;
						}
						x = 0;
						y = 0;
						while (!apposto || r+x > 999 || c+y > 999 ){
							if (cave[r+x][c+y].equals("."))
							{
								apposto = true;
								cave[r+x][c+y] = "o";
							}
							x++;
							y++;
						}
						if (cave[r-1][c].equals(".")){
							apposto = true;
							cave[r-1][c] = "o";
						}
					}
					
				}
					
				o++;
			}	*/
	        int lowestY = 999;

	        
	        int rStart = 0;
	        int cStart = 500;
	        
	        boolean bStart = rStart < lowestY;
            boolean bStart2 = cStart < lowestY;
	        int particleCount = 0;
	        do {
	            //if can move down, move down
	            if(cave[rStart+DOWN][cStart].contains("."))
	                 rStart = rStart+DOWN;
	            //if can move down and left, move down and left
	            else if(cave[rStart+DOWN][cStart+LEFT].contains("."))
	                {rStart = rStart + DOWN ; cStart = cStart +LEFT;}
	            //if can move down and right, move down and right
	            else if(cave[rStart+DOWN][cStart+RIGHT].contains("."))
	            	{rStart = rStart + DOWN ; cStart = cStart +RIGHT;}
	            else {
	                //at rest - add to solids for collision
	                cave[rStart][cStart] = "o";
	                rStart = 0;
	                cStart = 500;
	                particleCount++;
	            }
	            bStart = rStart < lowestY;
	            bStart2 = cStart < lowestY;
	            System.out.println("Particelle" + particleCount);
	        } while (bStart == true);
	        //if sand position went below (above) lowest Y, then will never rest - so break and return number of grains so far
		
			//System.out.println("Cave with sand : " + cave);
			for (int r = 0; r <= 999; r++){
				System.out.println(Arrays.deepToString(cave[r])+"\n" );
				for (int c = 0; c<= 999; c++){
					
						//System.out.println(cave[r][c] );
					
				}
			}
			
		}
		
		catch(Exception e) {
		
			e.getStackTrace();
			
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

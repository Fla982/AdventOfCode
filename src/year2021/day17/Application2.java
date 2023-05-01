package year2021.day17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import year2021.day11.*;


public class Application2 {

	static String finito = "";
	static final int step = 100;
	static Map<Cella,String> target = new LinkedHashMap<Cella,String>();
	static int maxRow = 0;	
	static int maxColumn = 10;

	public static void main(String[] args) {
		
		String path = "d:\\flash.txt";
		
		int totale = 0;
		//Map<Cella,Flash> lights = new HashMap<Cella,Flash>();
		

		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				System.out.println("Fila " + i + ": " + line+ "");
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			for(int x = 241; x < 274; x++){//colonna
				for(int y = -97; y <= -63; y++){//riga
					Cella key = new Cella(x,y);
					target.put(key, "T");
					
				}
			}
			/*for(int x = 20; x < 31; x++){//colonna
				for(int y = -10; y < -4; y++){//riga
					Cella key = new Cella(x,y);
					target.put(key, "T");
					
				}
			}*/
			Map<Cella,String> shoot = new HashMap<Cella,String>();
			int increaseC = 0;
			int increaseR = 0;
			int maxHeightShoot = 0;
			int maxHeightTotal = 0;
			for(int c = -5000; c < 5000; c++){//x
				for(int r = -5000; r < 5000; r++){//y
					increaseR = r;
					increaseC = c;
					maxHeightShoot = 0;
					int j = 1;
					int g = 1;
					/*Cella cella = new Cella(increaseR,increaseC);
					if (target.get(cella).equals("T")){
						System.out.println("Target ok");
						if (maxHeightShoot > maxHeightTotal) maxHeightTotal = maxHeightShoot;
					}*/
					//if (c == 0 && r == 2)
						//System.out.println("sono qui.");
					while(increaseR> -500){
						Cella cella = new Cella(increaseC,increaseR);
						if (target.get(cella) != null){
							if (target.get(cella).equals("T")){
								//System.out.println("Target ok");
								//System.out.println("X: " + c + " Y: " + r);
								System.out.println( c + "," + r);
								if (maxHeightShoot > maxHeightTotal){
									maxHeightTotal = maxHeightShoot;
									//System.out.println("X: " + c + " Y: " + r);
								}
							}
						}
						if (increaseR > maxHeightShoot) maxHeightShoot = increaseR;
						if (c != 0){
							if ((c-g)< 0){
								increaseC = increaseC + (c+g);
								increaseR = increaseR + (r-j);
								g++;
							}
							else if ((c-g) == 0){
								increaseR = increaseR + (r -j);
								
							}
							else if ((c-g) > 0){
								increaseC = increaseC + (c-g);
								increaseR = increaseR + (r-j);
								g++;
							}
						}
						else{
							increaseR = increaseR + (r-j);
						}
						j++;
					}
				}
			}
			
					
			System.out.println("MASSIMA ALTEZZA: " + maxHeightTotal);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}
	
}

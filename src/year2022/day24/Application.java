package year2022.day24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Application {

	static String finito = "";
	static int maxX=122, maxY=27;
	static final int UP= -1;
	static final int DOWN= 1;
	static final int RIGHT= 1;
	static final int LEFT= -1;
	static int startX, startY, endX, endY;
	static List<String> blizzard[][] = new ArrayList[122][27];
	static List<String> oldBlizzard[][] = new ArrayList[122][27];
	public static void main(String[] args) {
		
		String path = "d:\\24.txt";
		
		List<String> details[][] = new ArrayList[122][27];
		
		
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
								
				
				System.out.println("Riga " + i + ": Value: " + line);
				for(int x = 0; x < line.length(); x++) {
					List<String> detail = new ArrayList<>();
					detail.add(String.valueOf(line.charAt(x)));
					if (i == 0 && String.valueOf(line.charAt(x)).equals(".")) {startX = x; startY = 0;};
					if (i == 26 && String.valueOf(line.charAt(x)).equals(".")) {endX = x; endY = maxY;};
					details[x][i] = detail;
	                /*switch (line.charAt(x)) {
	                    case '#' -> bounds.add(new Coord(x, y));
	                    case '>' -> blizzards.add(new Blizzard(new Coord(x, y), Coord.RIGHT));
	                    case '<' -> blizzards.add(new Blizzard(new Coord(x, y), Coord.LEFT));
	                    case 'v' -> blizzards.add(new Blizzard(new Coord(x, y), Coord.DOWN));
	                    case '^' -> blizzards.add(new Blizzard(new Coord(x, y), Coord.UP));
	                }*/
	            }
				
				i++;
				
			}
			
			Coord end = new Coord(endX,endY);
			System.out.println("End: " + end.toString());
			int minuto = 0;
			HashSet<Coord> curReachable = new HashSet<>();
	        curReachable.add(new Coord(startX,startY));
	        oldBlizzard = details;
			for (int m= 0; m <= 50000; m++){
				minuto++;
				System.out.println("Minuto: " + minuto);
				HashSet<Coord> newReachable = new HashSet<>();
				blizzard = updateBlizzard(oldBlizzard);
				System.out.println("Blizzard updated");
				for(Coord c : curReachable) {
	                for(Coord adj : c.directNeighbors())
	                    if(!adj.equals("."))
	                        newReachable.add(adj);
	                if(!c.equals("."))
	                    newReachable.add(c);
	            }
	            curReachable = newReachable;
	            System.out.println("Current reachable: " + curReachable.toString());
				oldBlizzard = blizzard;
				if (curReachable.contains(end)) break;
			}
			
			
			
			System.out.println("TOTALE INCREASED: " + minuto);	
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

	
	public static List<String>[][] updateBlizzard(List<String>[][] value){
		for(int x = 0; x <= maxX; x++){
			for (int y = 0; y<= maxY;y++){
				List<String> details = value[x][y];
				List<String> newDetails = new ArrayList<>();
				String newDetail = ".";
				for(String detail: details){
					
				
					
                    if (detail.equals("#")) updateBlizzardDetails(x,y,detail, new ArrayList<String>());
                    else if (detail.equals(">")) updateBlizzardDetails(x+RIGHT,y,detail, new ArrayList<String>());
                    else if (detail.equals("<")) updateBlizzardDetails(x+LEFT,y,detail, new ArrayList<String>());
                    else if (detail.equals("v")) updateBlizzardDetails(x,y+DOWN,detail, new ArrayList<String>());
                    else if (detail.equals("^")) updateBlizzardDetails(x,y+UP,detail, new ArrayList<String>());
					
					
				}
				if (blizzard[x][y]==null) {newDetails = new ArrayList<>();newDetails.add(newDetail);blizzard[x][y]=newDetails;}
			}
		}
		return blizzard;
	}
	
	
	public static void updateBlizzardDetails(int x, int y, String value, List<String> list){
		list.add(value);
	
		switch (value) {
        case "#" : { 
        	
        	if (blizzard[x][y] == null)
        		blizzard[x][y]= list;
        	
        }
        case ">" : {
        	if (x > maxX -1) x = 1;
        	if (blizzard[x][y] == null)
        		blizzard[x][y]= list;
        	else{
        		List<String> details =blizzard[x][y];
        		if (!details.isEmpty())
        			details.remove(".");
        		details.add(value);
        		blizzard[x][y] = details;
        	}
        }
        case "<" :{
        	if (x < 1) x = maxX-2;
        	if (blizzard[x][y] == null)
        		blizzard[x][y]= list;
        	else{
        		List<String> details =blizzard[x][y];
        		if (!details.isEmpty())
        			details.remove(".");
        		details.add(value);
        		blizzard[x][y] = details;
        	}
        }
        case "v" :{
        	if (y > maxY -1) x = 1;
        	if (blizzard[x][y] == null)
        		blizzard[x][y]= list;
        	else{
        		List<String> details =blizzard[x][y];
        		if (!details.isEmpty())
        			details.remove(".");
        		details.add(value);
        		blizzard[x][y] = details;
        	}
        }
        case "^" :{
        	if (y < 1) x = maxY-2;
        	if (blizzard[x][y] == null)
        		blizzard[x][y]= list;
        	else{
        		List<String> details =blizzard[x][y];
        		if (!details.isEmpty())
        			details.remove(".");
        		details.add(value);
        		blizzard[x][y] = details;
        	}
        }
	}
}
}

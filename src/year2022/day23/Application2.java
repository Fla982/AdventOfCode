package year2022.day23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application2 {


	static String input;

    final static Coord[] DIAGONALS = new Coord[] {new Coord(-1,-1), new Coord(1,-1), new Coord(-1,1), new Coord(1,1)};

	
	public static void main(String[] args) {
		
		String path = "d:\\23.txt";


		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			LinkedList<Coord> dirs = new LinkedList<>(Arrays.asList(Coord.UP, Coord.DOWN, Coord.LEFT, Coord.RIGHT));
	        HashSet<Coord> elves = new HashSet<>();
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				for(int x = 0; x < line.length(); x++) {
	                if(line.charAt(x) == '#')
	                    elves.add(new Coord(x,i));
	            }				
				
				System.out.println("Riga " + i + ": Value: " + line);
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			for(int iter = 0; iter < 10; iter++) {
	            //first half
	            HashMap<Coord,Coord> proposals = new HashMap<>();
	            for(Coord elf : elves) {
	                //get list of adjacent positions, keep ones that contain elves
	                ArrayList<Coord> adj = elf.allNeighbors();
	                adj.retainAll(elves);
	                //if no elves nearby, no movement
	                if(adj.size() == 0)
	                    continue;
	                //try proposing each direction in order
	                for(Coord c : dirs) {
	                    ArrayList<Coord> checks = new ArrayList<>();
	                    checks.add(elf.sum(c));
	                    checks.addAll(diags(c).stream().map(elf::sum).collect(Collectors.toList()));
	                    checks.retainAll(adj);
	                    if(checks.size() == 0) {
	                        proposals.put(elf,elf.sum(c));
	                        break;
	                    }
	                }
	            }
	            //second half
	            HashSet<Coord> newElves = new HashSet<>();
	            //get frequency map of proposed locations
	            HashMap<Coord,Long> propFreq = new HashMap<>(proposals.values().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
	            for(Coord elf : elves) {
	                //if elf has no proposed location or if its proposed location has a value of more than one in the frequency map, do not move
	                if(propFreq.getOrDefault(proposals.getOrDefault(elf,null),2L) > 1L)
	                    newElves.add(elf);
	                else
	                    newElves.add(proposals.get(elf));
	            }
	            elves = newElves;
	            dirs.add(dirs.removeFirst());
	        }

	        int minX = elves.stream().map(x -> x.x).min(Integer::compare).get();
	        int maxX = elves.stream().map(x -> x.x).max(Integer::compare).get();
	        int minY = elves.stream().map(x -> x.y).min(Integer::compare).get();
	        int maxY = elves.stream().map(x -> x.y).max(Integer::compare).get();

			System.out.println("TOTALE INCREASED: " + Integer.toString(((maxX - minX + 1) * (maxY - minY + 1)) - elves.size()));	
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
	
	public static ArrayList<Coord> diags(Coord c) {
        ArrayList<Coord> ret = new ArrayList<>();
        if(c.equals(Coord.UP)) {
            ret.add(DIAGONALS[0]);
            ret.add(DIAGONALS[1]);
            return ret;
        }
        if(c.equals(Coord.DOWN)) {
            ret.add(DIAGONALS[2]);
            ret.add(DIAGONALS[3]);
            return ret;
        }
        if(c.equals(Coord.LEFT)) {
            ret.add(DIAGONALS[0]);
            ret.add(DIAGONALS[2]);
            return ret;
        }
        if(c.equals(Coord.RIGHT)) {
            ret.add(DIAGONALS[1]);
            ret.add(DIAGONALS[3]);
            return ret;
        }
        return null;
    }

}

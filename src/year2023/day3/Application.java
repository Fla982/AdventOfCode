package year2023.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

	

	public static void main(String[] args) {
		
		String path = "d:\\gondola.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			int somma = 0;
			//int i = 0;
			int r = 0;
			String line;
			String[] lines = new String[140];
			// read airplane seats
			while ((line = br.readLine()) != null) {
				lines[r] = line;
				System.out.println(line);
				r++;
			}
			int total = 0;
			
	        char[][] grid = new char[lines.length][lines[0].length()];
	        for(int i = 0; i < lines.length; i++) {
	            for(int j = 0; j < lines[0].length(); j++) {
	                grid[i][j] = lines[i].charAt(j);
	            }
	        }
	        ArrayList<Coord> validIndices = new ArrayList<>();
	        for(int i = 0; i < lines.length; i++) {
	            for(int j = 0; j < lines.length; j++) {
	                if(Character.isDigit(grid[i][j])) {
	                    ArrayList<Coord> nums = new ArrayList<>();
	                    while(j < grid[0].length && Character.isDigit(grid[i][j])) {
	                        nums.add(new Coord(i,j));
	                        j++;
	                    }

	                    outer:
	                    for(Coord c : nums) {
	                        for(Coord d : c.allNeighbors()) {
	                            if(d.x < 0 || d.y < 0 || d.x  >= grid.length || d.y >= grid[0].length)
	                                continue;
	                            if(!Character.isDigit(grid[d.x][d.y]) && grid[d.x][d.y] != '.') {
	                                validIndices.add(nums.get(0));
	                                break outer;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        for(Coord c : validIndices) {
	            int j = c.y;
	            while(j < grid[0].length && Character.isDigit(grid[c.x][j])) {
	                j++;
	            }
	            total += Integer.parseInt(lines[c.x].substring(c.y, j));
	        }
	        System.out.println(Integer.toString(total));
			
			System.out.println("MAX SOMMA: " + somma);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

package year2023.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application2 {

	

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
			char[][] grid = new char[lines.length][lines[0].length()];
	        for(int i = 0; i < lines.length; i++) {
	            for(int j = 0; j < lines[0].length(); j++) {
	                grid[i][j] = lines[i].charAt(j);
	            }
	        }

	        long tot = 0;
	        for(int i = 0; i < grid.length; i++) {
	            for(int  j = 0; j < grid[0].length; j++) {
	                if(grid[i][j] != '*') {
	                    continue;
	                }

	                Coord gear = new Coord(i,j);
	                ArrayList<Coord> nums = new ArrayList<>();
	                for(Coord c : gear.allNeighbors()) {
	                    if(Character.isDigit(grid[c.x][c.y])) {
	                        nums.add(c);
	                    }
	                }
	                long mult = 1;
	                HashSet<Coord> skip = new HashSet<>();
	                for(Coord c : nums) {
	                    if(skip.contains(c))
	                        continue;
	                    int left = c.y;
	                    int right = c.y;
	                    while(left-1 >= 0 && Character.isDigit(grid[c.x][left-1])) {
	                        left--;
	                    }
	                    while(right+1 < grid[0].length && Character.isDigit(grid[c.x][right+1])) {
	                        right++;
	                    }
	                    String num = "";
	                    for(int y = left; y <= right; y++) {
	                        if(!c.equals(new Coord(c.x,y)) && nums.contains(new Coord(c.x,y)))
	                            skip.add(new Coord(c.x,y));
	                        num += grid[c.x][y];
	                    }
	                    mult *= Long.parseLong(num);
	                }
	                System.out.println(nums + " " + skip);
	                if(nums.size() - skip.size() == 2) {
	                    tot += mult;
	                }
	            }
	        }
	        System.out.println(Long.toString(tot));
			
			System.out.println("MAX SOMMA: " + somma);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

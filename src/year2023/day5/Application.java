package year2023.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

	

	public static void main(String[] args) {
		
		String path = "d:\\seeds.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			int somma = 0;
			int r = 0;
			String line; 
			String input = "";
			String[] maps = new String[8];
			// read airplane seats
			while ((line = br.readLine()) != null) {
				if (line.length() == 0)
				{
					maps[r] = input;
					r++;
					input = "";
				}
				else
				{
					if (input.isEmpty())
						input += line;
					else
						input = input + ";" + line;	
				}
				
				
				
			}
			maps[r] = input;
			//String[] maps = input.split("\n\n");
	        ArrayList<Long> vals = new ArrayList<>();
	        String[] seeds = maps[0].split(" ");
	        for(int i = 1; i < seeds.length; i++)
	            vals.add(Long.parseLong(seeds[i]));
	        for(int i = 1; i < maps.length; i++) {
	            ArrayList<Long> newVals = new ArrayList<>();
	            for(long l : vals)
	                newVals.add(map(l, maps[i].split(";")));
	            vals = newVals;
	        }
	        System.out.println(Long.toString(Collections.min(vals)));
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

	public static long map(long start, String[] map) {
        long end = start;
        for(int m = 1; m < map.length; m++) {
            String[] nums = map[m].split(" ");
            long srcStart = Long.parseLong(nums[1]);
            long destStart = Long.parseLong(nums[0]);
            long range = Long.parseLong(nums[2]);
            long diff = destStart - srcStart;

            if(start >= srcStart && start < srcStart + range) {
                end = start + diff;
                break;
            }
        }
        return end;
    }
}

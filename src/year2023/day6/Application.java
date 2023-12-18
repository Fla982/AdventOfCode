package year2023.day6;

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
		
		String path = "d:\\boats.txt";
		
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

					if (input.isEmpty())
						input += line;
					else
						input = input + ";" + line;	
				
				
				
				
			}
			long mult = 1;
	        String[] time = input.split(";")[0].split("\\s+");
	        String[] distance = input.split(";")[1].split("\\s+");
	        for(int i = 1; i < time.length; i++) {
	            int count = 0;
	            int t = Integer.parseInt(time[i]);
	            int d = Integer.parseInt(distance[i]);
	            for(int hold = 0; hold < t; hold++) {
	                if(t*hold-hold*hold>d) {
	                    count++;
	                }
	            }
	            mult *= count;
	        }
	        System.out.println(Long.toString(mult));
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

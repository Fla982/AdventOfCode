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

public class Application2 {

	

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
	        String fullTime = "";
	        String fullDist = "";
	        for(int i = 1; i < time.length; i++) {
	            fullTime += time[i];
	            fullDist += distance[i];
	        }

	        long t = Long.parseLong(fullTime);
	        long d = Long.parseLong(fullDist);

	        long firstZero = (long) Math.ceil((t - Math.sqrt(t*t-4*d))/2);
	        long secondZero = (long) Math.floor((t + Math.sqrt(t*t-4*d))/2);

	        System.out.println(firstZero + " " + secondZero + " " + (secondZero - firstZero));
	        System.out.println(Long.toString(secondZero-firstZero+1));
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

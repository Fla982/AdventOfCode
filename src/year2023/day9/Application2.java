package year2023.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application2 {

	
/*
 * PART 1
 */
	public static void main(String[] args) {
		
		String path = "d:\\oasis.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			int somma = 0;
			long total = 0;
			int r = 0;
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				ArrayList<ArrayList<Integer>> tower = new ArrayList<>();
	            ArrayList<Integer> start = new ArrayList<>();
	            for(String t : line.split(" "))
	                start.add(Integer.parseInt(t));
	            tower.add(start);
	            boolean cont = true;
	            int level = 0;
	            while(cont) {
	                cont = false;
	                ArrayList<Integer> prev = tower.get(level);
	                ArrayList<Integer> cur = new ArrayList<>();
	                for(int i = 0; i < prev.size() - 1; i++) {
	                    int res = prev.get(i+1)-prev.get(i);
	                    if(res != 0)
	                        cont = true;
	                    cur.add(res);
	                }
	                tower.add(cur);
	                level++;
	            }
	            long sum = 0;
	            for(ArrayList<Integer> l : tower)
	                sum += l.get(l.size() - 1);
	            total += sum;
				System.out.println("Riga " + r + ": Value: " + line);
				
				r++;
			}
			

	        
	        System.out.println(Long.toString(total));
			System.out.println("MAX SOMMA: " + somma);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

package year2023.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application2 {

	

	public static void main(String[] args) {
		
		String path = "d:\\leftright.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			int somma = 0;
			int r = 0;
			String[] halves = new String[2];
			halves[0] = "LRRLLRLLRRRLRRLRLRRRLRLLRLRRLRRRLRRRLRRLRRRLRLRRRLRLRRLRLRRRLRRLLRRLLLRRLRLRRRLRLRRRLRRLRRRLRLLRRLRRLRLRRRLRRRLRRLRRLLRLLRRRLRLRRLRRRLRRLRRRLRRRLLLLRRLRLRRRLRRRLLRRLLRRLRRRLRRRLRLRLLRRLRLRLRLRLRRLRLRLRRRLRRLRRLRRLRRRLRLRRRLRLRRLRLLLLRRRLLRRRLRLLRRRLRLLRRRLLRRLRLRLRLRLLLLRRLRRRLRLLRRLRRRLRRRLRLRRLRRLRLLRRRR";
			String line; 
			HashMap<String, BTreeNode> nodes = new HashMap<>();
	        ArrayList<BTreeNode> starts = new ArrayList<>();
			// read airplane seats
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" = ");
	            BTreeNode root = nodes.getOrDefault(parts[0], new BTreeNode(parts[0]));
	            String[] leaves = parts[1].split(", ");
	            leaves[0] = leaves[0].substring(1);
	            leaves[1] = leaves[1].substring(0, leaves[1].length() - 1);
	            BTreeNode left = nodes.getOrDefault(leaves[0], new BTreeNode(leaves[0]));
	            root.left = left;
	            nodes.put(leaves[0],left);
	            BTreeNode right = nodes.getOrDefault(leaves[1], new BTreeNode(leaves[1]));
	            root.right = right;
	            nodes.put(leaves[1],right);
	            nodes.put(parts[0],root);
	            if(parts[0].charAt(2) == 'A') {
	                starts.add(root);
	            }
				
				System.out.println("Riga " + r + ": Value: " + line);
				
				r++;
			}
			

	        ArrayList<Integer> mults = new ArrayList<>();
	        for(BTreeNode start : starts) {
	            String instr = halves[0];
	            int index = 0;
	            int steps = 0;
	            BTreeNode cur = start;
	            while(!(cur.name.charAt(2)=='Z')) {
	                if(instr.charAt(index) == 'L') {
	                    cur = cur.left;
	                } else {
	                    cur = cur.right;
	                }
	                index++;
	                steps++;
	                if(index == instr.length())
	                    index = 0;
	            }
	            mults.add(steps);
	        }

	        long lcm = mults.get(0);
	        for(int i = 1; i < mults.size(); i++) {
	            lcm = (lcm * mults.get(i))/gcd(lcm, mults.get(i));
	        }
	        System.out.println( Long.toString(lcm));
			
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

	static long gcd(long a, long b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
}

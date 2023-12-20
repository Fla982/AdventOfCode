package year2023.day7;

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
		
		String path = "d:\\poker.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			int somma = 0;
			int r = 0;
			String line; 
			ArrayList<Hand> hands = new ArrayList<>();
			// read airplane seats
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				Hand hand = new Hand(parts[0],Integer.parseInt(parts[1]),true);
				hands.add(hand);
				
				System.out.println("Riga " + r + ": Value: " + line + " Type: " + hand.type);
				
				r++;
			}
			

	        Collections.sort(hands);
	        /*Collections.sort(hands, new Comparator<Hand>() {
	        	@Override
	            public int compare(Hand left, Hand right) {
	            	if(left.type != right.type) {
	                	return Integer.compare(left.type , right.type);
	                    //return o.type - this.type;
	                }
	                for(int i = 0; i < 5; i++) {
	                    if(right.hand.charAt(i)==left.hand.charAt(i))
	                        continue;
	                    System.out.println("h: " + right.hand + " h2: " + left.hand + " type: " + left.type + " " + right.type);
	                    //System.out.println(Integer.compare((part2 ? order2: order).indexOf(o.hand.charAt(i)) ,(part2 ? order2 : order).indexOf(this.hand.charAt(i))));
	                    return Integer.compare((left.order).indexOf(right.hand.charAt(i)) ,(left.order).indexOf(left.hand.charAt(i)));
	                    //return (part2 ? order2: order).indexOf(o.hand.charAt(i)) - (part2 ? order2 : order).indexOf(this.hand.charAt(i));
	                }
	                return 0;
	            }
	        });*/
	        int tot = 0;
	        for(int i = 0; i < hands.size(); i++) {
	        	System.out.println("hand: " + i + " " + hands.get(i).bid);	
	            tot += (i+1)*hands.get(i).bid;
	        }
	        System.out.println( Integer.toString(tot));
			
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

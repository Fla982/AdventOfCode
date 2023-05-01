package year2022.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {


	static int gamma = 0;
	static  int epsilon = 0;

	public static void main(String[] args) {
		
		String path = "d:\\stacks2.txt";
		int move = 0;	
		int from = 0 ;
		int to = 0;
		String result = "";
		Stack stacks = new Stack();
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line;
			String[] binary = new String[1000];
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				String strMove = line.replaceAll("move ", "").split(" ")[0];
				String strFrom = line.split("from ")[1].substring(0, 1);
				String strTo = line.split("to ")[1].substring(0, 1);
				System.out.println("Move: " +strMove + ", From: " + strMove + ", To: " +strTo);
				move = Integer.valueOf(strMove);
				from = Integer.valueOf(strFrom);
				to = Integer.valueOf(strTo);
				for (int m = 1; m <= move; m++){
					System.out.println("M: " + m + ", Move: " + move);
					List listFrom = stacks.stacks.get(strFrom);
					String s = listFrom.get(listFrom.size()-1).toString();
					List listTo = stacks.stacks.get(strTo);
					listTo.add(s);
					listFrom.remove(listFrom.size()-1);
					stacks.stacks.put(strFrom, listFrom);
					stacks.stacks.put(strTo, listTo);
					System.out.println("Stack " + strFrom + " - " + stacks.stacks.get(strFrom));
					System.out.println("Stack " + strTo + " - " + stacks.stacks.get(strTo));
				}
				
				System.out.println("Riga " + i + ": value: " + line + " " );
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			for (int r = 1; r <= 9; r++){
				List list = stacks.stacks.get(String.valueOf(r));
				result = result + list.get(list.size()-1);
			}
			System.out.println("TOTALE : " + result); 
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

package year2023.day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Application2 {

	

	public static void main(String[] args) {
		
		String path = "d:\\ascii.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			long somma = 0;
			int i = 0;
			String line; 
			List<Map<String,Integer>> hasmap = new ArrayList<>();
			List<List<Map<String,Integer>>> boxes = new ArrayList<List<Map<String,Integer>>>(256);
			for (int z = 0; z < 256; z++){
				boxes.add(hasmap);
			}
			//boxes.stream().forEach(list -> list= hasmap);
			boolean val = boxes.get(0) == null ? true: false;
			// read airplane seats
			while ((line = br.readLine()) != null) {
				String[] array = line.split(",");
				for (int h = 0; h < array.length; h++){
					String valore = array[h];
					// ciclo ogni valore e lo posiziono nei box
					if (valore.indexOf("-")>= 0){
						// se è - tolgo
						String ascii = valore.split("-")[0];
						int box = ascii(ascii);
						List slots = boxes.get(box);
						if (!slots.isEmpty()){
							for (int c = 0; c < slots.size(); c++){
								Map<String, Integer> focal = (Map<String, Integer>) slots.get(c);
								if (focal.get(ascii) != null){
									slots.remove(c);
									boxes.set(box,slots);
									break;
								}
								
							}
						}
					}
					if (valore.indexOf("=")>= 0){
						// se è = posiziono
						String ascii = valore.split("=")[0];
						int length = Integer.valueOf(valore.split("=")[1]);
						int box = ascii(ascii);
						List slots = boxes.get(box);
						if (slots.isEmpty()){
							List newSlot = new ArrayList<>();
							Map<String, Integer> newFocal = new TreeMap<>();
							newFocal.put(ascii, length);
							newSlot.add(newFocal);
							boxes.set(box, newSlot);
						}
						else{
							boolean trovato = false;
							for (int c = 0; c < slots.size(); c++){
								Map<String, Integer> focal = (Map<String, Integer>) slots.get(c);
								if (focal.get(ascii) != null){
									focal.put(ascii, length);
									boxes.set(box,slots);
									trovato = true;
									break;
								}
								
							}
							if (trovato == false){
								Map<String, Integer> focal = new TreeMap<>();
								focal.put(ascii, length);
								slots.add(focal);
								boxes.set(box, slots);
							}
						}
					}
					
					//System.out.println(h + " current : " + current);
					
				}
				
				for (int b = 0; b < boxes.size(); b++){
					List slots = boxes.get(b);
					for(int s = 0; s < slots.size(); s++){
						Map<String, Integer> focal = (Map<String, Integer>) slots.get(s);
						int f = 0;
						for(Integer length: focal.values()){
							f = length;
						}
						somma += ((b+1) * (s+1) * (f));
						System.out.println("Box " + b + ": Slot: " + s+ ": Focal: " + f);		
					}
				}
				
				
				
			}
			
			
			System.out.println("MAX SOMMA: " + somma);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}
	
	static public int ascii(String value){
		int current = 0;
		for(int d = 0; d < value.length(); d++){
			char c = value.charAt(d);
			try
			{
				current = current +(int) c;
				current = current *17;
				current = current % 256;
				
				
					
			}
			catch (Exception e)
			{
				System.out.println(c + " non è u numero");
			}
		}
		return current;
		
	}

}

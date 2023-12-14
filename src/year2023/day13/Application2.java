package year2023.day13;

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
		
		String path = "d:\\mirror.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			int somma = 0;
			int i = 0;
			int numMirrors = 1;
			String line;
			Map<String, List<String>> mirrors = new TreeMap<>();
			List<String> mirror = new ArrayList<>();
			// read the mirror
			while ((line = br.readLine()) != null) {
				if (line.isEmpty()){	
					mirrors.put(String.valueOf(numMirrors), mirror);
					numMirrors++;
					mirror = new ArrayList<>();
					System.out.println(numMirrors);
				}
				else
					mirror.add(line);
				
				
				System.out.println(line);
				
				i++;
			}
			mirrors.put(String.valueOf(numMirrors), mirror);
			// cerco le righe orizzontali
			for (String key: mirrors.keySet()){
				
				List<String> specchio = mirrors.get(key);
				
				int horizontal = 0;
				pat:
				for (int o = 0; o < specchio.size()-1; o++){
					int left = o;
	                int right = o+1;
	                boolean smudge = false;
	                while(!smudge || specchio.get(left).equals(specchio.get(right))) {
	                	if (specchio.get(left).equals(specchio.get(right))) {
	                		left--;
		                    right++;
		                    if(left == -1 || right == specchio.size()) {
		                    	// contrlle se smudge è vero
		                    	if (smudge){
		                    		//midpoint discovered! line lies between midpoint and midpoint-1
			                        somma += (o+1)*100;
			                        continue pat;
		                    	}
		                    	else
		                    	{
		                    		break;	
		                    	}
		                        
		                    }	
	                	}
	                	else {
	                		if(oneDiff(specchio.get(left),specchio.get(right))) {
	                            smudge = true;
	                            left--;
	                            right++;
	                            if(left == -1 || right == specchio.size()) {
	                            	somma += (o+1)*100;
	                                continue pat;
	                            }
	                        } else {
	                            break;
	                        }
	                		
	                	}
	                    
	                }
					/*if (specchio.get(o).equals(specchio.get(o+1))){
						horizontal = o;
						somma = somma + ((horizontal +1)*100);
						System.out.println( key + ", Orizzontale: " + horizontal);
					}*/
				}
			}
			// cerco le righe verticali
			for (String key: mirrors.keySet()){
				// prendo la lista di orizzontali
				List<String> specchio = mirrors.get(key);
				//for (int h = 0; h <= specchio.size(); h++){
					String linea = specchio.get(0); /// sempre dalla prima riga prendo la lunghezza
					List<String> mirrorVerticale = new ArrayList<>();
					int vertical = 0;
					// per ogni carattere della stringa immagazzino elemento nella stringa
					// che compone la lista di elementi verticale
					for (int d = 0; d < linea.length(); d++){
						String lineaVerticale = "";
						for (int v = 0; v < specchio.size(); v++){
							String verticale = specchio.get(v);
							char c = verticale.charAt(d);
							lineaVerticale = lineaVerticale + String.valueOf(c);
						}
						// aggiungo la stringa verticale alla lista
						mirrorVerticale.add(lineaVerticale);
						
					}
					//if (key.equals("4"))
						//System.out.println("qui");
					pat1:
					for (int a = 0; a < mirrorVerticale.size()-1; a++){
						int left = a;
		                int right = a+1;
		                boolean smudge = false;
		                while(!smudge || mirrorVerticale.get(left).equals(mirrorVerticale.get(right))) {
		                	if (mirrorVerticale.get(left).equals(mirrorVerticale.get(right))) {
		                		left--;
			                    right++;
			                    if(left == -1 || right == mirrorVerticale.size()) {
			                    	// contrlle se smudge è vero
			                    	if (smudge){
			                    		//midpoint discovered! line lies between midpoint and midpoint-1
				                        somma += (a+1);
				                        continue pat1;	
			                    	}
			                    	else {
			                    		break;	
			                    	}
			                        
			                    }	
		                	}
		                	else {
		                		if(oneDiff(mirrorVerticale.get(left),mirrorVerticale.get(right))) {
		                            smudge = true;
		                            left--;
		                            right++;
		                            if(left == -1 || right == mirrorVerticale.size()) {
		                            	somma += (a+1);
		                                continue pat1;
		                            }
		                        } else {
		                            break;
		                        }
		                	}
		                    
		                }
						/*if (mirrorVerticale.get(a).equals(mirrorVerticale.get(a+1))){
							vertical = a;
							somma = somma + (vertical +1 );
							System.out.println(key + ", Verticale: " + vertical);
						}*/
					}
				//}
			}
			
			
			
			System.out.println("MAX SOMMA: " + somma);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}
	
	public static boolean oneDiff(String a, String b) {
        boolean diff = false;
        for(int i = 0; i < a.length(); i++){
        	if(a.charAt(i) != b.charAt(i))
                if(!diff)
                    diff = true;
                else
                    return false;
        }
            
        return diff;
    }

}

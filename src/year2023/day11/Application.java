package year2023.day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Application {

	

	public static void main(String[] args) {
		
		String path = "d:\\eges3.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			int somma = 0;
			int o = 0;
			int i = 0;
			int numero = 1;
			String line; 
			int [] colonne = {4,47,53,59,70,87,111};
			int [] righe = {9,22,46,58,65,77,134};
			Map<Integer,Map<Integer, Integer>> galaxies = new TreeMap<>();
			List<String> rows = new ArrayList<>();
			// read leggo le righe e raddoppio le righe
			while ((line = br.readLine()) != null) {
				/*String delmiatata = "";
				for(int d = 0; d < line.length(); d++){
					delmiatata = delmiatata + "," + line.charAt(d);
				}
				System.out.println(delmiatata);*/
				if (line.equals("...................................................................................................................................................")){
					rows.add(line);
					rows.add(line);
					System.out.println("trogata: " + o);
				}
				else
					rows.add(line);
				o++;
			}
			for (int z = 0; z < rows.size(); z++) {
				String linea = rows.get(z);
				for(int d = 0; d < linea.length(); d++){
					
					char c = linea.charAt(d);
					try
					{
						if (String.valueOf(c).equals("#"))
						{
							Map<Integer, Integer> coordinates = new HashMap<>();
							coordinates.put(d, i);
							galaxies.put(numero, coordinates);
							numero++;
						}

						
							
					}
					catch (Exception e)
					{
						System.out.println(c + " non è u numero");
					}
				}

				System.out.println("Riga " + i + " " );
				i++;
				
			}
			/// per ogni numero trovo il percorso con un altra cordinata
			for (int g = 1; g <= numero-1; g++){
				Map<Integer, Integer> galaxy1 = galaxies.get(g);
				for (int h = g+1; h<= numero-1; h++){
					Map<Integer, Integer> galaxy2 = galaxies.get(h);
					Map.Entry<Integer,Integer> entry = galaxy1.entrySet().iterator().next();
					int x1 = entry.getKey();
					int y1 = entry.getValue();
					Map.Entry<Integer,Integer> entry2 = galaxy2.entrySet().iterator().next();
					int x2 = entry2.getKey();
					int y2 = entry2.getValue();
					int distanza = Math.abs(x2-x1)+Math.abs(y2-y1);
					System.out.println(g + " nodo:  "+ galaxy1.toString() + " " + h + " nodo: " + galaxy2.toString() + " Distanza: " + distanza);
					somma = somma +Math.abs(distanza);
				}
				
			}
			
			System.out.println("MAX SOMMA: " + somma);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

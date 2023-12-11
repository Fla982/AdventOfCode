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

public class Application2 {

	

	public static void main(String[] args) {
		
		String path = "d:\\eges.txt";
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			
			long somma = 0;
			int o = 0;
			int i = 0;
			int numero = 1;
			String line; 
			int [] colonne = {3,46,52,58,69,86,110};
			int [] righe = {9,22,46,58,65,77,134};
			//int [] colonne = {2,5,8};
			//int [] righe = {3,7};
			Map<Integer,Map<Integer, Integer>> galaxies = new TreeMap<>();
			List<String> rows = new ArrayList<>();
			// read leggo le righe e raddoppio le righe
			while ((line = br.readLine()) != null) {
				/*String delmiatata = "";
				for(int d = 0; d < line.length(); d++){
					delmiatata = delmiatata + "," + line.charAt(d);
				}
				System.out.println(delmiatata);*/
				/*if (line.equals("...................................................................................................................................................")){
					rows.add(line);
					rows.add(line);
					System.out.println("trogata: " + o);
				}
				else*/
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
				long moltiplicatoreColonne = 999999;
				long moltiplicatoreRighe = 999999;
				for (int h = g+1; h<= numero-1; h++){
					Map<Integer, Integer> galaxy2 = galaxies.get(h);
					Map.Entry<Integer,Integer> entry = galaxy1.entrySet().iterator().next();
					long x1 = entry.getKey();
					long y1 = entry.getValue();
					Map.Entry<Integer,Integer> entry2 = galaxy2.entrySet().iterator().next();
					long x2 = entry2.getKey();
					long y2 = entry2.getValue();
					for (int r = 0; r < righe.length; r++){
						if ((righe[r]>=entry.getValue() && righe[r] <= entry2.getValue()) ){
							y2 += moltiplicatoreRighe;
						}
						else if ( (righe[r]<=entry.getValue() && righe[r]>= entry2.getValue())){
							y1+= moltiplicatoreRighe;
						}
					}
					for (int c = 0; c < colonne.length; c++){
						if ((colonne[c]>=entry.getKey() && colonne[c] <= entry2.getKey()) ){
							x2 += moltiplicatoreColonne;
						}
						else if ( (colonne[c]<=entry.getKey() && colonne[c]>= entry2.getKey())){
							x1 += moltiplicatoreColonne;
						}
					}
					moltiplicatoreColonne =moltiplicatoreColonne == 0 ? 1 : moltiplicatoreColonne;
					moltiplicatoreRighe = moltiplicatoreRighe== 0 ? 1 : moltiplicatoreRighe;
					long distanza = (Math.abs(x2-x1))
							+(Math.abs(y2-y1));
					//System.out.println(g + " nodo:  "+ galaxy1.toString() + " " + h + " nodo: " + galaxy2.toString() + " Distanza: " + distanza);
					System.out.println(g + " nodo:  ["+ x1 + "," + y1 + "] " + h + " nodo: [" + x2 + "," + y2 + "] Distanza: " + distanza);
					//System.out.println("Distanza: " + distanza);
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

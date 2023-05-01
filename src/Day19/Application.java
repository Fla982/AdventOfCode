package Day19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Day11.Cella;
import Day11.posto;

public class Application {

	public final static String[] messages = new String[136];
	public final static List<String> results = new ArrayList<>();
	public static int totale = 0; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "d:\\monster.txt";
		int maxRow = 0;	
		int maxColumn = 0;
		int uguali = 0;
		List<Messaggio> codici = new ArrayList<Messaggio>();
		Map<Integer,List<String>> rules = new HashMap<Integer,List<String>>();
		
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

					
			String line; 
			// read messages and resuls
			while ((line = br.readLine()) != null) {
				//104: "a"
				if (line.length()>0 ){
					
					if (line.contains(":")){
						String[]  value = line.split(":") ;
						messages[Integer.valueOf(value[0])]= value[1];
						String ok = "";
						if (line.contains("a") || line.contains("b") ){
							System.out.println("" + (char) 34 );
							codici.add(new Messaggio((int) Integer.parseInt(value[0]), value[1].replaceAll(String.valueOf((char) 34), "").trim()));	
						}
						else ok = "SI";
						if (ok.equals("SI")){
							String[] condizione = value[1].split("|");
							rules.put(Integer.valueOf(value[0]), Arrays.asList(condizione));
							ok = "";
						}
					}
					else results.add(line.trim());
					
				}
				
				System.out.println("Messages : " + line + "");
			}	
									
			System.out.println("Results: "+ results.toString());
		    System.out.println("Messages: " + messages.toString());
		    
			// decode
		    for(Messaggio codice: codici){
		    	Iterator <Integer> it = rules.keySet().iterator();       //keyset is a method
				while(it.hasNext())  
				{  
				    Integer key= it.next();  
				    String numerico = "";
					System.out.println("Message no.: "+key.toString()+"     value: "+rules.get(key) + " ");
					for(String s: rules.get(key)){
						String newValue = s.replaceAll(String.valueOf(key), codice.getValue());
						String regex = "-?\\d+(\\.\\d+)?";	
						for(int c = 0; c < newValue.length(); c++){
							if (String.valueOf(newValue.charAt(c)).matches(regex))
								numerico = "SI";
						}
						if (!numerico.equals("SI"))
							codici.add(new Messaggio((int) key, newValue.trim().replaceAll(" ", "")));
						
					}
				}
		    }
		    // controllo finale
		    for (String risultato: results){
		    	for(Messaggio m: codici){
		    		if (m.getIndice()==0){
		    			if (m.getValue().equals(risultato))
		    				totale ++;
		    		}
		    	}
		    	
		    }
		    System.out.println("RISULTATO FINALE: " + totale);
		    
		}	catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	
	}
	

}

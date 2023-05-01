package it.advent2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application2 {
	public static Map<String,Integer> n = new HashMap<String,Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader objReader = null;
		  try {
		   String strCurrentLine;

		   objReader = new BufferedReader(new FileReader("D:\\day7.txt"));
		   Map<Map,Map> bags = new HashMap<Map,Map>();
		   while ((strCurrentLine = objReader.readLine()) != null) {
			   Map<String,Integer> bag = new HashMap<String,Integer>();
			   Map<String,Integer> key = new HashMap<String,Integer>();	
			   String[] valori = strCurrentLine.split("bags contain");
			   String[] virgole = valori[1].trim().split(",");
			   int numeroBorse= 0;
			   for(int i = 0; i< virgole.length; i++){
				   String s = virgole[i].trim().replace(".", ""); 
				   if ((s.indexOf("no other bags")>-1)==false){
					  // System.out.println(s.substring(0, 1));
					   bag.put(s.substring(1).replace("bags", "").replace("bag", "").trim(), Integer.valueOf(s.substring(0, 1)));
					   numeroBorse = numeroBorse + Integer.valueOf(s.substring(0, 1));
				   }
				   else
					   bag.put("", 0);
				   
			   }
			   key.put(valori[0].trim(), numeroBorse);
			   bags.put(key, bag);
			   System.out.println(key);
				//System.out.println("Roll no.: "+key+"     name: "+bags);
		   }
		   System.out.println("Finito di leggere le righe");
		   
 
		   //factorial(bags,"bright red");
			int totale = factorial(bags,"shiny gold",1);
   
			   System.out.println("TOTALE BAGS: "+ n );
		  } catch (IOException e) {

		   e.printStackTrace();

		  } finally {

		   try {
		    if (objReader != null)
		     objReader.close();
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
		 }
	public static int factorial(Map bags, String search, int s) {
		Iterator <Map> it = bags.keySet().iterator();       //keyset is a method  
		List<String> list = new ArrayList<String>();
		Map<Map,Map> key = new HashMap<Map,Map>();
		Map<String,Integer> valore = new HashMap<String,Integer>();
		Integer risultato = 0;
		int result = 0;
		
		while(it.hasNext())  
		{
			
			Object keys= it.next();
			//System.out.println("Roll no.: "+keys+"     name: "+bags.get(keys));
			key = (Map<Map, Map>) keys;
			Iterator<Map> it2 = key.keySet().iterator();       //keyset is a method
			Object value= it2.next();
			String val = (String) value;
			
			if (val.trim().equals(search.trim())){
				
				Object numBorse = key.get(val);
				risultato = (Integer) numBorse;
				//System.out.println("Key: " + bags.get(keys));
				if (risultato > 0){
					valore = (Map<String, Integer>) bags.get(keys);
					result = s * risultato;
					System.out.println("Key: " + val + " Valore: " + key.get(val) + " PrecedenteVal: " + s + " Result: "+ result);
					
				}	
				if (search.equals("shiny gold")){
					System.out.println("Key: " + val + " Valore: " + s + " Result: "+ result);
					n.put("shiny gold", 1);
					Iterator <String> it4 = valore.keySet().iterator();       //keyset is a method
					while(it4.hasNext())  
					{
						
						String keys10= it4.next();
						n.put(keys10, 1);
					}
				}

			}	
			//else
				//System.out.println("ko");
		}	
				//Object numeroBorse = key.get(search);
			  /* 
			   Map bag = (Map) bags.get(key);
			  
			   for(int i = 0; i < bag.size(); i++){
					if (bag.get(i).toString().indexOf(search)>-1){ 
						System.out.println("Trovato " + search + " in "+ key);
						list.add(key.toString());
						if (n.get(key)== null)
							return null;
							//n.put(key.toString(), key);
						
			    	} else {
			    		;
			    	}
				}
				
		}   */
		
		if (valore.isEmpty())
			//System.out.println("ok");
			return 0;
		else	 {
			Iterator <String> it3 = valore.keySet().iterator();       //keyset is a method  
			
			while(it3.hasNext())  
			{  
			
				String key2=it3.next();
				//System.out.println("Trovato " +  key2 + " con " + valore.get(key2) + " * " + risultato);
				//risultato = risultato * valore.get(key2);
				if (n.get(key2) != null){
					int i = 		factorial(bags,key2,valore.get(key2));	
				}
				else
				{
					int i = 		factorial(bags,key2,result);
					//n = result;
				}
				//result = n;
				//
				
			}
		}	
		return risultato;
	}

	
}

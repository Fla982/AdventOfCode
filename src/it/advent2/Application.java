package it.advent2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {
	
	public static Map<String,String> n = new HashMap<String,String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader objReader = null;
		  try {
		   String strCurrentLine;

		   objReader = new BufferedReader(new FileReader("D:\\day7.txt"));
		   Map<String,List> bags = new HashMap<String,List>();
		   while ((strCurrentLine = objReader.readLine()) != null) {
			   List<String> bag = new ArrayList<String>();	
			   String[] valori = strCurrentLine.split("bags contain");
			   String[] virgole = valori[1].trim().split(",");
			   for(int i = 0; i< virgole.length; i++){
				   String s = virgole[i].trim().replace(".", ""); 
				   bag.add(s.substring(1).trim());
			   }
			   bags.put(valori[0].trim(), bag);
			   System.out.println(strCurrentLine);
		   }
		   System.out.println("Finito di leggere le righe");
		   
		   //Iterator <String> it = bags.keySet().iterator();       //keyset is a method  
		   //while(it.hasNext()){
			  // String key=it.next(); 
			   factorial(bags,"shiny gold");
		   //}   
		   /*Iterator <String> it = bags.keySet().iterator();       //keyset is a method  
		   while(it.hasNext())  
		   {  
			   String key=it.next();  
			   System.out.println("Roll no.: "+key+"     name: "+bags.get(key));
			   List bag = bags.get(key);
			   for(int i = 0; i < bag.size(); i++){
				   factoria(String key, List list, String search);
				   if (bag.get(i).toString().indexOf("shiny gold")>-1)
					   return 1;
			   }
		   } */ 
			   System.out.println("TOTALE BAGS: "+n.size());
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
	public static String factorial(Map bags, String search) {
		Iterator <String> it = bags.keySet().iterator();       //keyset is a method  
		List<String> list = new ArrayList<String>();
		while(it.hasNext())  
		{  
			   String key=it.next();  
			   System.out.println("Roll no.: "+key+"     name: "+bags.get(key));
			   List bag = (List) bags.get(key);
			   for(int i = 0; i < bag.size(); i++){
					if (bag.get(i).toString().indexOf(search)>-1){ 
						System.out.println("Trovato " + search + " in "+ key);
						list.add(key);
						if (n.get(key)== null)
							n.put(key, key);
						
			    	} else {
			    		;
			    	}
				}
		}   
		if (list.isEmpty())
			return null;
		else	 {
			for(int i = 0; i < list.size(); i++){
				factorial(bags,list.get(i));
			}
		}	
		return null;
	}

}



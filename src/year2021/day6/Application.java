package year2021.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {


	static int gamma = 0;
	static  int epsilon = 0;

	public static void main(String[] args) {
		
		String path = "d:\\lanternfish.txt";
		int increased = 0;	
		int previousNumber = 0 ;
		int nextNumber = 0;
		ArrayList<Numero> list = new ArrayList<>();
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			
			String line;
			
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				String[] binary  = line.split(",");
				
				
				
				System.out.println("Riga " + i + ": value: " + binary.length + " " );
				
				for(int z = 0; z< binary.length; z++){
					list.add(new Numero(Integer.valueOf(binary[z])));
				}
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			
			
			List<Numero> addingList1 = new ArrayList<>();
			List<Numero> addingList2 = new ArrayList<>();
			List<Numero> addingList3 = new ArrayList<>();
			List<Numero> addingList4 = new ArrayList<>();
			List<Numero> addingList5 = new ArrayList<>();
			List<Numero> addingList6 = new ArrayList<>();
			Numero n ;
			for (int g = 1; g<= 256; g++){
				
				for(int c = 0; c< addingList5.size(); c++ ){
					int l = addingList5.get(c).getNumero();
					if (l == 0) {
						n = new Numero(6);
						//list.get(c).setNumero(n);
						addingList5.set(c,n);
					
						addingList6.add(new Numero(8));
					}
					else{
						n = new Numero(Integer.valueOf(l-1));
						//list.get(c).setNumero(n);
						addingList5.set(c,n);
						//list.get(c).setNumero(Integer.valueOf(l--));
					}
				}
				//list.addAll(addingList1);
				for(int c = 0; c< addingList4.size(); c++ ){
					int l = addingList4.get(c).getNumero();
					if (l == 0) {
						n = new Numero(6);
						//list.get(c).setNumero(n);
						addingList4.set(c,n);
					
						addingList5.add(new Numero(8));
					}
					else{
						n = new Numero(Integer.valueOf(l-1));
						//list.get(c).setNumero(n);
						addingList4.set(c,n);
						//list.get(c).setNumero(Integer.valueOf(l--));
					}
				}	
				for(int c = 0; c< addingList3.size(); c++ ){
					int l = addingList3.get(c).getNumero();
					if (l == 0) {
						n = new Numero(6);
						//list.get(c).setNumero(n);
						addingList3.set(c,n);
					
						addingList4.add(new Numero(8));
					}
					else{
						n = new Numero(Integer.valueOf(l-1));
						//list.get(c).setNumero(n);
						addingList3.set(c,n);
						//list.get(c).setNumero(Integer.valueOf(l--));
					}
				}
				for(int c = 0; c< addingList2.size(); c++ ){
					int l = addingList2.get(c).getNumero();
					if (l == 0) {
						n = new Numero(6);
						//list.get(c).setNumero(n);
						addingList2.set(c,n);
					
						addingList3.add(new Numero(8));
					}
					else{
						n = new Numero(Integer.valueOf(l-1));
						//list.get(c).setNumero(n);
						addingList2.set(c,n);
						//list.get(c).setNumero(Integer.valueOf(l--));
					}
				}
				for(int c = 0; c< addingList1.size(); c++ ){
					int l = addingList1.get(c).getNumero();
					if (l == 0) {
						n = new Numero(6);
						//list.get(c).setNumero(n);
						addingList1.set(c,n);
					
						addingList2.add(new Numero(8));
					}
					else{
						n = new Numero(Integer.valueOf(l-1));
						//list.get(c).setNumero(n);
						addingList1.set(c,n);
						//list.get(c).setNumero(Integer.valueOf(l--));
					}
				}
				for(int c = 0; c< list.size(); c++ ){
					int l = list.get(c).getNumero();
					if (l == 0) {
						n = new Numero(6);
						//list.get(c).setNumero(n);
						list.set(c,n);
					
						addingList1.add(new Numero(8));
					}
					else{
						n = new Numero(Integer.valueOf(l-1));
						//list.get(c).setNumero(n);
						list.set(c,n);
						//list.get(c).setNumero(Integer.valueOf(l--));
					}
				}
				if (list.size()>1000000000){
					if (addingList2.size()>1000000000){
						addingList2.addAll(addingList3);
						addingList3 = new ArrayList<>();
					}
					else {
						addingList2.addAll(addingList3);
						addingList3 = new ArrayList<>();
						}
				}
				else{
					list.addAll(addingList2);
					addingList2 = new ArrayList<>();
				}	
				
			}
						
			
			System.out.println("Total Fish: " + list.size() + " " );
			
			
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

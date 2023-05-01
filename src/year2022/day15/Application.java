package year2022.day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.DatatypeConverter;

public class Application {

	static String finito = "";
	static int totale = 0;
	static final int Y =  2000000;
	
	

	public static void main(String[] args) {
		
		
		long xMin= 0;	
		long xMax = 0 ;
		long raggio = 0;
		//String list[][] = new String[9000000][9000000];
		long beacons = 0;
		long raggioCalcolato = 0;
		Map<Integer,String> listaDuemilioni = new TreeMap<>();
		long xUno = 0;
		long xDue = 0;
		
		try {
			//PART 1
			raggio = 1784860;
			xMin = 3818312 - raggio;
			xMax = 3818312 + raggio;
			
			
			for (int i = (int) xMin; i <= xMax; i++){
				raggioCalcolato = Math.abs(3818312-i)+Math.abs(282332-Y);

				if (raggioCalcolato == raggio){
					System.out.println("Punto: " + i);
					if (xUno == 0) xUno = i;
					else if (xDue == 0 ) xDue = i;
					
				}
			}
			for (int i = (int) xUno; i<= xDue; i++){
				listaDuemilioni.put(i, "#") ;	
			}
			
			
			//PART 2
			raggio = 177080;
			xMin = 1704479-raggio;
			xMax = 1704479+raggio;
			xUno = 0; xDue = 0;
			
			for (int i = (int) xMin; i <= xMax; i++){
				raggioCalcolato = Math.abs(1704479-i)+Math.abs(2132468-Y);
				//System.out.println("X: " + i + " Y: " + Y+ " Raggio: " + raggio + " Calcolo: " + raggioCalcolato);
				if (raggioCalcolato == raggio) {
					System.out.println("Punto: " + i);
					if (xUno == 0) xUno = i;
					else if (xDue == 0 ) xDue = i;
					
				}
			}
			for (int i = (int) xUno; i <= xDue; i++){
				listaDuemilioni.put(i, "#") ;	
			}
			
			
			//PART 3
			raggio = 1860563;
			xMin = 2582061-raggio;
			xMax = 2582061+raggio;
			xUno = 0; xDue = 0;
			
			for (int i = (int) xMin; i <= xMax; i++){
				raggioCalcolato = Math.abs(2582061-i)+Math.abs(972407-Y);
				if (raggioCalcolato == raggio){
					System.out.println("Punto: " + i);
					if (xUno == 0) xUno = i;
					else if (xDue == 0 ) xDue = i;

				}
			}
			for (int i = (int) xUno; i <= xDue; i++){
				listaDuemilioni.put(i, "#") ;	
			}
			//PART 4
			raggio = 652840;
			xMin = 3426950-raggio;
			xMax = 3426950+raggio;
			xUno = 0 ; xDue = 0;
			
			for (int i = (int) xMin; i <= xMax; i++){
				raggioCalcolato = Math.abs(3426950-i)+Math.abs(2290126-Y);
				if (raggioCalcolato == raggio){
					System.out.println("Punto: " + i);
					if (xUno == 0) xUno = i;
					else if (xDue == 0 ) xDue = i;
				}
			}
			for (int i = (int) xUno; i <= xDue; i++){
				listaDuemilioni.put(i, "#") ;	
			}
			//PART 5
			raggio = 793986;
			xMin = 2693503-raggio;
			xMax = 2693503+raggio;
			xUno = 0; xDue = 0; 
			
			for (int i = (int) xMin; i <= xMax; i++){
				raggioCalcolato = Math.abs(2693503-i)+Math.abs(2291389-Y);
				if (raggioCalcolato == raggio) {
					System.out.println("Punto: " + i);
					if (xUno == 0) xUno = i;
					else if (xDue == 0 ) xDue = i;
				}
			}
			for (int i = (int) xUno; i <= xDue; i++){
				listaDuemilioni.put(i, "#") ;	
			}
			//PART 6
			raggio = 762451;
			xMin = 1290383-raggio;
			xMax = 1290383+raggio;
			xUno = 0; xDue = 0; 
			
			for (int i = (int) xMin; i <= xMax; i++){
				raggioCalcolato = Math.abs(1290383-i)+Math.abs(1696257-Y);
				if (raggioCalcolato == raggio){
					System.out.println("Punto: " + i);
					if (xUno == 0) xUno = i;
					else if (xDue == 0 ) xDue = i;
				}
			}
			for (int i = (int) xUno; i <= xDue; i++){
				listaDuemilioni.put(i, "#") ;	
			}
			//PART 7
			raggio = 1527585;
			xMin = 336629-raggio;
			xMax = 336629+raggio;
			xUno = 0; xDue = 0;
			
			for (int i = (int) xMin; i <= xMax; i++){
				raggioCalcolato = Math.abs(336629-i)+Math.abs(2519780-Y);
				if (raggioCalcolato == raggio) {
					System.out.println("Punto: " + i);
					if (xUno == 0) xUno = i;
					else if (xDue == 0 ) xDue = i;		
				}
			}
			for (int i = (int) xUno; i <= xDue; i++){
				listaDuemilioni.put(i, "#") ;	
			}
			//PART 8
			xMin = 580439;
			xMax = 1958708-raggio;
			raggio = 1958708+raggio;
			xUno = 0; xDue = 0; 
			
			
			for (int i = (int) xMin; i <= xMax; i++){
				raggioCalcolato = Math.abs(1958708-i)+Math.abs(2370822-Y);
				if (raggioCalcolato == raggio) {
					System.out.println("Punto: " + i);
					if (xUno == 0) xUno = i;
					else if (xDue == 0 ) xDue = i;				
				}
			}
			for (int i = (int) xUno; i <= xDue; i++){
				listaDuemilioni.put(i, "#") ;	
			}
			//PART 9
			raggio = 384446;
			xMin = 3904910-raggio;
			xMax = 3904910+raggio;
			
			for (int i = (int) xMin; i <= xMax; i++){
				raggioCalcolato = Math.abs(3904910-i)+Math.abs(2080560-Y);
				if (raggioCalcolato == raggio) {
					System.out.println("Punto: " + i);
					if (xUno == 0) xUno = i;
					else if (xDue == 0 ) xDue = i;		
				}
			}
			for (int i = (int) xUno; i <= xDue; i++){
				listaDuemilioni.put(i, "#") ;	
			}
			
			for (Integer x: listaDuemilioni.keySet())
			{
				System.out.println("Valore: " +  x);
				if (listaDuemilioni.get(x).equals("#")) totale++;
				
			}
		
			System.out.println("TOTALE INCREASED: " + (totale-1));	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

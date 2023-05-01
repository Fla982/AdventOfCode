package year2021.day16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

public class Application {

	static String finito = "";
	static int totale = 0;
	static final int TONDA =  3;
	static final int QUADRATA = 57 ;
	static final int GRAFFA = 1197 ;
	static final int XML = 25137 ;
	

	public static void main(String[] args) {
		
		String path = "d:\\hexadecimal.txt";
		int increased = 0;	
		int previousNumber = 0 ;
		int nextNumber = 0;
		Integer list[] = new Integer[2000];
		Map<String,String> pair = new HashMap<>();
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			List<String> simboli = new ArrayList<>();
			String character = "";
			String line; 
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				System.out.println("Riga " + i + ": Value: " + line);
				
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
			line = "38006F45291200";
			// Hex to Binary
			StringBuffer sb = new StringBuffer();
		    char[] chArray = line.toCharArray();
		    for(int a = 0; a < chArray.length; a++)
		    {
		         //String strBinadecimal =  Integer.toBinaryString(chArray[a]);
		    	String strBinadecimal = Hexadecimal.convertToBinary(String.valueOf(chArray[a]));
		         sb.append(strBinadecimal);
		    }
		    String strOutput = sb.toString();
		    System.out.println(strOutput);
			//Binary get versions
		    char[] chArray2 = strOutput.toCharArray();
		    int version = Integer.parseInt(String.valueOf(chArray2[0]) + String.valueOf(chArray2[1]) + String.valueOf(chArray2[2]),2);
			int type = Integer.parseInt(String.valueOf(chArray2[3]) + String.valueOf(chArray2[4]) + String.valueOf(chArray2[5]),2);
			int length = String.valueOf(chArray2[6]).equals("0") ? 15 :11;
			sb = new StringBuffer();
			for (int q = 7; q < 7+length; q++){
				
				sb.append(String.valueOf(chArray2[q]));
			}
			String strSubPackte = sb.toString();
			
			int subPacket = Integer.parseInt(strSubPackte,2);
			if (length == 11){
				int literal = 0;
				for (int g = 0; g < subPacket; g++){
					literal = Integer.parseInt(strOutput.substring(7+length+1+(g*11),7+length+1+(11*(g+1))+1),2);
					System.out.println("Literal: " + literal);
				}
			}
			else{
				int subtotal = subPacket -11;
				int literal1 = Integer.parseInt(strOutput.substring(7+length+1,7+length+1+11),2);
				int literal2 = Integer.parseInt(strOutput.substring(7+length+1+11,7+length+1+subPacket),2);
				System.out.println("Literal 1: " + literal1 + " binary: " + strOutput.substring(7+length+1,7+length+1+11));
				System.out.println("Literal 2: " + literal2 + " binary: " + strOutput.substring(7+length+1+11,7+length+1+subPacket));
			}
			
			
			
			
			totale = version + type + length + subPacket;
		    System.out.println("Version: " + version);
		    System.out.println("Type ID: " + type);
		    System.out.println("Length type ID: " + length);
		    System.out.println("Length value: " + subPacket);
			System.out.println("TOTALE INCREASED: " + totale);	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

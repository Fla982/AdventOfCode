package year2021.day16;

public class Hexadecimal {

	public Hexadecimal() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static String convertToBinary(String value){
		
		if ("0".equals(value)) return "0000";
		else if ("1".equals(value))return "0001";
		else if ("2".equals(value)) return "0010";
		else if ("3".equals(value)) return "0011";
		else if ("4".equals(value)) return "0100";
		else if ("5".equals(value)) return "0101";
		else if ("6".equals(value)) return "0110";
		else if ("7".equals(value)) return "0111";
		else if ("8".equals(value)) return "1000";
		else if ("9".equals(value)) return "1001";
		else if ("A".equals(value)) return "1010";
		else if ("B".equals(value)) return "1011";
		else if ("C".equals(value)) return "1100";
		else if ("D".equals(value)) return "1101";
		else if ("E".equals(value)) return "1110";
		else if ("F".equals(value)) return "1111";
		return "";
	}
}

package year2022.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Stack {

	Map<String, List<String>> stacks ;
	
	public Stack() {
		// TODO Auto-generated constructor stub
		stacks = new TreeMap<>();
		List crates = new ArrayList<>();
		crates.add("Z");
		crates.add("P");
		crates.add("M");
		crates.add("H");
		crates.add("R");
		stacks.put("1", crates);
		crates = new ArrayList<>();
		crates.add("P");
		crates.add("C");
		crates.add("J");
		crates.add("B");
		stacks.put("2", crates);
		crates = new ArrayList<>();
		crates.add("S");
		crates.add("N");
		crates.add("H");
		crates.add("G");
		crates.add("L");
		crates.add("C");
		crates.add("D");
		stacks.put("3", crates);
		crates = new ArrayList<>();
		crates.add("F");
		crates.add("T");
		crates.add("M");
		crates.add("D");
		crates.add("Q");
		crates.add("S");
		crates.add("R");
		crates.add("L");
		stacks.put("4", crates);
		crates = new ArrayList<>();
		crates.add("F");
		crates.add("S");
		crates.add("P");
		crates.add("Q");
		crates.add("B");
		crates.add("T");
		crates.add("Z");
		crates.add("M");
		stacks.put("5", crates);
		crates = new ArrayList<>();
		crates.add("T");
		crates.add("F");
		crates.add("S");
		crates.add("Z");
		crates.add("B");
		crates.add("G");
		stacks.put("6", crates);
		crates = new ArrayList<>();
		crates.add("N");
		crates.add("R");
		crates.add("V");
		stacks.put("7", crates);
		crates = new ArrayList<>();
		crates.add("P");
		crates.add("G");
		crates.add("L");
		crates.add("T");
		crates.add("D");
		crates.add("V");
		crates.add("C");
		crates.add("M");
		stacks.put("8", crates);
		crates = new ArrayList<>();
		crates.add("W");
		crates.add("Q");
		crates.add("N");
		crates.add("J");
		crates.add("F");
		crates.add("M");
		crates.add("L");
		stacks.put("9", crates);
	}

}

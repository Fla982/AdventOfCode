package year2022.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.soap.Node;


public class Application {


	static final int MAX_SIZE = 100000;
	static  int epsilon = 0;

	public static void main(String[] args) {
		
		String path = "d:\\nospace.txt";
		Archivio fileSystem ;
		
		try {
		
			BufferedReader br = new BufferedReader(
						                new FileReader(path)); 

			int i = 0;
			//TreeNode<Archivio> root;
			Archivio root = new Archivio();
			root.setNome("FileSystem");
			root.setParent(null);
			root.setTipo("dir");
			root.setValue(0);
			TreeNode<Archivio> node =  new TreeNode<Archivio>(root);
			String line;
			TreeNode<Archivio> nodeChild =null;
			// read airplane seats
			while ((line = br.readLine()) != null) {
				
				String[] lettore = line.split(" ");
				if (lettore[0].equals("$")){
					if (lettore[1].equals("cd")){
						if (lettore[2].equals("..")){
							System.out.println(nodeChild.parent);
						}
						else //è cartella 
						{
							
							
								
								
							
						}
					}
					else if (lettore[1].equals("ls")) //lista file
					{
						
					}
				}
				else {
					if (lettore[0].equals("dir"))// dir gpmlznd
					{
						Archivio a = new Archivio();
						a.setNome(lettore[1]);
						a.setParent(null);
						a.setTipo("dir");
						a.setValue(0);
						nodeChild = node.addChild(a);
						
					}
					else //file 11223 bplz.rdp
					{
						Archivio a = new Archivio();
						a.setNome(lettore[1]);
						a.setParent(null);
						a.setTipo("file");
						a.setValue(Integer.valueOf(lettore[0]));
						
						nodeChild = node.addChild(a);
						
					}
						
					
				}
				
				System.out.println("Riga " + i + ": value: " + line + " " );
				
				
				i++;
				//if (maxRow < i) maxRow = i;
			}
				
			
			
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}

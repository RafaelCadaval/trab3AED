package body;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TreeCalculator {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("expressoes.txt"));
		String line;		
		
	/*	while((line = br.readLine()) != null) {
			int contaParenteses = 0;
			String parts[]= line.split(" ");
			
			for(int i = 0; i<parts.length; i++){
				if(parts[i].equals("("))
					contaParenteses++;
				if(parts[i].equals(")"))
					contaParenteses--;  
			} 
			if(contaParenteses != 0) {
					System.out.println("Erro de Sintaxe!");
					System.out.println(" ");
					continue;
				}
		} */
		
	}
}

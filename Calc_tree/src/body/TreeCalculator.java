package body;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TreeCalculator {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("expressoes.txt"));
		char quepo;
		ArrayList<Node> bir = new ArrayList<>();
		
		while((quepo = (char)br.read()) != '\n'){
			if (quepo != ' ')bir.add(new Node(quepo));			   			
		}

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
			
		for(int i=0; i<bir.size(); i++){
			if(bir.get(i).element == ')'){
				bir.remove(i);
				i--;
				Node aux1 = bir.get(i);
				bir.remove(i);
				i--;
				Node aux2 = bir.get(i);				
				bir.remove(i);
				i--;
				Node aux3 = bir.get(i);				
				bir.remove(i);
				i--;
				bir.set(i, aux2);
				bir.get(i).left = aux3;
				bir.get(i).right = aux1;				
			}
		}
		
	}
}

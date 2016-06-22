package body;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TreeCalculator {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("expressoes.txt"));
		String line;		
			while((line = br.readLine()) != null) {
			ArrayList<Node> bir = new ArrayList<>();
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
			} else {
				for(int j= 0; j<parts.length; j++) {
					bir.add(new Node(parts[j]));
				}
			}
				 
			for(int i=0; i<bir.size(); i++){
			if(bir.get(i).element.equals(")")){
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
				aux3.father = aux2;
				aux1.father = aux2;
				bir.get(i).left = aux3;
				bir.get(i).right = aux1;	
				
		}
		}		
		System.out.println();
		bir.get(0).posicoesLargura();
		System.out.println();
		bir.get(0).poisicoesCentral();
		System.out.println();
		System.out.println("Alutra máxima: " + bir.get(0).achaAltura());
		bir.get(0).calcula();
		System.out.println("Resultado:" + bir.get(0).element);
		System.out.println();
	}
	}
		
}
		
	



package body;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;

public class Node {	
		public String element;
		public Node father;
		public Node left;
		public Node right;
		
		public Node(String element){
			father = null;
			left = null;
			right = null;
			this.element = element;
		}
		
		public void calcula(){
			if(this == null) return;
			if(this.left !=null)this.left.calcula();
			if(this.right !=null)this.right.calcula();
			String operador = this.element;			
				switch(operador){
					case "+": this.element = ""+(Double.parseDouble(this.left.element) + Double.parseDouble(this.right.element));					
					break; 
					case "-": this.element = ""+(Double.parseDouble(this.left.element) - Double.parseDouble(this.right.element));
					break;
					case "*": this.element = ""+(Double.parseDouble(this.left.element) * Double.parseDouble(this.right.element));
					break;
					case "/": this.element = ""+(Double.parseDouble(this.left.element) / Double.parseDouble(this.right.element));
					break;	
					case "^": this.element = ""+Math.pow(Double.parseDouble(this.left.element),Double.parseDouble(this.right.element));
					break;
				}
			}
		
		public void posicoesCentral(){
			ArrayList<Node> central = new ArrayList<>();
			posicoesCentralAux(central);
			System.out.print("Caminhamento Central :");
			for(int i=0; i<central.size(); i++){
			System.out.print(central.get(i) + " ");
				
			}
			
		}
		
		private void posicoesCentralAux(ArrayList central) {
			if(this == null) return;
			if(this.left != null)
				this.left.posicoesCentralAux(central);
			central.add(this.element);
			if(this.right != null)
				this.right.posicoesCentralAux(central);
				
		}
		
		public void posicoesLargura() {
			ArrayList<Node> piu = new ArrayList<>();
			ArrayList<Node> quepo = new ArrayList<>();
			Node aux = this;
				quepo.add(this);
					while(!quepo.isEmpty()) {
						aux = quepo.remove(0);
						if(aux.left != null) quepo.add(aux.left);
						if(aux.right != null) quepo.add(aux.right);
						piu.add(aux);
			}
			System.out.print("Caminhamento em Largura :");
			for(int i = 0;i<piu.size(); i++){
				System.out.print(piu.get(i).element + " ");
			}
		}
		
		public void posicoesPre(){
			ArrayList<Node> a = new ArrayList<>();
			posicoesPreAux(a);
			System.out.print("Caminhamento Pre: ");
			for(int i=0; i<a.size(); i++){
				System.out.print(a.get(i)+ " ");
			}
		}
				
		private void posicoesPreAux(ArrayList a){ 		
			if(this == null)return;
			a.add(this.element);
			if(this.left != null)
				this.left.posicoesPreAux(a);
			if(this.right != null)
				this.right.posicoesPreAux(a);			
		}	
		
		public void posicoesPos(){
			ArrayList<Node> b = new ArrayList<>();
			posicoesPosAux(b);
			System.out.print("Caminhamento Pos: ");
			for(int i=0; i<b.size(); i++){
				System.out.print(b.get(i)+ " ");
			}
		}
		
		private void posicoesPosAux(ArrayList b){
			if(this == null)return;
			if(this.left != null) this.left.posicoesPosAux(b);
			if(this.right != null) this.right.posicoesPosAux(b);
			b.add(this.element);
		}

		public int achaAltura() {
		  ArrayList<Node> fila = new ArrayList<>();
		  Node aux = null;
		  Node fim = null;
		  if(this != null){
			  fila.add(this);
			  while(!fila.isEmpty()){
				  aux= fila.remove(0);
			  	  if(aux.left != null)
			  		 fila.add(aux.left);
			  	  if(aux.right != null)
			  		 fila.add(aux.right);
			  	  fim = aux;
			  }
		  }
		  int count = 0;
		  while(fim != this) {
			  count++;
			  fim = fim.father;			  
		  }
		  return count;
		}
	}





	

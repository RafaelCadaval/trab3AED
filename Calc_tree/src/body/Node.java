package body;

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
		
		public void posicoesCentral() {
			if(this == null) System.out.println(this);
			if(this.left != null) this.left.posicoesCentral();
			System.out.println(this);
			if(this.right != null) this.right.posicoesCentral();
			System.out.println(this);
		}
		
		public void posicoesLargura() {
			
		}
		
		
		int achaAltura() {
		    if (this == null) {
		        return -1;
		    }

		    int left = this.left.achaAltura();
		    int right = this.right.achaAltura();

		    if (left > right) {
		        return left + 1;
		    } else {
		        return right + 1;
		    }
		}
	}





	

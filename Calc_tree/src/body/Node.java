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
				}
				this.element.replace(',', '.');
			}
		}





	

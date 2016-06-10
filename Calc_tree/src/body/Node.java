package body;

public class Node {	
		public char element;
		public Node father;
		public Node left;
		public Node right;
		
		public Node(char element){
			father = null;
			left = null;
			right = null;
			this.element = element;
		}
	}


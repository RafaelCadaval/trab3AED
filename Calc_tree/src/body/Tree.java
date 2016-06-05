package body;

public class Tree<E> {
	private Node root;
	private E element;
	
	private class Node {
		public E elem;
		public Node father;
		public Node left;
		public Node right;
		
		
		public Node(E elem){
			this.elem = elem;
		}
	}
	
	public Tree(){
		
	}
}

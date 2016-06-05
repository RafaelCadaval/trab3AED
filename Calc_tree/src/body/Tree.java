package body;
import java.util.ArrayList;
//PERGUNTAR PRA ALGUÉM DOS IMPORTS, PORQUE NÃO CONSIGO USAR HIERARQUIA DE LIST<>
import java.util.LinkedList;

public class Tree<E> {
	private Node root;
	private E element;
	private int height;
	
	private class Node {
		public E elem;
		public Node father;
		public Node left;
		public Node right;
		
		public Node(E elem){
			father = null;
			left = null;
			right = null;
			this.elem = elem;
		}
	}
	
	public Tree(){
		height = 0;
		root = null;
	}
	
	//ENCAMINHAMENTOS:
	//PRE
	public LinkedList<E> positionsPre(){
		LinkedList<E> res = new LinkedList<>();
		positionsPreAux(root, res);
		return res;
	}
	
	private void positionsPreAux(Node n, LinkedList<E> res){
		if(n == null)
			return;
		res.add(n.elem);
		if(n.left != null)
			positionsPreAux(n.left, res);
		if(n.right != null)
			positionsPreAux(n.right, res);
	}
	
	//POS
	public LinkedList<E> positionsPos(){
		LinkedList<E> res = new LinkedList<>();
		positionsPosAux(root, res);
		return res;
	}
	
	private void positionsPosAux(Node n, LinkedList<E> res){
		if(n == null)
			return;
		res.add(n.elem);
		if(n.left != null)
			positionsPosAux(n.left, res);
		if(n.right != null)
			positionsPosAux(n.right, res);
	}
	
	//CENTRAL
	public LinkedList<E> positionsCentral() {
        LinkedList<E> res = new LinkedList<>();
        positionsCentralAux(root, res);
        return res;
    }
	
    private void positionsCentralAux(Node n, LinkedList<E> res) {
        if(n == null)
            return;
        if(n.left != null)
            positionsCentralAux(n.left, res);
        res.add(n.elem);
        if(n.right != null)
            positionsCentralAux(n.right, res);
    }
	
	//EM LARGURA
    public LinkedList<E> positionsWidth() {
        LinkedList<E> res = new LinkedList<>();
        if (root != null) {
        	ArrayList<Node> fila = new ArrayList<>();
        	Node aux = null;
        	int i = 0;
            fila.add(root);
            while(!fila.isEmpty()) {
                aux = fila.remove(i);
                if (aux.left != null)
                    fila.add(aux.left);
                if (aux.right != null)
                    fila.add(aux.right);
                res.add(aux.elem);
                i++;
            }
        }        
        return res;
    }
	
	private Node searchNodeRef(E element, Node target){
		Node res = null;
		if(target != null){
			if(target.elem.equals(element)){
				res = target;
			}
			else{
				res = searchNodeRef(element, target.left);
				if(res == null){
					res = searchNodeRef(element, target.right);
				}
			}
		}
		return res;
	}
}

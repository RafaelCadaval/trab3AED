package body;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
//PERGUNTAR PRA ALGUÉM DOS IMPORTS, PORQUE NÃO CONSIGO USAR HIERARQUIA DE LIST<>
import java.util.LinkedList;
import java.util.Scanner;

public class Tree<E> {
	private Node root;
	private E element;
	
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
        	ArrayList<Node> queue = new ArrayList<>();
        	Node aux = null;
        	int i = 0;
            queue.add(root);
            while(!queue.isEmpty()) {
                aux = queue.remove(i);
                if (aux.left != null)
                    queue.add(aux.left);
                if (aux.right != null)
                    queue.add(aux.right);
                res.add(aux.elem);
                i++;
            }
        }        
        return res;
    }
    
    public int height() {
        Node end = null;
        if (root != null) {
        	ArrayList<Node> queue = new ArrayList<>();
        	Node aux = null;
        	int i = 0;
            queue.add(root);
            while(!queue.isEmpty()) {
                aux = queue.remove(i);
                if (aux.left != null)
                    queue.add(aux.left);
                if (aux.right != null)
                    queue.add(aux.right);
                end = aux;
                i++;
            }
        }                  
        int count=0;        
        while (end != root) {
            count++;
            end = end.father;
        }        
        return count;     
    }
    
    public void buildTree(E[] data){
    	
    	for(int i=0;i<data.length;i++){
    		
    	}
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
	
	public void loadFile(){
		Path path = Paths.get("expressoes.txt");
		try(Scanner in = new Scanner(Files.newBufferedReader(path, Charset.forName("utf8")))){
			String s;
			String[] x;
			while(in.hasNextLine()){
				s = in.nextLine();
				x = s.split(" ");
				//ajeitar isso
				this.buildTree(x);
			}
		}
		catch(IOException x){
			System.err.format("Erro de E/S: %s%n", x);
		}
	}
}

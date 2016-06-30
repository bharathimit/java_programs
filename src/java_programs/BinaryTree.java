package java_programs;

public class BinaryTree {
	Node root;

	public void printPreOrder(){
		printPreOrder(root);
	}

	public void printInOrder(){
		printInOrder(root);
	}
	
	public void printPostOrder(){
		printPostOrder(root);
	}

	public void printPreOrder(Node node){
		if(node != null){
			System.out.print(node.data+" - ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}

	public void printInOrder(Node node){
		if(node != null){
			printInOrder(node.left);
			System.out.print(node.data+" - ");
			printInOrder(node.right);
		}
	}
	
	public void printPostOrder(Node node){
		if(node != null){
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.print(node.data+" - ");
		}
	}
	
	public void printAsList(){
		Node current = root;
		while(current!=null){
			System.out.println(current.data);
			current = current.right;
		}
	}
}

class Node{
	int data;
	Node right, left;

	public Node(int data){
		this.data = data;
		right = left = null;
	}
}

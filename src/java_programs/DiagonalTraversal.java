package java_programs;

import java.util.Hashtable;
import java.util.LinkedList;

//http://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
public class DiagonalTraversal {
	//This hash contains the nodes list mapped to the diagonal number.
	private Hashtable<Integer, LinkedList<Integer>> mappedData;
	
	public void printData(BinaryTree tree){
		if(tree == null || tree.root == null)
			return;
		mappedData = new Hashtable<Integer, LinkedList<Integer>>();
		placeNodes(tree.root, 0);
		printDiagonal();
	}
	
	/*
	 * Pre-order traversal. The order doesn't matter in this case.
	 * When we move to the left child, location is incremented by 1, since it goes to the next diagonal.
	 * When we move to the right child, location remains the same, since it stays in the same diagonal as the parent.
	 */
	private void placeNodes(Node node, int location){
		if(node == null)
			return;
		insertData(node.data, location);
		placeNodes(node.left, location+1);
		placeNodes(node.right, location);
	}
	
	/*
	 * Inserting the data to the corresponding diagonal list.
	 * Checks if the there is already a list. If not create a new list.
	 */
	private void insertData(int data, int location){
		LinkedList<Integer> list = mappedData.get(location);
		if(list == null){
			list = new LinkedList<Integer>();
		}
		list.add(data);
		mappedData.put(location, list);
	}
	
	private void printDiagonal(){
		for(int i=0; i<mappedData.size(); i++){
			LinkedList<Integer> list = mappedData.get(i);
			for(int j=0; j<list.size(); j++){
				System.out.print(list.get(j)+" ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(8);
		tree.root.left = new Node(3);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(6);
		tree.root.right.right = new Node(14);
		tree.root.right.right.left = new Node(13);
		tree.root.left.right.left = new Node(4);
		tree.root.left.right.right = new Node(7);
		
		DiagonalTraversal diagonalTraversal = new DiagonalTraversal();
		diagonalTraversal.printData(tree);
	}
}

package java_programs;

import java.util.Hashtable;
import java.util.LinkedList;

//http://www.geeksforgeeks.org/print-root-leaf-path-without-using-recursion/
public class RootToLeaf {
	
	private LinkedList<Node> list; //Acts as queue
	private Hashtable<Node, String> pathHash; //Contains the path to the node
	
	public void printPath(BinaryTree tree){
		if(tree == null || tree.root == null)
			return;
		
		list = new LinkedList<Node>();
		pathHash = new Hashtable<Node, String>();
		
		list.add(tree.root);
		pathHash.put(tree.root, Integer.toString(tree.root.data));

		//Normal Level order traversal
		while(!list.isEmpty()){
			Node parentNode = list.removeFirst();
			String currentPath = pathHash.remove(parentNode); //Removing the entry since it is not needed anymore
			//Leaf node check
			if(parentNode.left == null && parentNode.right == null){
				System.out.println(currentPath);
				continue;
			}
			processNode(parentNode.left, currentPath);
			processNode(parentNode.right, currentPath);
		}
		
	}
	
	//Adds the node to the queue and path to hashtable
	public void processNode(Node node, String currentPath){
		if(node != null){
			list.add(node);
			pathHash.put(node, currentPath+"->"+node.data);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);
		tree.root.right.right = new Node(7);

		RootToLeaf rootToLeaf = new RootToLeaf();
		rootToLeaf.printPath(tree);
	}
}

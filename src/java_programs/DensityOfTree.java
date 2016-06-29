package java_programs;

//http://www.geeksforgeeks.org/density-of-binary-tree-in-one-traversal/
public class DensityOfTree {
	
	// Total number of nodes in the tree
	private float noNodes = 0; 
	
	public float getDensity(BinaryTree tree){
		if(tree == null)
			return 0;
		noNodes = 0;
		int height = getHeight(tree.root);
		return noNodes/height;
	}
	
	/*
	 * Returns the height of the tree.
	 * Also sets the noNodes variable.
	 */
	public int getHeight(Node node){
		if(node == null)
			return 0;
		
		int left = getHeight(node.left);
		int right = getHeight(node.right);
		noNodes++;
		return Math.max(left, right)+1;
	}
	
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		DensityOfTree densityOfTree = new DensityOfTree();
		System.out.println(densityOfTree.getDensity(tree));
	}
}

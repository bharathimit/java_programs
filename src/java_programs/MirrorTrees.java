package java_programs;

//http://www.geeksforgeeks.org/check-if-two-trees-are-mirror/
public class MirrorTrees {
	
	// Checking a simple base case.
	public boolean areMirrors(BinaryTree tree1, BinaryTree tree2){
		if(tree1 != null && tree2 != null)
			return areMirrors(tree1.root, tree2.root);
		else
			return false;
	}
	
	public boolean areMirrors(Node node1, Node node2){
		
		//In case of level next to leaf nodes.
		if(node1 == null && node2 == null)
			return true;
		
		if(node1 == null || node2 == null)
			return false;
		
		// Recursive comparison
		return (node1.data == node2.data) &&
				areMirrors(node1.left, node2.right) &&
				areMirrors(node1.right, node2.left);
	}
	
	public static void main(String[] args){
		MirrorTrees mirrorTrees = new MirrorTrees();
		
		BinaryTree tree1 = new BinaryTree();
		BinaryTree tree2 = new BinaryTree();
		
		tree1.root = new Node(1);
		tree2.root = new Node(1);
		
		tree1.root.right = new Node(2);
		tree2.root.left = new Node(2);
		
		tree1.root.left = new Node(3);
		tree2.root.right = new Node(3);
		
		tree1.root.right.right = new Node(4);
		tree2.root.left.left = new Node(4);
		
		tree1.root.right.left = new Node(5);
		tree2.root.left.right = new Node(5);
		
		System.out.println(mirrorTrees.areMirrors(tree1, tree2));
		
	}
}

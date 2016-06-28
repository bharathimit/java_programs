package java_programs;

//http://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
public class Print2D {
	
	public void print(BinaryTree tree){
		if(tree != null && tree.root != null){
			String space = "";
			print(tree.root, space);
		}
	}
	
	public void print(Node node, String space){
		if(node != null){
			print(node.right, space+"  ");
			System.out.println(space+node.data);
			print(node.left, space+"  ");
		}
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
		
		Print2D print2d = new Print2D();
		print2d.print(tree);
	}
}

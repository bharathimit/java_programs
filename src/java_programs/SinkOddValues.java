package java_programs;

public class SinkOddValues {
	
	public void sink(BinaryTree tree) {
		if (tree != null) {
			sink(tree.root);
		}
	}

	/*
	 * Using post order to ensure that both the subtrees of the node  
	 * already satisfy the condition
	 */
	public void sink(Node node) {
		
		//Base case
		if (node == null)
			return;
		
		sink(node.left);
		sink(node.right);
		
		if (node.data % 2 == 1) {
			//We need to sink this odd value only when there is an even child
			if (node.left != null && node.left.data % 2 == 0) {
				swapNodeValues(node, node.left);
				sink(node.left); //Sink the odd value further down the tree
			} else if (node.right != null && node.right.data % 2 == 0) {
				swapNodeValues(node, node.right);
				sink(node.right); //Sink the odd value further down the tree
			}
		}

	}

	public void swapNodeValues(Node node1, Node node2) {
		int temp = node1.data;
		node1.data = node2.data;
		node2.data = temp;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		SinkOddValues sinkOddValues = new SinkOddValues();
		sinkOddValues.sink(tree);

		Print2D print2d = new Print2D();
		print2d.print(tree);

	}
}

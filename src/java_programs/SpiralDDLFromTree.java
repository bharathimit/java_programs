package java_programs;

import java.util.Stack;

//http://www.geeksforgeeks.org/convert-a-binary-tree-into-doubly-linked-list-in-spiral-fashion/
public class SpiralDDLFromTree {

	public void getDLLSpiral(BinaryTree tree) {

		if (tree == null || tree.root == null)
			return;

		Stack<Node> oddStack, evenStack;
		int direction = 0;
		oddStack = new Stack<Node>();
		evenStack = new Stack<Node>();

		Node previous = tree.root;
		Node current = null;

		// Root is a special case, since we need to mark previous node as null
		oddStack.push(previous.right);
		oddStack.push(previous.left);
		previous.left = null;

		while (!(oddStack.isEmpty() && evenStack.isEmpty())) {
			/*
			 * If the direction is 0, insert left child first.
			 * Vice versa for direction 1.
			 * When the level ends(in case of direction 0, oddStack becomes empty) change direction.
			 */
			if (direction == 0) {
				current = oddStack.pop();
				if (current.left != null)
					evenStack.push(current.left);
				if (current.right != null)
					evenStack.push(current.right);
				if (oddStack.isEmpty())
					direction = 1;

			} else {
				current = evenStack.pop();
				if (current.right != null)
					oddStack.push(current.right);
				if (current.left != null)
					oddStack.push(current.left);
				if (evenStack.isEmpty())
					direction = 0;
			}
			current.left = previous;
			previous.right = current;
			previous = current;
		}
		
		// The next pointer of last node should point to null to mark the end of list.
		if (previous != null)
			previous.right = null;
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

		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);
		// tree.root.right.left.left = new Node(12);
		tree.root.right.left.right = new Node(13);
		tree.root.right.right.left = new Node(14);
		// tree.root.right.right.right = new Node(15);

		SpiralDDLFromTree ddlFromTree = new SpiralDDLFromTree();
		ddlFromTree.getDLLSpiral(tree);
		tree.printAsList();
	}
}

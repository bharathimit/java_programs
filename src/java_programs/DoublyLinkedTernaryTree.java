package java_programs;

//http://www.geeksforgeeks.org/create-doubly-linked-list-ternary-ree/
public class DoublyLinkedTernaryTree {
	
	// Root of the doubly linked list
	public TernaryNode listRoot;
	
	public TernaryNode getDoublyLinkedList(TernaryNode root){
		if(root != null){
			root = linkDoublyLinkedList(null, root);
		}
		return listRoot;
	}
	
	public TernaryNode linkDoublyLinkedList(TernaryNode prevNode, TernaryNode currentNode){
		if(currentNode == null)
			return prevNode;
		
		TernaryNode node = new TernaryNode(currentNode.data);
		node.left = prevNode;
		
		//Setting the root of list.
		if(listRoot == null)
			listRoot = node;
		
		if(prevNode != null)
			prevNode.right = node;
		
		//Calling in the same order in which we want the list to be built
		node = linkDoublyLinkedList(node, currentNode.left);
		node = linkDoublyLinkedList(node, currentNode.middle);
		node = linkDoublyLinkedList(node, currentNode.right);
		
		return node;
	}
	
	public void printList(TernaryNode node){
		if(node != null){
			System.out.println(node.data);
			printList(node.right);
		}
	}
	
	public static void main(String[] args){
		TernaryNode root = new TernaryNode(30);
		 
		root.left = new TernaryNode(5);
		root.middle = new TernaryNode(11);
		root.right = new TernaryNode(63);

		root.left.left = new TernaryNode(1);
		root.left.middle = new TernaryNode(4);
		root.left.right = new TernaryNode(8);

		root.middle.left = new TernaryNode(6);
		root.middle.middle = new TernaryNode(7);
		root.middle.right = new TernaryNode(15);

		root.right.left = new TernaryNode(31);
		root.right.middle = new TernaryNode(55);
		root.right.right = new TernaryNode(65);
		
		DoublyLinkedTernaryTree dlObject = new DoublyLinkedTernaryTree();
		TernaryNode listRoot = dlObject.getDoublyLinkedList(root);
		dlObject.printList(listRoot);
	}
}

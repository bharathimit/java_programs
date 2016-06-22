package java_programs;

//http://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/

public class BuildTreeFromInPostOrder {
	
	private int postIndex;
	
	public BinaryTree buildTree(int[] postOrder, int[] inOrder)throws Exception{
		
		if(postOrder.length != inOrder.length)
			throw new Exception("Arrays are not of same length");
		
		BinaryTree binaryTree = new BinaryTree();
		postIndex = postOrder.length-1;
		binaryTree.root = buildTree(postOrder, inOrder, 0, postOrder.length-1);
		return binaryTree;
	}
	
	public Node buildTree(int[] postOrder, int[] inOrder, int start, int end) throws Exception{

		if(start > end)
			return null;
		
		Node node = new Node(postOrder[postIndex--]); //Moving the index to left by one, after using the current element
		
		if(start == end)
			return node;
		
		int index = findElementIndex(inOrder, node.data, start, end);
		
		if(index == -1)
			throw new Exception("Invalid/Ambiguous Input");
		
		/*
		 * In in-order traversal, left node is accessed first. 
		 * So while building the tree we need to build the right node first
		 */
		node.right = buildTree(postOrder, inOrder, index+1, end);
		node.left = buildTree(postOrder, inOrder, start, index-1);
		
		return node;
	}
	
	public int findElementIndex(int[] inOrder, int data, int start, int end){
		
		while(start <= end){
			if(inOrder[start] == data)
				return start;
			start++;
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		BuildTreeFromInPostOrder buildObject = new BuildTreeFromInPostOrder();
		int[] inOrder =  {4, 8, 2, 5, 1, 6, 3, 7};
		int[] postOrder = {8, 4, 5, 2, 6, 7, 3, 1};
		BinaryTree binaryTree = null;
		try{
			binaryTree = buildObject.buildTree(postOrder, inOrder);
			binaryTree.printPreOrder();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

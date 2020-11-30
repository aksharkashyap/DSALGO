package TREE;

class MergeTwoBST{

	static void inorder(TNode root){ 
		if (root == null) return;
		inorder(root.left); 
		System.out.print(root.data + " "); 
		inorder(root.right); 
	} 
	
	static void merge(TNode root1, TNode root2){ 
		// s1 is stack to hold nodes of first BST 
		SNode s1 = new SNode(); 
	
		// Current node of first BST 
		TNode current1 = root1; 
	
		// s2 is stack to hold nodes of second BST 
		SNode s2 = new SNode(); 
	
		// Current node of second BST 
		TNode current2 = root2; 
	
		// If first BST is empty, then output is inorder 
		// traversal of second BST 
		if (root1 == null){ 
			inorder(root2); 
			return; 
		} 
		
		// If second BST is empty, then output is inorder 
		// traversal of first BST 
		if (root2 == null) 
		{ 
			inorder(root1); 
			return ; 
		} 
	
		// Run the loop while there are nodes not yet printed. 
		// The nodes may be in stack(explored, but not printed) 
		// or may be not yet explored 
		while (current1 != null || !s1.isEmpty() || current2 != null || !s2.isEmpty()){ 
			
			// Following steps follow iterative Inorder Traversal 
			if (current1 != null || current2 != null ){ 
				// Reach the leftmost node of both BSTs and push ancestors of 
				// leftmost nodes to stack s1 and s2 respectively 
				if (current1 != null) 
				{ 
					
					s1.push( current1); 
					current1 = current1.left; 
				} 
				if (current2 != null) 
				{ 
					s2.push( current2); 
					current2 = current2.left; 
				} 
	
			} 
			else
			{ 
				
				// If we reach a NULL node and either of the stacks is empty, 
				// then one tree is exhausted, ptint the other tree 
				if (s1.isEmpty()) 
				{ 
					while (!s2.isEmpty()) 
					{ 
						current2 = s2.pop (); 
						current2.left = null; //to avoid visiting left again during inorder traversal
						inorder(current2); 
					} 
					return ; 
				} 
				if (s2.isEmpty()) 
				{ 
					while (!s1.isEmpty()) 
					{ 
						current1 = s1.pop (); 
						current1.left = null; 
						inorder(current1); 
					} 
					return ; 
				} 
	
				// Pop an element from both stacks and compare the 
				// popped elements 
				current1 = s1.pop();
				
				current2 = s2.pop();
				
				// If element of first tree is smaller, then print it 
				// and push the right subtree. If the element is larger, 
				// then we push it back to the corresponding stack. 
				if (current1.data < current2.data) 
				{ 
					System.out.print(current1.data + " "); 
					current1 = current1.right; 
					s2.push( current2); 
					current2 = null; 
				} 
				else
				{ 
					System.out.print(current2.data + " "); 
					current2 = current2.right; 
					s1.push( current1); 
					current1 = null; 
				} 
			} 
		}
		System.out.println(s1.t);
		System.out.println(s2.t);
	} 
	
	/* Driver code */
	public static void main(String[]args) 
	{ 
		TNode root1 = null, root2 = null; 
	
		/* Let us create the following tree as first tree 
			3 
			/ \ 
			1 5 
		*/
		root1 = new TNode(3) ; 
		root1.left = new TNode(1); 
		root1.right = new TNode(5); 
	
		/* Let us create the following tree as second tree 
				4 
			/ \ 
			2 6 
		*/
		root2 = new TNode(4) ; 
		root2.left = new TNode(2); 
		root2.right = new TNode(6); 
	
		// Print sorted nodes of both trees 
		merge(root1, root2); 
	} 
}

// Structure of a BST Node
class TNode{
	int data; 
	TNode left,right;
	public TNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
} 

// A stack node 
class SNode{ 
	SNode head;
	TNode t;
	SNode next;
	
	// Function to add an elemt k to stack
	void push(TNode k){ 
		SNode tmp = new SNode(); 
	
		// Perform memory check here 
		tmp.t = k; 
		tmp.next = this.head; 
		this.head = tmp;
	} 
	
	// Function to pop an element t from stack 
	TNode pop(){ 
		SNode st; 
		st = this.head;
		head = head.next;
		return st.t; 
	} 
	
	// Fucntion to check whether the stack is empty or not 
	boolean isEmpty( ){ 
		if (this.head == null ) return true; 
		return false; 
	} 
} 

// This code is contributed by nidhisebastian008

import java.util.ArrayList;
import java.util.List;

class Node{ 
	int data; 
	Node left, right; 
	public Node(int item){ 
		data = item; 
		left = right = null; 
	} 
} 

class BinaryTree{ 
	Node root; 

	void printSpecificLevelOrder(Node node){ 
		int h=height(node);
		for(int i=1;i<=2;i++){
		    printgiven(node,i);
		}
		for(int j=3;j<=h;j++){
			List<Integer> list = new ArrayList<>(); //added
			printgiventwo(node,j,list); 
			int i=0,k=list.size()-1; //added
			while(i<k) System.out.print(list.get(i++)+" "+list.get(k--)+" "); //added
		}
	}
	int height(Node node){
	    if(node==null)return 0;
	    int lh=height(node.left);
	    int rh=height(node.right);
	    return (lh>rh)?lh+1:rh+1;
	}

	void printgiven(Node node,int level){
	    if(node==null || level==0)return; //added (level==0) //no use of level 0(our desired values were present in level 1) so return from here 
	    if(level==1)System.out.print(node.data+" ");
	    printgiven(node.left,level-1);
		printgiven(node.right,level-1);	
	}

	void printgiventwo(Node node,int level, List<Integer> list){
	    if(node==null || level==0)return; /*previous code-> root==null(which is a global variable caused Null pointer exception) */ // sanitation check for passed node
	    if(level==1) list.add(node.data);
	    printgiventwo(node.left,level-1,list);
		printgiventwo(node.right,level-1,list);
		/*
			removed arraylist logic from here
		*/
	}

	public static void main(String args[]) { 
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
		tree.root.right.left.left = new Node(12); 
		tree.root.right.left.right = new Node(13); 
		tree.root.right.right.left = new Node(14); 
		tree.root.right.right.right = new Node(15); 

		tree.root.left.left.left.left = new Node(16); 
		tree.root.left.left.left.right = new Node(17); 
		tree.root.left.left.right.left = new Node(18); 
		tree.root.left.left.right.right = new Node(19); 
		tree.root.left.right.left.left = new Node(20); 
		tree.root.left.right.left.right = new Node(21); 
		tree.root.left.right.right.left = new Node(22); 
		tree.root.left.right.right.right = new Node(23); 
		tree.root.right.left.left.left = new Node(24); 
		tree.root.right.left.left.right = new Node(25); 
		tree.root.right.left.right.left = new Node(26); 
		tree.root.right.left.right.right = new Node(27); 
		tree.root.right.right.left.left = new Node(28); 
		tree.root.right.right.left.right = new Node(29); 
		tree.root.right.right.right.left = new Node(30); 
		tree.root.right.right.right.right = new Node(31); 

		System.out.println("Specific Level Order traversal of binary"
															+"tree is "); 
		tree.printSpecificLevelOrder(tree.root); 
	} 
} 
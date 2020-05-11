package Java;
//leaf count

class BTLeafCount{
	Node root;
	static class Node{
		int data;
		Node left,right;
		Node(int d){
			data=d;
			left=right=null;
		}
	}

	public static int leaf_count(Node root){
		if(root == null)
			return 0;
		if(root.left == null & root.right == null)
			return 1;
		return leaf_count(root.left) + leaf_count(root.right);
	}

	public static void main(String args[]){
		BTLeafCount bt = new BTLeafCount();
		bt.root = new Node(5);
		bt.root.left = new Node(6);
		bt.root.right = new Node(7);
		int x = leaf_count(bt.root);
		System.out.println(x);
	}
}

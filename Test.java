import java.util.*;

class BT3{
	Node root;
	static class Node{
		int val;
		Node left,right;
		Node(int val){
			this.val = val;
			left=right=null;
		}
	}

	void bfs(Node root){
		if(root == null) return;
		Deque<Integer> dq = new LinkedList<>();
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(q.size()>0){
			int size = q.size();
			while(size-- > 0){
				Node node = q.poll();
				dq.offerLast(node.val);
				if(node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
			}
			if(dq.size()==1) System.out.print(dq.pollFirst()+" "); //handles first level
			while(dq.size()>0) System.out.print(dq.pollFirst() +" "+dq.pollLast() +" ");
		}
	}


	public static void main(String[] args) {
		BT3 tree = new BT3(); 
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

		tree.bfs(tree.root);
	}
}


package TREE;

public class HeightBalancedTree {
    Node root;
    static class Node { 
        int data; 
        Node left, right; 
        Node(int d){ 
            data = d; 
            left = right = null; 
        } 
    }
    
    int get_height(Node root){
        if(root == null) return 0;
        return 1+ Math.max(get_height(root.left), get_height(root.right));
    }

    boolean isBalanced(Node root){
        if(root == null) return true;
        int left_hight,right_hight;

        left_hight = get_height(root.left);
        right_hight = get_height(root.right);

        if(Math.abs(left_hight-right_hight) <=1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    public static void main(String[] args) {
        HeightBalancedTree tree = new HeightBalancedTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.left.left = new Node(8); 
  
        if (tree.isBalanced(tree.root)) 
            System.out.println("Tree is balanced"); 
        else
            System.out.println("Tree is not balanced"); 
    } 
}




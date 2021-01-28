package Java;
//sum of leaf nodes
// count of leaves
// height
//depth

public class SumLeafBT{
    Node root;
    static class Node{
        Node left,right;
        int data;
        Node(int d){
            data=d;
            left=right=null;
        }
    }


    public static int height_node(Node root){
        if(root==null)
            return -1;
        return Math.max(height_node(root.left), height_node(root.right))+1;
    }

    public static int depth_node(Node root){
        if(root==null)
            return 0;
        return Math.max(depth_node(root.left), depth_node(root.right))+1;
    }

    public static int sum_leaf(Node root){

       if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.data;
        return sum_leaf(root.left) + sum_leaf(root.right);
    }
    public static int count_leaf(Node root){

        if(root == null)
             return 0;
         if(root.left == null && root.right == null)
             return 1;
         return count_leaf(root.left) + count_leaf(root.right);
     }

    public static void main(String args[]){

        SumLeafBT bt = new SumLeafBT();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        System.out.println("SumofLeaves: "+sum_leaf(bt.root));
        System.out.println("Height "+height_node(bt.root));
        System.out.println("Depth "+depth_node(bt.root));
        System.out.println("Count of leaves "+count_leaf(bt.root));

    }


}
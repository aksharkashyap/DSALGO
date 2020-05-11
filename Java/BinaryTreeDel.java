package Java;
import java.util.*;

/*

        1
      /  \
      2   3
    /   \
    4   5
*/


class BinaryTreeDel{

    Node root;

    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

   static void inorder_traversal(Node curr){
        if(curr == null)
            return;
        inorder_traversal(curr.left);
        System.out.print(curr.data+" ");
        inorder_traversal(curr.right);
    }    
    // 1 traversal solution
    static void delete_node(Node curr, int key){
        Queue<Node> Q = new LinkedList<>(); 
        Q.add(curr);
        Node deepest_node=null;
        Node node_to_be_deleted=null;
        Node pLeft=null, pRight=null;
        while(!Q.isEmpty())
        {
            deepest_node = Q.remove();

            if(deepest_node.data == key)
                node_to_be_deleted = deepest_node;
            if(deepest_node.left!=null){
                Q.add(deepest_node.left);
                pLeft = deepest_node;
                pRight = null;    
            }
            if(deepest_node.right!=null){
                Q.add(deepest_node.right);
                pRight = deepest_node;
                pLeft = null;
            }
        }
        if(node_to_be_deleted==null)
            return;
        //setting node_to_be_deleted to deepest node
        node_to_be_deleted.data = deepest_node.data;

        //deleting the pointer of the parent
        if(pLeft!=null)
            pLeft.left = null;
        if(pRight!=null)
            pRight.right = null;
    }

    public static void main(String args[]){

        BinaryTreeDel bt = new BinaryTreeDel();
        Node node1 = bt.new Node(1);
        Node node2 = bt.new Node(2);
        Node node3 = bt.new Node(3);
        Node node4 = bt.new Node(4);
        Node node5 = bt.new Node(5);
        bt.root = node1;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        inorder_traversal(bt.root);
        delete_node(bt.root,9);
        System.out.println("\n");
        inorder_traversal(bt.root);
        //inorder_traversal(bt.root);

    }
}
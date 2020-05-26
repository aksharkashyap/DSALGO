package TREE;
import java.util.*;
//level order traversal using recursion
/*approach 1-> always recur left side first to simulate the left view,
use set to store the height of first visited node,
if height is already there means-> it is not the leftmost node hence dont include it

approach 2-> 
*/

class LeftView{
    Node root;
    int max_level=0;
    static class Node{
        int val;
        Node left,right;
        Node(int x){
            val = x;
            left=right=null;
        }
    }

    void left_view(Node root,int h){
        if(root == null) return;
        if(max_level<h){
            System.out.print(root.val+" ");
            max_level = h;
        }
        left_view(root.left, h+1);
        left_view(root.right, h+1);
    }


    public static void main(String[] args) {
        LeftView tree = new LeftView(); 
        Node root = new Node(20);
        tree.root = root; 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        //root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14);
        tree.left_view(root,1);
    }
}
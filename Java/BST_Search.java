package Java;
import java.util.*;
class BST_Search{
   static Node root;
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static Node insert(Node root, int key){
    
        if(root == null){
                root = new Node(key);
                return root;}
        if(key>root.data)
                root.right = insert(root.right, key);
        else if(key<root.data)
                root.left = insert(root.left, key);
        
        return  root;
    }

    void insr(int key){
        root = insert(root, key);
    }

   static void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
                Node x = q.remove();
                System.out.print(x.data+" ");
                if(x.left!=null)
                    q.add(x.left);
                if(x.right!=null)
                    q.add(x.right);
        }
    }

    public static void main(String args[]){
       BST_Search bst = new BST_Search();
        root = null;
        bst.insr(30);
        bst.insr(50);
       // System.out.println(insert(bst.root, 50));
        System.out.println(root.right.data);

       

    }


}
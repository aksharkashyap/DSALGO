package TREE;
import java.util.*;

/*
Note -> if there are multiple bottom-most nodes for a 
horizontal distance from root, then print the later one in level traversal

soln -> for that , just recur for the right tree first
*/
class BottomView {
    List<Integer> list = new ArrayList<>();
    Node root;
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int x) { val = x; }
    }
    int max_h;
    int put;
    void vertical_dfs(Node root,int n,int vertical_line, int h){
        if(root == null) return;
        if(n == vertical_line){
            if(h>max_h){
                max_h = h;
                put = root.val;
            }
        }
        vertical_dfs(root.right,n+1,vertical_line, h+1); // goto right first to ensure if(there are two elements then second one will be taken)
        vertical_dfs(root.left,n-1,vertical_line, h+1);
    }
    
    int maxHD = Integer.MIN_VALUE,minHD = Integer.MAX_VALUE;
    void horizontal_distance(Node root,int n){
        if(root == null) return;
        if( n > maxHD) maxHD = n;
        if( n < minHD) minHD = n;
        horizontal_distance(root.left,n-1);
        horizontal_distance(root.right,n+1);
    }

    void bottomview(Node root){
        horizontal_distance(root, 0); //calculate horizontal distance
       
        for(int vl=minHD;vl<=maxHD;vl++){
            max_h = Integer.MIN_VALUE;
            put = 0;
            vertical_dfs(root, 0, vl, 0);
            list.add(put);
        }      
    }
    public static void main(String[] args) {

        BottomView tree = new BottomView(); 
        Node root = new Node(20);
        tree.root = root; 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14);
        tree.bottomview(root);
        System.out.print(tree.list);
    }
}
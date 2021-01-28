package TREE;
import java.util.*;
class TopView {

    List<Integer> list = new ArrayList<>();
    TreeNode root;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int min_h;
    int put;
    void vertical_dfs(TreeNode root,int n,int vertical_line, int h){
        if(root == null) return;
        if(n == vertical_line){
            if(h<min_h){
                min_h = h;
                put = root.val;
            }
        }
        vertical_dfs(root.left,n-1,vertical_line, h+1);
        vertical_dfs(root.right,n+1,vertical_line, h+1);
    }
    
    int maxHD = Integer.MIN_VALUE,minHD = Integer.MAX_VALUE;
    void horizontal_distance(TreeNode root,int n){
        if(root == null) return;
        if( n > maxHD) maxHD = n;
        if( n < minHD) minHD = n;
        horizontal_distance(root.left,n-1);
        horizontal_distance(root.right,n+1);
    }

    void topview(TreeNode root){
        horizontal_distance(root, 0); //calculate horizontal distance
       
        for(int vl=minHD;vl<=maxHD;vl++){
            min_h = Integer.MAX_VALUE;
            put = 0;
            vertical_dfs(root, 0, vl, 0);
            list.add(put);
        }      
    }

    public static void main(String[] args) {
        TopView tree = new TopView(); 
        tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.right = new TreeNode(4); 
        tree.root.left.right.right = new TreeNode(5); 
        tree.root.left.right.right.right = new TreeNode(6); 
        
        tree.topview(tree.root);
        System.out.print(tree.list); 
    }

}
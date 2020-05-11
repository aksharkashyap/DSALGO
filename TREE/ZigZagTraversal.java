package TREE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ZigzalTraversal {
    public class TreeNode {
        int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    int find_depth(TreeNode root){// to create list levelwise
        if(root == null) return 0;
        int left = find_depth(root.left);
        int right = find_depth(root.right);
        return 1+Math.max(left,right);
    }
    void solve(TreeNode root,int depth,List<Integer>[] mylist){    //adds nodes levelwise in mylist
        if(root == null || root.left == null && root.right==null) return;
        
      
        if(root.left!=null) mylist[depth].add(root.left.val);
        if(root.right!=null) mylist[depth].add(root.right.val);
        
        solve(root.left,depth+1,mylist);
        solve(root.right,depth+1,mylist);
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        int max_level = find_depth(root);
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        List<Integer>[]mylist = new ArrayList[max_level];
        for(int i=0;i<max_level;i++)
            mylist[i] = new ArrayList<>();
        mylist[0].add(root.val);
        
        solve(root,1,mylist);
        
        for(int i=0;i<max_level;i++){//most imp step here -> alternatively reverse the list-levelwise to create zigzag fashion
            if(i%2 !=0) Collections.reverse(mylist[i]); 
        }
            
        for(int i=0;i<max_level;i++)
            list.add(mylist[i]);
        return list;
    }
}
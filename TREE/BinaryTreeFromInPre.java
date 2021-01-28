package TREE;

import java.util.HashMap;
import java.util.Map;

//binary tree from in order and preorder
//only diff is that we have to recurr for left subtree first
//prune preorder arr from left
public class BinaryTreeFromInPre { 
    int idx=0;
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode solve(TreeNode root, int[]pre,int[]in , int start, int end, Map<Integer,Integer> map){
        if(start>end) return null;
        root = new TreeNode(pre[idx++]);
        int pos = map.get(root.val);
        root.left = solve(root, pre, in, start,pos-1, map);
        root.right = solve(root, pre, in, pos+1,end, map);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeFromInPre bt = new BinaryTreeFromInPre();
        int[]preorder = {3,9,20,15,7};
        int[]inorder = {9,3,15,20,7};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        
        TreeNode root = bt.new TreeNode(0);
        root.left = bt.solve(root.left,preorder,inorder,0,preorder.length-1,map);
        bt.tree_print(root.left);

    }

    void tree_print(TreeNode root){
        if(root == null) return;
        System.out.print(root.val+" ");
        tree_print(root.left);
        tree_print(root.right);
    }

}
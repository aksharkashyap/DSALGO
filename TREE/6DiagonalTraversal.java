package TREE;
import TREE.TreeUtil.TreeNode;
import java.util.*;

class DiagonalTraversal {

   static Map<Integer,List<Integer>> map;
    static void solve(TreeNode root, int n){
        if(root == null) return;
        if(map.containsKey(n)){
            map.get(n).add(root.val);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(n,list);
        }
        //left to right side diagonal
        solve(root.left,n+1); //increase the slant hight
        solve(root.right,n+0); //if u go right then this is a diagonal movement so slant height remains same


        /* right to left diagonal
        solve(root.left,n+0);
        solve(root.right,n+1);*/
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        map = new HashMap<>();
        solve(root,0);
        for(List<Integer> m : map.values()) System.out.println(m);
    }
}
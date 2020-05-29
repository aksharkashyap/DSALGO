package TREE;
import java.util.*;

public class TreeUtil {
    TreeNode node1,node2,node3,node4,node5,node6;
    TreeNode root;
    static class TreeNode { 
        int val; 
        TreeNode left, right; 
        TreeNode(int d){ 
            val = d; 
            left = right = null; 
        } 
    }

    TreeUtil(){
        node1 = new TreeNode(1); 
        node2 =  new TreeNode(2); 
        node3 = new TreeNode(3); 
        node4 = new TreeNode(4); 
        node5 = new TreeNode(5); 
        node6 = new TreeNode(6); 
    
        root = node1;
        root.left = node2;
        root.right = node3;
        root.left.left = node4;
        root.left.right = node5;
        root.left.left.left = node6;
    }

    void tree_preorder_print(TreeNode root){
        if(root == null) return;
        System.out.print(root.val+" ");
        tree_preorder_print(root.left);
        tree_preorder_print(root.right);
    }

    void level_order_traversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() !=0){
            TreeNode x = queue.poll();
            System.out.print(x.val+" ");
            if(x.left !=null) queue.offer(x.left);
            if(x.right !=null) queue.offer(x.right);
        }
    }
}
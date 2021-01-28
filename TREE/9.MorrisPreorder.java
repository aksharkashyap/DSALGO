package TREE;
import TREE.TreeUtil.TreeNode;

class MorrisPreorder {
    
    void morrisPreorder(TreeNode root){
        if(root == null) return;
        TreeNode curr = root;
        TreeNode pre;
        while(curr != null){
            if(curr.left == null){
                System.out.print(curr.val +" ");
                curr = curr.right;
            }
            else{
                pre = curr.left;
                while(pre.right != null && pre.right != curr) pre = pre.right;
                if(pre.right == null){
                    System.out.print(curr.val+" "); /*the difference (pre/in morris) 
                    is here we r printing node in the first visit(ie. pre.right == null)
                    on the other hand in morris inorder we print the node on the second visit(denoting that left side is visited already)
                    */
                    pre.right = curr;
                    curr = curr.left;
                }
                else{
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
    }
}

package TREE;
import TREE.TreeUtil.TreeNode;

class MorrisInorder {
    void traverse(TreeNode root){
        TreeNode pre,curr;
        curr = root;
        while(curr!=null){
            if(curr.left == null){
                System.out.print(curr.val);
                curr = curr.right;
            }else{
                pre = curr.left; // go to the left 
                while(pre.right!=null && pre.right!=curr) pre = pre.right; //keep going to right 
                if(pre.right == null){
                    pre.right = curr; //make a link
                    curr = curr.left; //now shift the current to the left
                }else{
                    pre.right = null; // break the link 
                    System.out.print(curr.val);  // print the data
                    curr = curr.right; // move to the right child
                }
            }
        }
    }
}
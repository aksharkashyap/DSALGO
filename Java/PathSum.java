package Java;
import java.util.*;

class PathSum{
    TreeNode root;
    class TreeNode{
        TreeNode left,right;
        int val;
        TreeNode(int d)
        {
            val= d;
            left=right=null;
        }
    }
    boolean check=false;
    boolean helper(TreeNode root, int sum, int countSum, Stack<Integer> stack,TreeNode parent)
    {       
        //pre order
        
        if(root == null && parent.left == null && parent.right == null)
            {
                if(countSum == sum)
                    //got the answer
                    {
                        //System.out.print("YUP GOT the answer");
                        return check=true;
                    }
                if(countSum!=sum && !stack.isEmpty())
                {   
                     countSum -= stack.pop();
                     return false;
                }
                return false;
            }
        if(root == null && (parent.left!=null || parent.right!=null))
            {
                return false;
            }
        stack.push(root.val);
        countSum+=root.val; 
        parent = root; 
        helper(root.left,sum,countSum,stack,parent);
        helper(root.right,sum,countSum,stack,parent);
    return check;

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        int countSum=0;
        TreeNode parent=root;
        Stack<Integer> stack = new Stack<>();  
        if(root == null) return false;
        boolean c = helper(root,sum,countSum,stack,parent);
        if(c) return true;
        return false;
        //System.out.println(c);   
    }




    public static void main(String args[])
    {

        PathSum ps = new PathSum();
        TreeNode node5 = ps.new TreeNode(5);
        TreeNode node10 = ps.new TreeNode(10);
        TreeNode node12 = ps.new TreeNode(12);
        TreeNode node8 = ps.new TreeNode(8);
        TreeNode node1 = ps.new TreeNode(1);
        ps.root = node5;
        node5.left = node10;
        node5.right = node1;
        node10.left = node8;
        node10.right = node12;
        System.out.println(ps.hasPathSum(ps.root,23));
       // System.out.print("\n"+check+"\n\n");
    }


}
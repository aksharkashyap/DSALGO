package TREE;
/*
https://www.youtube.com/watch?v=12aMTS0L6WI
Iterative Pre,In,Post traversal using 3 states simulation


if(state == 1) top.state++ & addtoPreorderList(top) & Push(top.left) if NOTNULL
if(state == 2) top.state++ & addtoInorderList(top) & push(top.right) if NOTNULL
if(state == 3) addtoPostorderList(top) & pop(top)

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class IterativePreInPost {
    static class TreeNode { 
        int val; 
        TreeNode left, right; 
        TreeNode(int d){ 
            val = d; 
            left = right = null; 
        } 
    }

    static class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node, int state){
            this.state = state;
            this.node = node;
        }
    }

    static void inprepost(TreeNode root){
        List<Integer> in,pre,post;
        in = new ArrayList<>();
        pre = new ArrayList<>();
        post = new ArrayList<>();
        //------------------------
        if(root == null) return;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,1));
        
        while(!stack.isEmpty()){
            Pair top = stack.peek();
            if(top.state == 1){ //pre order (1 represents node has been encounterd 1st time)
                pre.add(top.node.val);
                top.state++;
                if(top.node.left != null) stack.push(new Pair(top.node.left,1)); //add left child 
            }
            else if(top.state == 2){ //inorder (2-> node encountered 2nd time)
                in.add(top.node.val);
                top.state++;
                if(top.node.right != null) stack.push(new Pair(top.node.right,1)); //add right child 
            }
            else{ //postorder (3-> node encountered 3rd time)
                post.add(top.node.val);
                stack.pop();
            }
        }

        System.out.println("Inorder "+ in);
        System.out.println("Preorder "+ pre);
        System.out.println("Postorder "+ post);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        inprepost(node1);
    }
}
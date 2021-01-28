package TREE;
import java.util.*;

class IterativeDFS{
    static class TreeNode { 
        int val; 
        TreeNode left, right; 
        TreeNode(int d){ 
            val = d; 
            left = right = null; 
        } 
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        postOrderTraversal2(node1);
    }
    //inorder traversal
    static void inorder(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        while(stack.size()>0 || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        System.out.print(list);
    }
    //preorder traversal
    static void preorder(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        while(stack.size()>0 || root!=null){
            while(root!=null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        System.out.print(list);
    }
    //preorder traversal2
    static void preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if(root.right != null) stack.add(root.right);
            if(root.left != null) stack.add(root.left);
        }
        System.out.print(list);
    }

    //postOrder traversal using 2 stacks
    static void postOrderTraversal(TreeNode root){
        if(root == null) return;
        Deque<TreeNode> visited = new ArrayDeque<>();
        Deque<TreeNode> processStack = new ArrayDeque<>();
        processStack.push(root);
        TreeNode curr;
        while(!processStack.isEmpty()){
            curr = processStack.pop();
            visited.push(curr);
            if(curr.left != null) processStack.push(curr.left);
            if(curr.right != null) processStack.push(curr.right);
        }

        while(!visited.isEmpty()){
            System.out.print(visited.pop().val);
        }
    }

    //postorder traversl using 1 stack
    static void postOrderTraversal2(TreeNode root){
        if(root == null) return;
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(true){
            while(root!=null){ //visit left
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) break;
            root = stack.pop();
            if(!stack.isEmpty() && stack.peek() == root) root = root.right; //indicates left visited now go to RIGHT
            else{
                //left and right both visited now print the root
                list.add(root.val);
                root = null; //it is important step (in the next iteration we will pick a topmost node if available)
            }
        }
        System.out.print(list);
    }
}
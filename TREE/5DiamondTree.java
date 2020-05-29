package TREE;

import TREE.TreeUtil.TreeNode;
import java.util.Queue;
import java.util.LinkedList;

class DiamondTree {
    static Queue<TreeNode> queue;
    static TreeNode solve(TreeNode root, int n, int h, int N){
        if(h == N+1) return null;
        root = new TreeNode(n);
        if(h == N) queue.add(root);
        root.left = solve(root.left, n*2,h+1,N);
        root.right = solve(root.right, n*2+1,h+1,N);
        return root;
    }

    static void merge(){
        while(queue.size() != 1){
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();
            a.right =  new TreeNode(a.val + b.val);
            b.left = a.right;
            queue.offer(a.right);
        }
    }
    
    static void level_order_traversal(TreeNode root, int k){
        if(root == null) return;
        queue.clear();  //because merge operation ke time last node pada hua hi esme
        queue.offer(root);
        int level = k-1;
        while(level-- >0){  //print upto k-1 level
            int size = queue.size();
            while(size-- >0){
              TreeNode x = queue.poll();
              System.out.print(x.val+" ");
              if(x.left !=null) queue.offer(x.left);
              if(x.right !=null) queue.offer(x.right);
         }
        System.out.println();
     }

     while(queue.size()>1){
        int size = queue.size();
        while(size-- >0){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            System.out.print(first.val+" " + second.val +" ");
            queue.add(first.right);
            size = size-2;
        }
        System.out.println();
     }
     System.out.print(queue.poll().val +"\n");  // print the last node

    }
      
    public static void main(String[] args) {
        queue = new LinkedList<>();
        int N=3;
        TreeNode dummy = new TreeNode(0);
        dummy.left = solve(dummy.left, 1,1,N);
        merge();
        level_order_traversal(dummy.left,N);
       
    }
}
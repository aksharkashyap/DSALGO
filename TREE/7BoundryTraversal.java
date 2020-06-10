package TREE;

class BoundryTraversal {
    TreeNode a,b;

    static class TreeNode { 
        int val; 
        TreeNode left, right; 
        TreeNode(int d){ 
            val = d; 
            left = right = null; 
        } 
    }
  
    // A function to print all left boundary nodes, except a leaf node 
    void left(TreeNode root){
        if(root == null) return;
        
        if(root.left !=null){
            System.out.print(root.val +" ");
            left(root.left);
        }
        else if(root.right !=null){
            System.out.print(root.val +" ");
            left(root.right);
        }
    }

    // A function to print all bottom boundary nodes
    void bottom(TreeNode root){
        if(root == null) return;
        bottom(root.left);
        if(root.left==null && root.right == null){
            System.out.print(root.val +" ");
        }
        bottom(root.right);
    }

    // A function to print all right boundary nodes, except a leaf node 
    void right(TreeNode root){
        if(root == null) return;
        
        if(root.right !=null){
            right(root.right);
            System.out.print(root.val +" "); //bottom up order print
        }
        else if(root.left !=null){
            right(root.left);
            System.out.print(root.val +" ");
        }
    }

    void solve(TreeNode root){
       if(root == null) return;
       System.out.print(root.val +" ");
       left(root.left);
       bottom(root);
       right(root.right);
    }

    public static void main(String[] args) {
        BoundryTraversal tree = new BoundryTraversal(); 
        
        TreeNode root = new TreeNode(20); 
        root.left = new TreeNode(8); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(12); 
        root.left.right.left = new TreeNode(10); 
        root.left.right.right = new TreeNode(14); 
        root.right = new TreeNode(22); 
        root.right.right = new TreeNode(25); 
        tree.solve(root);        
    }
}
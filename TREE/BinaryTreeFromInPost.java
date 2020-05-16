package TREE;

//binary tree from inorder and post order
/**
 * sol->    postorder for root
 *          inorder for left and right
 * 
 note-> this approach is taking too long 
 we need to further imporve this->
 this could be the 1st solution for interview purpose
 */
class BinaryTreeFromInPost{
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int get_root(int post[] ,int in[],int start, int end){
       int m = post.length;

        for(int i=m-1;i>=0;i--){    //post
            for(int j=start;j<end;j++){   //in
                if(post[i] == in[j]) return j;
            }
        }
        return -1;
    }

    TreeNode solve(int[]in, int[]post,int i, int j,TreeNode root){
        if(i>=j) return null;
        int mid = get_root(post,in,i,j);
        
        root = new TreeNode(in[mid]);
        root.left = solve(in, post, i, mid, root);
        root.right = solve(in, post, mid+1, j, root); 

        return root;
    }

    void tree_print(TreeNode root){
        if(root == null) return;
        System.out.print(root.val+" ");
        tree_print(root.left);
        tree_print(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeFromInPost b = new BinaryTreeFromInPost();
        int []in = {4,8,2,5,1,6,3,7};
        int []post = {8,4,5,2,6,7,3,1};
        TreeNode root = b.new TreeNode(0);
        root.left = b.solve(in,post,0,post.length,root.left);
       
        b.tree_print(root.left);
    }
}
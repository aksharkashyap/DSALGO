package TREE;

/*Tushar roy video
Return the size of the largest sub-tree which is also a BST
https://youtu.be/4fiDs7CCxkc
*/

class LargsetBSTSubtreeInBinaryTree{
    
    static int largestBst(Node root)
    {
        int[] ans = go(root);
        return ans[1]; //arr [isBST,size,min,max]
    }
    
    static int[] go(Node root){
        if(root == null) return new int[]{1,0,Integer.MAX_VALUE,Integer.MIN_VALUE};
        if(root.left == null && root.right == null) return new int[]{1,1,root.data,root.data};

        int[]left = go(root.left);
        int[]right = go(root.right);

        if(left[0]==0 || right[0]==0 || root.data <= left[3] || root.data >= right[2]) 
            return new int[]{0,Math.max(left[1],right[1]),Integer.MAX_VALUE,Integer.MIN_VALUE};

        int min = (root.left==null ? root.data : left[2]);
        int max = (root.right==null ? root.data : right[3]);
        return new int[]{1,left[1]+right[1]+1,min,max};
    }
    
}
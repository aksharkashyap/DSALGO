package TREE;
//is BST contains dead end
//https://www.geeksforgeeks.org/check-whether-bst-contains-dead-end-not/

class BSTDeadEnd
{
    public static boolean isDeadEnd(Node root)
    {
        return solve(root,1,Integer.MAX_VALUE);
    }
    
    static boolean solve(Node root, int lo, int hi){
        if(root == null) return false;
        if(hi-root.data < 2 && root.data-lo < 2) return true;
        return solve(root.left,lo,root.data) || solve(root.right,root.data,hi);
    }
    
}
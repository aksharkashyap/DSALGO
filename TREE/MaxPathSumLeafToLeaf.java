package TREE;

class MaxPathSumLeafToLeaf{
    int res  = Integer.MIN_VALUE;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    int solve(TreeNode root){
        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);
        int temp =  Math.max(left, right)+root.val;
        if(root.left == null && root.right == null)
            temp = Math.max(temp, root.val);
        int ans = Math.max(temp,left+right+root.val);
        res = Math.max(ans, res);
        return temp;
    }   
}

}
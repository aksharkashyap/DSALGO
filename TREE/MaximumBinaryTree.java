/*Time complexity : O(n^2) The function construct is called n times. At each level of the recursive tree, 
we traverse over all the nn elements to find the maximum element. In the average case, 
there will be a \log nlogn levels leading to a complexity of O\big(n\log n\big)O(nlogn). 
In the worst case, the depth of the recursive tree can grow upto nn, which happens in the case of a 
sorted numsnums array, giving a complexity of O(n^2)O(n 


Space complexity : O(n). The size of the setset can grow upto n in the worst case. 
In the average case, the size will be \log nlogn for nn elements in numsnums, 
giving an average case complexity of O(\log n)O(logn)


Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
*/
package TREE;
class Solution {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int find_max_pos(int nums[],int start, int end){
        int max = Integer.MIN_VALUE;
        int pos = -1;
        for(int i=start;i<=end;i++){
            if(max < nums[i]){
                max = nums[i];
                pos = i;
            }
        }
        return pos;
    }
    
    TreeNode solve(TreeNode root, int nums[], int start, int end){
        
        while(start<=end){
            int mid = find_max_pos(nums,start,end);
            root = new TreeNode(nums[mid]);
            root.left = solve(root,nums,start, mid-1);
            root.right = solve(root,nums,mid+1,end);
            return root;
        }
        return null;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int end = nums.length;
        int start = 0;
        TreeNode root = new TreeNode(0);
        root.left = solve(root.left,nums,start,end-1);
        return root.left;
    }
}
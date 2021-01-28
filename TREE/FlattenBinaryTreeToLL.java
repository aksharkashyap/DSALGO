package TREE;
import TREE.TreeUtil.TreeNode;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

class FlattenBinaryTreeToLL {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
}
/** input
 *  1
   / \
  2   5
 / \   \
3   4   6
 */

 /*output (looks like flattened preorder)
 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
 */
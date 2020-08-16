package TREE;
import TREE.TreeUtil.TreeNode;
import java.util.*;

 class Codec {
    //use upper and lower boundaries to check whether we should add null
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode deserialize(Queue<String> q, int lower, int upper) {
        if (q.isEmpty()) return null; //for the last leaf node
        String s = q.peek(); //only peek beacuse if it doesnt satisfy bst then we return null from here, letter ww will use this value
        int val = Integer.parseInt(s);
        if (val < lower || val > upper) return null;
        q.poll(); //bst satisfied so we will use this value here only so pop from the list
        TreeNode root = new TreeNode(val);
        root.left = deserialize(q, lower, val);
        root.right = deserialize(q, val, upper);
        return root;
    }
}
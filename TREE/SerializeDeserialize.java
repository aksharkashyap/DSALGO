package TREE;
import TreeUtil.TreeNode;
import java.util.*;

class SerializeDeserialize{
    void se_help(StringBuilder sb, TreeNode root){
        if(root == null){sb.append("#,"); return;}
        sb.append(root.val+",");
        se_help(sb,root.left);
        se_help(sb,root.right);
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder("");
        se_help(sb,root);
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
    
    TreeNode de_help(TreeNode root, Queue<String> remNodes){
        String str_node = remNodes.poll();
        if(str_node.equals("#")) return null;
        root = new TreeNode(Integer.valueOf(str_node));
        root.left = de_help(root.left,remNodes);
        root.right = de_help(root.right,remNodes);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        Queue<String> remainingNodes = new LinkedList<>();
        for(String s : str) remainingNodes.offer(s);
        TreeNode root = new TreeNode(0);
        root.left = de_help(root.left,remainingNodes);
        return root.left;
    }
}
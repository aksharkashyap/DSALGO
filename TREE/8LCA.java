package TREE;

import java.util.ArrayList;
import java.util.List;
import TREE.TreeUtil.TreeNode;

/* dfs+hasmap, now traverse hashmap to 
 * check we can get both the p and q from that node, if got the node then update answer 
 * if node.height > ans.height */

class LCA {
    boolean flag1,flag2;
    class Pair{
        int height;
        TreeNode node;
        Pair(TreeNode n, int h){height = h; node = n;}
    }
    void dfs(TreeNode root, List<Pair> v, int h){
        if(root == null) return;
        v.add(new Pair(root,h));
        dfs(root.left,v,h+1);
        dfs(root.right,v,h+1);
    }
    
    void findNode(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return;
        if(flag1 && flag2) return;
        if(root == p) flag1 = true;
        if(root == q) flag2 = true;
        findNode(root.left,p,q);
        findNode(root.right,p,q);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Pair> list = new ArrayList<>();
        dfs(root,list,0);
        Pair ans = null;
        for(Pair pair : list){
            flag1=flag2=false;
            findNode(pair.node,p,q);
            if(flag1 && flag2)
                if(ans == null || ans.height < pair.height) ans = pair;
        }
        return ans.node;
    }
}
package TREE;

import java.util.ArrayList;
import java.util.List;

//avg of levels in binary tree


public class AvgOfLevels {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  
 
public class Solution {
    public List < Double > averageOfLevels(TreeNode root) {
        List < Integer > count = new ArrayList < > ();
        List < Double > res = new ArrayList < > ();
        
        average(root, 0, res, count);
        
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }
    
    public void average(TreeNode root, int depth, List < Double > sum, List < Integer > count) {
        if (root == null) return;
        if (depth < sum.size()) {  //agar equal to nahi hai means us same depth pe aur bhi elements hi so add them into sum and counter bhi bdha do
            sum.set(depth, sum.get(depth) + root.val);
            count.set(depth, count.get(depth) + 1);
        } else {
            sum.add(1.0 * root.val);
            count.add(1);
        }
        average(root.left, depth + 1, sum, count);
        average(root.right, depth + 1, sum, count);
    }
}
}}

/**
 * class Solution {
    
    public void dfs(TreeNode root,Map<Integer,Double> map,Map<Integer,Integer> count, int depth){
        if(root == null) return;
        double val = (double) root.val;
        double m = map.getOrDefault(depth,0.00);
        map.put(depth,(m+val));
        count.put(depth,count.getOrDefault(depth,0)+1);
        dfs(root.left,map,count,depth+1);
        dfs(root.right,map,count,depth+1);
    }
    
    
    public List<Double> averageOfLevels(TreeNode root) {
     
        Map<Integer,Double> map = new HashMap<>();
        Map<Integer,Integer> count = new HashMap<>();
        dfs(root,map,count,1);
    
        List<Double> list = new ArrayList<>();
       
        for(Map.Entry<Integer,Double> m : map.entrySet()){
            
            list.add(m.getValue() / count.get(m.getKey()));
        }
        
        return list;
    }
}
 */
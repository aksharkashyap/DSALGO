//https://leetcode.com/problems/edit-distance/discuss/846187/JAVA-Memoization
package DP.EditDistance;
import java.util.Map;
import java.util.HashMap;
//Method 1
class EditDistance1 {
    Map<String,Integer> cache = new HashMap<>();
    public int minDistance(String word1, String word2) {
        String key = word1 + "#" + word2;
        if(cache.containsKey(key)) return cache.get(key);
        if(word1.equals(word2)) return 0;
        if(word1.length() == 0) return word2.length();  //only insert operation you can perform
        if(word2.length() == 0) return word1.length();  //only delete operation you can perform 
        
        if(word1.charAt(0) == word2.charAt(0)){
            int min = minDistance(word1.substring(1),word2.substring(1)); //no need of any operation
            cache.put(key,min);
            return min;
        }
        //choose minimum among insert,delete and replace
        int insert = minDistance(word1,word2.substring(1));
        int delete = minDistance(word1.substring(1),word2);
        int replace = minDistance(word1.substring(1),word2.substring(1));
        
        int min = Math.min(Math.min(insert,delete),replace)+1;
        cache.put(key,min);
        
        return min;
    }
}

//method 2 (fast)
class EditDistance2 {
    public int minDistance(String word1, String word2) {
      int m = word1.length(), n = word2.length();
      int[][]dp = new int[m+1][n+1];
      return editDistance(word1,word2,m-1,n-1,dp);
    }
    
    int editDistance(String word1, String word2,int i, int j, int[][]dp){
        
        if(i<0 && j<0) return 0; //all characters are matched
        if(i<0) return j+1;  //only insert operation you can perform
        if(j<0) return i+1;  //only delete operation you can perform 
        if(dp[i][j] != 0) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)) return dp[i][j] = editDistance(word1,word2,i-1,j-1,dp);
      
        //choose minimum among insert,delete and replace
        int insert = editDistance(word1,word2,i,j-1,dp);
        int delete = editDistance(word1,word2,i-1,j,dp);
        int replace = editDistance(word1,word2,i-1,j-1,dp);
        
        return dp[i][j] = Math.min(Math.min(insert,delete),replace)+1;
    }
}
package DP.Other;
import java.util.*;

class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s,wordDict, new HashMap<>());
    }
    
    List<String> dfs(String s, List<String> wordDict, Map<String,List<String>> dp){
        
        if(dp.containsKey(s)) return dp.get(s);
        
        List<String> res = new ArrayList<>();
        
        if(s.length()==0){
            res.add("");
            return res;
        }
        
        for(String word : wordDict){
            if(s.startsWith(word)){
                List<String> subList = dfs(s.substring(word.length()),wordDict,dp);
                for(String sub : subList) res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }    
        }
        dp.put(s,res);
        return res;
        
    }
}
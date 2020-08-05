package DP;
import java.util.*;

class ConcatenatedWords {
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        //System.out.print(Arrays.toString(words));
        Set<String> seen = new HashSet<>();
        List<String> ansList = new ArrayList<>();
        
        for(String word : words){
            Map<String,Boolean> dp = new HashMap<>();
            if(wordBreak(word,seen,dp)) ansList.add(word);
            seen.add(word);
        }
        return ansList;
    }
     
    boolean wordBreak(String word,Set<String> seen, Map<String,Boolean> dp){
        if(seen.isEmpty()) return false;
        if(word.length()==0) return true;
        if(dp.containsKey(word)) return dp.get(word);
        for(int i=1;i<=word.length();i++){
            String next = word.substring(i);
            if(seen.contains(word.substring(0,i)) && wordBreak(next,seen,dp)){
               dp.put(next,true);
               return true;
            }
        }
        dp.put(word,false);
        return false;
    }
    
}

/**
 * see word break 1 and 2 as well
 */
package DP;
import java.util.*;
/**
Given a list of words (without duplicates), 
please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in 
the given array.
 */
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

 /**
  * Do you still remember how did you solve this problem? https://leetcode.com/problems/word-break/

If you do know one optimized solution for above question is using DP, 
this problem is just one more step further. We iterate through each word and see if it 
can be formed by using other words.
Of course it is also obvious that a word can only be formed by words shorter than it. 
So we can first sort the input by length of each word, and only try to form one word by using words
in front of it.
  */
import java.util.*;

class Test{
   class Solution {
      public int ladderLength(String bW, String eW, List<String> wordList) {
          
          int count=0;
          int j=0;
          while(j++<5){
              int count_bW[] = new int[26];
              for(int i=0;i<bW.length();i++) count_bW[bW.charAt(i)-97]++;
              
              for(String word : wordList){
                  int count_word[] = new int[26];
                  for(int i=0;i<word.length();i++) count_word[word.charAt(i)-97]++;
                  int diff=0;
                 
                  for(int i=0;i<26;i++){
                      
                      if(count_word[i] != count_bW[i]) diff++;
                      if(diff>1) break;
                  }
                  if(diff==1){
                       
                      bW = word;
                      count++;
                      break;
                  }
              }
          }
          
          return count;
      }
  }
  
  /*
  for hit find the word which differ in the frequency only at one place
  hot (is it equal to endWord -> cont)
  dot (is it equal to endWord -> cont)
  dog (is it equal to endWord -> cont)
  cog (is it equal to endWord -> stop)
      
  */
}

/**
 * iterative inorder,postoder,pre
 */
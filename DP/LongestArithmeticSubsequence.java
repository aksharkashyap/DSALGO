package DP;
import java.util.*;

/**
 * Brute force approach(exponential)
 * Generate all possible subsequence and then check for the required combination 
 */

class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] A) {
        List<List<Integer>> v = new ArrayList<>();
        v.add(new ArrayList<>());
        
        for(int i=0;i<A.length;i++){
            int size = v.size();
            for(int j=0;j<size;j++){
                List<Integer> sublist = new ArrayList<>(v.get(j));
                sublist.add(A[i]);
                v.add(sublist);
            }
        }
        
        int max = 1;
        
        for(List<Integer> subList : v){
            int size = subList.size();
            if(size!=1 && size>max){
                int i=0;
                int val=-1; boolean flag=true;
                while(size>1){
                  int a = subList.get(i); size--;
                  int b = subList.get(i+1);
                  if(val== -1)val = Math.abs(a-b);
                  else if(val != (a-b)){flag= false; break;}
                  i++;
                }
                if(flag) max = Math.max(subList.size(),max);
            }
        }
        return max;
    }
}
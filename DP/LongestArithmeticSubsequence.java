package DP;
import java.util.*;
/**
 * Given an array A of integers, return the length of the longest arithmetic subsequence in A.
Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] 
with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and 
that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).
 */

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

//dp
//Using DP approach and 2D array to store DP results. dp[i][j] means sequence of length i and with difference j. Catch - because of the problem restrictions we know that difference can vary from -10.000 to +10.000, so allocate 20.001 elements array and apply +10.000 shift so we can use difference as an index.

//O(n) time - need to scan for every element "difference" times. Because we know max and min for difference it can be count as constant. O(n) memory - for DP results array will be proportional to number of elements, again 20.0001 second dimension is constant.
class LAS{
    public int longestArithSeqLength(int[] A) {
        int res = 0;
        //array to keep differences and sequence length. dp[i][j] meaning is
        //sequence of length i and difference j. Because of the problem restrictions we can
        //allocate array for differences beforehand (0 <= A[i] <= 10000)
        int[][] dp = new int[A.length][20001];
        
        //set the right border of the sequence
        for (int i = 0; i < A.length; i++) {
            //start checking sequences by moving left border, so sequences from 0..i to i-1..i will
            //be checked
            for (int j = 0; j < i; j++) {
                //get the difference i and j elements, apply 10.000 shift so we can use array indexes 
                int dif = (A[i] - A[j]) + 10000;
                //check if we have seen this difference before, if not - make it of length 2 (i and j makes at least
                //2 elements sequence)
                dp[i][dif] = (dp[j][dif] == 0 ? 1 : dp[j][dif]) + 1;
                //keep running max so we dont have to scan our dp matrix at the end
                res = Math.max(res, dp[i][dif]);
            }
        }
        return res;
    }
}
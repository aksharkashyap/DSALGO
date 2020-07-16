package DP;

import java.util.Arrays;

/***
 * A sequence of numbers is called a wiggle sequence if the differences between
 * successive numbers strictly alternate between positive and negative
 */

public class WiggleSequence {
        int max = Integer.MIN_VALUE;
        void solve(int start, int end, int lastWiggle,int nums[],boolean operation, int size){
            if(start >= end){
                max = Math.max(max,size);
                return;
            }
            
            for(int i=start;i<end;i++){
                if(operation && nums[i]>lastWiggle 
                   || !operation && nums[i]<lastWiggle)
                   solve(i+1,end,nums[i],nums,!operation,size+1); 
            }
        }
        
        public int wiggleMaxLength(int[] nums) {
            if(nums.length == 0) return 0;
            int end = nums.length;
            for(int i=0;i<end;i++){
                solve(i+1,end,nums[i],nums,false,1);
                solve(i+1,end,nums[i],nums,true,1);
            }
            return max;
        }
}

//memoization

class wiggleSequence2 {
    
    int[][]dp;   //dp[index][operation]
    int max = Integer.MIN_VALUE;
    int solve(int start, int end, int lastWiggle,int nums[],boolean operation){
        if(start >= end) return 0;
        int bool = operation ? 1 : 0;
        if(dp[start][bool] != -1) return dp[start][bool];
        for(int i=start;i<end;i++){
            if(bool==0 && nums[i]<lastWiggle 
               || bool==1 && nums[i]>lastWiggle){
                int m = solve(i+1,end,nums[i],nums,!operation)+1;
                dp[start][bool] = Math.max(dp[start][bool],m);
            }
        }
        return dp[start][bool];
    }
    
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0) return 0;
        int end = nums.length;
        dp = new int[2*end][2];
        for(int rows[] : dp) Arrays.fill(rows,-1);
        int m = Integer.MIN_VALUE;
        for(int i=0;i<end;i++){
           m  = Math.max(m,solve(i+1,end,nums[i],nums,false)+1);
           m  = Math.max(m,solve(i+1,end,nums[i],nums,true)+1);
        }
        return m;
    }
}
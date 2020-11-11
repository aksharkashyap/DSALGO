package DP.KnapsackVariation;
public class TargetSum {
/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, 
S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.
*/
    private int count_subset_sum(int weight[], int W, int n){
        int dp[][] = new int[n+1][W+1];

        dp[0][0] = 1; // baki n rows 0 column me 1 initialzie nhi krnege because +/- assign krn ke more than 1 tarike exist krega
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=W;j++){
                
                if(weight[i-1] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i-1][j-weight[i-1]];
            }
        }
        return dp[n][W];
    }
    
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=nums[i];
        int w = (sum+S)/2;
        if (S > sum) return 0;
        if ((S + sum) % 2 != 0) return 0;
        return count_subset_sum(nums,w,n);        
    }

}
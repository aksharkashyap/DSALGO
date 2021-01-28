package DP.KnapsackVariation;

public class EqualSubsetSumPartioning {
    
    //can partition into two sets 
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=nums[i];
            }
            
            if(sum%2!=0) return false;
            int SUM = sum/2;
            boolean dp[][] = new boolean[n+1][(SUM)+1];
            
            for(int i=0;i<=n;i++)
                dp[i][0] = true;
            
            for(int i=1;i<=n;i++){
                for(int j=1;j<=SUM;j++){
                    
                    if(nums[i-1]<=j)
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                    
                    else  dp[i][j] = dp[i-1][j];
                    
                }
            }
            return dp[n][SUM];
        }
    
}
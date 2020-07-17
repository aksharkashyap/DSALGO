package DP;
import java.util.Arrays;
class LIS2 {
    int dp[];
    int solve(int start,int prev, int[]nums){
        if(dp[start] != -1) return dp[start];
        int max = 0;
        for(int i=start;i<nums.length;i++){
            if(prev < nums[i]) 
               max = Math.max(max,solve(i+1,nums[i],nums)+1);
        }
        return dp[start] = max;
    }
    
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 2) return nums.length;
        dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
            max = Math.max(max,solve(i,nums[i],nums)+1);
        return max;
    }
}


//dp

class LISDP {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int ans=0;
        for(int i=1;i<nums.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    max = Math.max(max,dp[j]);
            }
            dp[i] = max+1;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
package KnapsackVariation;
import java.util.*;
//max number of ways
/**
Given a value N, if we want to make change for N cents, 
and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? 
The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
So the output should be 5.
 */


public class CoinChangeProb1 {

    static int coin_change(int[]weight,int W, int n){
        int dp[][] = new int[n+1][W+1];

        for(int i=0;i<=n;i++)
            dp[0][i] = 0;
        for(int i=0;i<=n;i++)
            dp[i][0] = 1;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(weight[i-1]>j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j-weight[i-1]];
            }
        }

        return dp[n][W];
    }
    public static void main(String[] args) {
      int[] S = {2,5,3,6};
      int N = 10;
      System.out.println(coin_change(S,N,S.length));
    }
}

//coin change
class Cchnage {
     //memoization
    int memo[];
    int solve(int[]coins, int amount, int size){
    
        if(memo[amount] != -2) return memo[amount];
        if(amount == 0) return memo[amount]= 0;
        
        int min = Integer.MAX_VALUE-1;
        
        for(int i=0;i<size;i++){
            int remaining_amount = amount - coins[i];
            if(remaining_amount < 0) continue;
            int temp = solve(coins,remaining_amount,size)+1;
            min = Math.min(temp,min);
        }
        return memo[amount] = min;
    }
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-2);
        int ans = solve(coins,amount,coins.length);
        return ans== Integer.MAX_VALUE-1 ? -1 : ans;
    }


    //bottom-up 
    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
          for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= i) {
              dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
          }
        }
        return dp[amount] > amount ? -1 : dp[amount];
      }
}
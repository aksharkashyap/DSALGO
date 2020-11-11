package DP.KnapsackVariation;

/* min coins/ fewest coins
Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} 
valued coins, what is the minimum number of coins to make the change?

Examples:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents 

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents */

public class CoinChangeProblem2 {


    static int min_coins_change(int weight[],int W, int n){
        int dp[][] = new int[n+1][W+1];

        for(int i=1;i<n+1;i++)
            dp[i][0] = 0;

        for(int i=0;i<W+1;i++)
            dp[0][i] = Integer.MAX_VALUE-1;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(weight[i-1] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-weight[i-1]]);
            }
        }    

        return (dp[n][W] == Integer.MAX_VALUE-1) ? -1 : dp[n][W];
    }

    public static void main(String[] args) {
        int coins[] = {7,2,3,6};
        int V = 5;
        int ans = min_coins_change(coins, V, coins.length);
        if(ans==-1) System.out.println("Not possible");
        else System.out.println(ans); 
    }
}
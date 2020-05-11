package KnapsackVariation;

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
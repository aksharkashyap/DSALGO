package DP.KnapsackVariation;

public class Knapsack {


    static private int knapsack(int[] weight, int[]value,int W, int n){
       
        int dp[][] = new int[n+1][W+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if (weight[i-1] <=j)
                    dp[i][j] = Math.max(value[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);

                else // dont include it
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int value[] = new int[]{60, 100, 120}; 
        int weight[] = new int[]{10, 20, 30}; 
        int capacity = 50;
        int w = weight.length;
        int maxprofit = knapsack(weight,value,capacity,w);
        System.out.println(maxprofit);
    }
}
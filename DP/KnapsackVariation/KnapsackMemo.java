package DP.KnapsackVariation;

import java.util.Arrays;

public class KnapsackMemo {
    static int dp[][] = new int[60][60];

    static private int knapsack(int[] weight, int[]value,int W, int n){
 
        if(W == 0 || n == 0)
            return 0;

        if(dp[W][n]!=-1)
            return dp[W][n];

        if(weight[n-1] > W) // dont include it
           return dp[W][n] = knapsack(weight, value, W, n-1);
        
        return dp[W][n] = Math.max(value[n-1]+ knapsack(weight,value,W-weight[n-1],n-1), knapsack(weight, value, W, n-1));
    }

    public static void main(String[] args) {
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int value[] = new int[]{60, 100, 120}; 
        int weight[] = new int[]{10, 20, 30}; 
        int capacity = 50;
        int w = weight.length;
        int maxprofit = knapsack(weight,value,capacity,w);
        System.out.println(maxprofit);
    }
}
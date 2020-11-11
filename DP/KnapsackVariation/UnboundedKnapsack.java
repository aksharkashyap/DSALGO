package DP.KnapsackVariation;
class UnboundedKnapsack{


    static private int unboundedknapsack(int weight[],int val[],int W, int n){

        int[][]dp = new int[n+1][W+1];

        for(int i=0;i<n+1;i++)
            for(int j=0;j<W+1;j++)
                if(i==0 || j==0) dp[i][j] = 0;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(weight[i-1] > j) dp[i][j] = dp[i-1][j]; // dont include it
                else dp[i][j] = Math.max(dp[i-1][j],val[i-1]+dp[i][j-weight[i-1]]);
            }
        }

        return dp[n][W];
    }


    public static void main(String[] args) {
        /*
        int arr[] = {3,4,5,2,6};
        int val[] = {1,2,4,3};
        int capacity = 5;
        System.out.println(unboundedknapsack(arr,val,capacity,arr.length));*/

        // rod cutting problem
        /*Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller 
        than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, 
        if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable 
        value is 22 (by cutting in two pieces of lengths 2 and 6)

        length   | 1   2   3   4   5   6   7   8  
        --------------------------------------------
        price    | 1   5   8   9  10  17  17  20
        And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

        length   | 1   2   3   4   5   6   7   8  
        --------------------------------------------
        price    | 3   5   8   9  10  17  17  20 */

        int pieces[] = {3,4,5,2,6};
        int price[] = {1,2,4,3};
        int capacity = 5;
        System.out.println(unboundedknapsack(pieces,price,capacity,pieces.length));   
    }
}
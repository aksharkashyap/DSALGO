package KnapsackVariation;
import java.util.*;
public class CountOfSubsetSum {

    // count of subset sum - how many sets are their with given sum
    public static int count(int weight[], int n, int W){
        int dp[][] = new int[n+1][W+1];

        for(int i=0;i<=W;i++)
            dp[0][i] = 0; 
        for(int i=0;i<=n;i++)
            dp[i][0] = 1;
        
        for(int i = 1; i<=n;i++){
            for(int j=1;j<=W;j++){

                if(weight[i-1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-weight[i-1]];
                else 
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2,3,2};
        int sum = 2;
        int size= arr.length;
        int c = count(arr,size,sum);
        System.out.println(c);

    }
}
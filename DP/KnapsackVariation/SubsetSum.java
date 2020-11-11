package DP.KnapsackVariation;

public class SubsetSum {
    
    static private boolean find_sum(int[] weight,int n, int W){
    
        boolean dp[][] = new boolean[n+1][W+1];

            for(int j=0;j<=W;j++){
                    dp[0][j] = false;
            }
            for(int i=0;i<=n;i++){
                dp[i][0] = true;
            }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
               
                if(weight[i-1] <= j)
                    dp[i][j] = dp[i-1][j-weight[i-1]] || dp[i-1][j];
                else 
                    dp[i][j] = dp[i-1][j];
            }
        }
         
        return dp[n][W];
     }
 
     public static void main(String[] args) {
         int set[] = {3,34,4,12,5,2};
         int sum =7;
         boolean isFound = find_sum(set,set.length,sum);
         if(isFound)System.out.println("Subset sum present");
         else System.out.println("Subset sum not present");
     }
 
 }


/*
public class SubsetSum {
    
    static private int find_sum(int[] weight,int n, int W){
    
        int dp[][] = new int[n+1][W+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
               
                if(i == 0 || j == 0)
                    dp[i][j]=0;

                else if(weight[i-1] <= j)

                    dp[i][j] = Math.max(weight[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);

                else 
                    dp[i][j] = dp[i-1][j];
            }
        }
         
        return dp[n][W];
     }
 
     public static void main(String[] args) {
         int set[] = {3,34,4,12,5,2};
         int sum =0;
         int isFound = find_sum(set,set.length,sum);
         if(isFound == sum)
             System.out.println("Subset sum present");
         else System.out.println("Subset sum not present");
     }
 
 }

 */

/* //----------RECURSIVE----------------------//
public class SubsetSum {

   static private int find_sum(int[] weight,int n, int W){

    if(W == 0 || n == 0)
        return 0;
    
    if(weight[n-1] > W)
        return find_sum(weight, n-1, W); //false // dont include it
    
    return Math.max(weight[n-1]+find_sum(weight, n-1, W-weight[n-1]), find_sum(weight, n-1, W)); // include it or dont include it
        
    }

    public static void main(String[] args) {
        int set[] = {3,34,4,12,5,2};
        int sum = 9;
        int get = find_sum(set,set.length,sum);
        if(get == sum)
            System.out.print("Subset sum present");
        else System.out.print("Subset sum not present");
    }

}
*/

/* // ------------------memoization------------------
import java.util.Arrays;
public class SubsetSum {
    
    static private int find_sum(int[][]memo,int[] weight,int n, int W){
 
     if(W == 0 || n == 0)
         return memo[n][W]=0;
    
     if(memo[n][W]!=-1)
        return memo[n][W];
     
     if(weight[n-1] > W)
         return memo[n][W] = find_sum(memo,weight, n-1, W); //false // dont include it
     
     return memo[n][W] = Math.max(weight[n-1]+find_sum(memo,weight, n-1, W-weight[n-1]), find_sum(memo,weight, n-1, W)); // include it or dont include it
         
     }
 
     public static void main(String[] args) {
         int set[] = {3,34,4,12,5,2};
         int sum = 9;
         int memo[][] = new int[set.length+1][sum+1];

         for(int row[] : memo)
            Arrays.fill(row, -1); // initialize memo with -1

         int get = find_sum(memo,set,set.length,sum);
         if(get == sum)
             System.out.print("Subset sum present");
         else System.out.print("Subset sum not present");
     }
 
 }

 */
package DP.KnapsackVariation;

//Given a set of integers, the task is to divide it into two sets S1 and S2 such 
//that the absolute difference between their sums is minimum.

public class MinSubsetSumDiff {

    static private int min_diff(int[] weight, int n){

        int sum=0;
        for(int i=0;i<n;i++)
            sum+=weight[i];

         int dp[][] = new int[n+1][sum+1];   
        
         for(int i=0;i<=n;i++){
            //dp[i][0] = true;
         }

         for(int i=1;i<=n;i++){
             for(int j=1;j<=sum;j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][weight[i-1]+j]);
             }
         }
        
        return dp[n][sum];


    }
    public static void main(String[] args) {
        
        int set[] = {3,34,4,12,5,2};
        int get_ans = min_diff(set,set.length);
        System.out.println(get_ans);
    }
}



/* // recursive
public class MinSubsetSumDiff {

    static private int min_diff(int[] weight, int n,int sumCalculated, int W){
        if(n==0)
            return Math.abs(W-sumCalculated);
        
        return Math.min(min_diff(weight, n-1, sumCalculated, W), min_diff(weight, n-1, weight[n-1]+sumCalculated, W));


    }
    static public int get_ansFunc(int arr[], int n){
        int sum=0;

        for(int i=0;i<n;i++)
            sum+=arr[i];
        return min_diff(arr,n,0,sum);
        
    }
    public static void main(String[] args) {
        
        int set[] = {3,34,4,12,5,2};
        int get_ans = get_ansFunc(set,set.length);
        System.out.println(get_ans);
    }
}
*/
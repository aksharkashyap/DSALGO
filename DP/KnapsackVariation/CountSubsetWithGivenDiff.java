package DP.KnapsackVariation;

// s1-s2 = diff
// s1+s2 = totalSum(arr)
//we got -> s1 = (diff+ totalSum(arr))/2;

public class CountSubsetWithGivenDiff {

    static private int count_subset_sum(int weight[],int W,int n){
        int dp[][] = new int[n+1][W+1];

        for(int i=0;i<=W;i++)
            dp[0][i] = 0;
        for(int i=0;i<=n;i++)
            dp[i][0] = 1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i-1][j-weight[i-1]];
            }
        }
        return dp[n][W];
    }

    static private int count_subset_with_given_diff(int[]arr,int n,int diff){
        int sum=0;
        for(int i=0;i<n;i++)
            sum += arr[i];
        int s1 = (diff+sum)/2;
        return count_subset_sum(arr,s1,n);
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2,3,2};
        int diff = 2;
        int ans = count_subset_with_given_diff(arr,arr.length,diff);
        System.out.println(ans);
    }

}


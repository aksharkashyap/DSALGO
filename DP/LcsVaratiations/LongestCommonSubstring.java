package DP.LcsVaratiations;

public class LongestCommonSubstring {

    // dp
    private static int find_substring_dp(char[] s1, char[] s2, int m, int n) {
        int result = Integer.MIN_VALUE;
        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) dp[i][j] = 0;

                else if(s1[i-1] == s2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    result = Math.max(dp[i][j], result);
                }
                else dp[i][j] = 0;
            }
        }
        return result;
    }

    //recursion
    static int find_substring_rec(char[]s1,char[]s2,int m,int n,int result){

        if(m == 0 || n==0) return result;

        if(s1[m-1] == s2[n-1]){
            result = find_substring_rec(s1, s2, m-1, n-1, result+1);
        }
        result = Math.max(result,Math.max(find_substring_rec(s1, s2, m-1, n,0),find_substring_rec(s1, s2, m, n-1, 0)));
        return result;
    }


    public static void main(String[] args) {
        char s1[] = {'a','v','c','f','f','r','t'};
        char s2[] = {'v','c'};
        int m = s1.length;
        int n = s2.length;
        int x = find_substring_dp(s1,s2,m,n);
        int y = find_substring_rec(s1, s2, m, n,0);
        System.out.println(x);
        System.out.println(y);
    }
}
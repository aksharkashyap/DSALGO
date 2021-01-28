package DP.LcsVaratiations;
class Lcs_2_a{
//recursive approach
    public static int findLCS(char[] x, char[] y, int m, int n){
     
        if(m==0 || n==0)
            return 0;

        if(x[m-1] == y[n-1])
            return 1+findLCS(x, y, m-1, n-1);

        else return Integer.max(findLCS(x, y, m-1, n), findLCS(x, y, m, n-1));
    }

//DP approach
public static int DP_LCS(char[] x, char[] y,int m, int n){
    int dp[][] = new int[m+1][n+1];
    
    for(int i=0;i<=m;i++)
    {
        for(int j=0;j<=n;j++){
            if(i == 0 || j == 0)
                dp[i][j] = 0;
            else if(x[i-1] == y[j-1])
                dp[i][j] = 1+ dp[i-1][j-1];
            else 
                dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);
        }
    }

    return dp[m][n];
}
    public static void main(String args[])
    {
        String s1 = "AGGTAB"; 
        String s2 = "GXTXAYB";
        char X[] = s1.toCharArray();
        char Y[]= s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        int len_rec = findLCS(X,Y,m,n);
        System.out.println(len_rec);

        int lec_dp = DP_LCS(X, Y, m, n);
        System.out.println(lec_dp);
    }
}
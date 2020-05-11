package LcsVaratiations;

import java.util.Arrays;

public class Lcs {

    //recursive
    static int LCS(char X[], char Y[],int m,int n){
        
        if(m==0 || n==0) 
            return 0;
        
        if(X[m-1] == Y[n-1]) 
            return 1+LCS(X, Y, m-1, n-1);

        else return Math.max(LCS(X, Y, m-1, n), LCS(X, Y, m, n-1));
    }

    static int get_lcs_memo(int[][] memo, char[] X, char[] Y,int m, int n) {
        if(m == 0 || n == 0) 
            return memo[m][n] = 0;
        
        else if(memo[m][n]!=-1) 
            return memo[m][n];

        else if(X[m-1] == Y[n-1]) 
            return memo[m][n] = 1+LCS(X, Y, m-1, n-1);

        else return memo[m][n] = Math.max(LCS(X, Y, m-1, n), LCS(X, Y, m, n-1));
    }
    //memo
    static int LCS_memo(char X[], char Y[], int m, int n){
        int memo[][] = new int[m+1][n+1];
        for(int[] rows: memo)
            Arrays.fill(rows,-1);     
        return get_lcs_memo(memo,X,Y,m,n);
    }

    static int LCS_dp(char x[],char y[],int m, int n){
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) 
                    dp[i][j] = 0;
                else if(x[i-1] == y[j-1]) 
                    dp[i][j] = 1 + dp[i-1][j-1];
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }


        //printing the lcs

        int i=m, j=n;
        StringBuilder lcs_str = new StringBuilder();
        while( i>0 && j>0){

            if(x[i-1] == y[j-1]){ //move digonally left side
                    lcs_str.append(x[i-1]);
                    i--; j--;  
            }
            else if(dp[i-1][j] > dp[i][j-1]){  // move up side
                i--;;
            }
            else j--;   // move left side

        }
        lcs_str.reverse();
        System.out.println(lcs_str.toString());

        return dp[m][n];
    }

    public static void main(String[] args) {
     
        //char[] x = {'a','b','d','t','f'};
        //char[] y = {'d','e','t','f'};
        char[] y = {'x','y','z'};
        char[] x = {'a','b','c','x','d','e','f','y','k','z'};
        System.out.println(LCS(x, y, x.length, y.length));
        System.out.println(LCS_memo(x, y, x.length, y.length));
        System.out.println(LCS_dp(x, y, x.length, y.length));
    }

}
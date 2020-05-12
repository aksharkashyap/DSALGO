package LcsVaratiations;

//given a string - find longest repeating subsequqnece

// pass the same string as m and n
// if(both the chars are equal and having diff indexes then add its length to the answer)

class LongestRepeatingSubsequence {

    static int LRS_dp(char x[],char y[],int m, int n){
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) 
                    dp[i][j] = 0;
                else if(x[i-1] == y[j-1] && i!=j) 
                    dp[i][j] = 1 + dp[i-1][j-1];
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
     
        char[] x = {'a','b','d','b','d'};
        System.out.println(LRS_dp(x, x, x.length, x.length));
    }

}
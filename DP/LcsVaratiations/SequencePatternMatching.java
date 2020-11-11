package DP.LcsVaratiations;
/**
 * A-> xyz
 * B-> abcxdefykz
 * return true if a is present in b (subsequence)
 * 
 */
public class SequencePatternMatching {
    
    public static boolean sequence_pattern_matching(char[]A,char[]B,int m,int n){

        int dp[][]=new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0) 
                    dp[i][j] = 0;
                else if(A[i-1]==B[j-1]) 
                    dp[i][j] = 1+ dp[i-1][j-1];
                else 
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        if(dp[m][n] == m) return true;
        return false;
    }

    public static void main(String[] args) {
        
        char[] A = {'x','y','z'};
        char[] B = {'a','b','c','x','d','e','f','y','k'};

        boolean ans = sequence_pattern_matching(A, B, A.length, B.length);
        System.out.println(ans);
    }
}
package DP.MatrixChainMultiplication;

import java.util.Arrays;

public class MCM_Memo {
    
    static int solve(int[]mat,int i, int j,int[][]memo){
        int ans = Integer.MAX_VALUE;

        if (i>=j) return 0;
        if(memo[i][j]!=-1)return memo[i][j];
        for(int k=i;k<j;k++){
            int temp = solve(mat,i,k,memo)+solve(mat,k+1,j,memo)+ (mat[i-1]*mat[k]*mat[j]);
            if(temp<ans) ans = temp;
        }
        return memo[i][j]=ans;
        
    }

    public static void main(String[] args) {
        int mat[]= {1,2,3,4,3};
        int i=1,j=mat.length;

        int memo[][] = new int[j+1][j+1];
        for(int row[]:memo)
            Arrays.fill(row,-1);

        int an = solve(mat,i,j-1,memo);
        System.out.print(an);
    }
}
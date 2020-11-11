package DP.MatrixChainMultiplication;

import java.util.Arrays;

class PalindromePartitioning{
   
    static boolean isPalindrome(char arr[],int i , int j){
       
        while(i<j)
            if(arr[i++] != arr[j--]) 
                return false;
    
        return true;
    }
    
    static int solve(char arr[], int i , int j, int[][]memo){
        int ans = Integer.MAX_VALUE;
        if(memo[i][j]!=-1) return memo[i][j];
        if(i>=j ||isPalindrome(arr,i,j)) return 0;
        
        for(int k=i;k<=j-1;k++){
                int left,right;
                if(memo[i][k]!= -1) left = memo[i][k];
                else left = solve(arr, i, k,memo);

                if(memo[k+1][j]!=-1) right = memo[k+1][j];
                else right = solve(arr, k+1,j,memo);
                
                int temp = left + right + 1;
                if(ans>temp) ans=temp;
        }
        return memo[i][j] = ans;
    }

    public static void main(String[] args) {
        char mat[]= {'n','i','t','k'};
        int i=0,j=mat.length;

        int memo[][] = new int[j+1][j+1];
        for(int rows[]: memo)
            Arrays.fill(rows, -1);
        
        int an = solve(mat,i,j-1,memo);
        System.out.print(an);
    }
}
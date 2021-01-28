package DP.MatrixChainMultiplication;
//https://leetcode.com/problems/integer-break/discuss/821786/Java-Simple-Intuitive-Memoization
/*
on each call 2 partition will be made a * b
recursively call these partitions to make further partiitons
ie -> recur_call(a) * recur_call(b)
*/

class IntegerBreak {

    int breakk(int n,int num,int[]dp){
        if(n==1) return 1;
        if(dp[n]!=0) return dp[n];
        int temp=1,max=1;
        for(int a=1,b=n-1;a<=b; a++,b--){
            temp = breakk(a,num,dp) * breakk(b,num,dp);
            max = Math.max(max,temp);
        }
        //Either n can give the max prduct or it's partition
        //note that in case of orginal number(final return value) return (partition's max) because atleast 2 partion is required according to the question] so original number wont be a candidate
        return dp[n] = (n==num) ? max : Math.max(n,max);
    }
    
    public int integerBreak(int n) {
        int[]dp = new int[n+1];
        return breakk(n,n,dp);
    }
}
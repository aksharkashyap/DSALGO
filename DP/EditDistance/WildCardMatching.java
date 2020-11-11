package DP.EditDistance;

class Solution {
    int memo[][];
    int solve(char[] s, char[] p, int i, int j){
        
        if(memo[i][j] != 0) return memo[i][j];
        
        if(i == s.length){
            while (j < p.length && p[j] == '*') j++; // if s has finished then skip *s 
            if(j == p.length) return memo[i][j] = 1;
            return memo[i][j] = -1;
        }
        if(j == p.length) return memo[i][j] = -1;
        
        if(s[i] == p[j] || p[j] == '?')
            return memo[i][j]= solve(s,p,i+1,j+1);
        
        if(p[j] == '*'){
           int a = solve(s, p, i, j + 1); //match zero
           int b = solve(s, p, i + 1, j); //matches more than one character character
           int c = solve(s, p, i + 1, j + 1); //matches this exact character
           if(a == 1 || b == 1 || c == 1) return memo[i][j] = 1;
           else return memo[i][j] = -1;
        }
        
        return memo[i][j] = -1;
    }
    
    public boolean isMatch(String s, String p) {
        memo = new int[s.length()+1][p.length()+1]; // 0 indicates havent found, -1 false, 1 true
        return solve(s.toCharArray(), p.toCharArray(),0,0) == -1 ? false : true;
    }
   
}
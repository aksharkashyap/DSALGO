package DP;
//nth catlan number 
//for amazing applications : https://en.wikipedia.org/wiki/Catalan_number
// formula ->   2nCn/ n+1
public class UniqueBST {
    //Recursive
    int solve_recursive(int n){
        int ans=0;
        if(n == 0 || n == 1) return 1;
        for(int i=1;i<=n;i++)
            ans += solve_recursive(i-1) * solve_recursive(n-i);
        return ans;
    }

    //DP
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = 0;
            for(int j=0;j<i;j++)
                dp[i] += dp[j] * dp[i-j-1];
        }
        return dp[n];
    }

}

/** Applications--------------------------------------
 
1) Count the number of expressions containing n pairs of parentheses which are correctly matched. 
    For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).

2) Count the number of possible Binary Search Trees / or unlabeled tree with n keys (See this)

3) Count the number of full binary trees (A rooted binary tree is full if every vertex has 
   either two children or no children) with n+1 leaves.

4) Given a number n, return the number of ways you can draw n chords in a circle 
   with 2 x n points such that no 2 chords intersect.

https://www.youtube.com/watch?v=J0heuWnOKcw

4) polygon triangulation
5) hanshake across the table 
 */
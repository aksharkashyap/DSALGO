package DP;
import java.util.Arrays;
/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */

//Top-Down
public class MinPathSum {
        int memo[][];
        int solve(int grid[][], int x, int y){
            if(memo[x][y] != -1) return memo[x][y];
            if(x >= grid.length || y >= grid[0].length) return Integer.MAX_VALUE;
            if(x == grid.length-1 && y == grid[0].length-1) return grid[x][y];
            int a = solve(grid,x+1,y);  //goto bottom
            int b = solve(grid,x,y+1); //goto right
            int bottom = (a==Integer.MAX_VALUE) ? a : a+grid[x][y];
            int right = (b==Integer.MAX_VALUE) ? b : b+grid[x][y]; 
            return memo[x][y]=Math.min(bottom,right);
        }
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            if(m < 1 || n < 1) return 0;
            memo = new int[m+1][n+1];
            for(int rows[] : memo) Arrays.fill(rows,-1);
            return solve(grid,0,0);
        }
    
}

//Bottom-up 1
class MinPathSum_BottomUp {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m < 1 || n < 1) return 0;
        int[][]dp = new int[m+1][n+1];
        
        for(int i=m;i>=0;i--){
            for(int j=n;j>=0;j--){
                if(i == m || j == n ) dp[i][j] = Integer.MAX_VALUE;
                else if (i == m-1 && j == n-1) dp[i][j] = grid[i][j];
                else dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1])+grid[i][j];
            }
        }
        return dp[0][0];
    }
}
//bottom_up 2
class BottomUp2 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m < 1 || n < 1) return 0;
        int[][]dp = new int[m][n];
        dp[0][0] = grid[0][0];
      
        for(int i=1;i<m;i++)
            dp[0][i] = grid[0][i] + dp[0][i-1];
        
        for(int i=1;i<m;i++)
            dp[i][0] = grid[i][0] + dp[i-1][0];
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++)
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
        }
        return dp[m-1][n-1];
    }
}
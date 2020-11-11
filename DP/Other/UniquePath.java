package DP.Other;
import java.util.Arrays;
/**A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the 
bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there? */

//https://leetcode.com/problems/unique-paths/discuss/691177/4-approaches-learn-for-interview-beats-100
public class UniquePath {
        int[][] memo;
        
        int solve(int[][] grid, int x, int y){
            if(x>=grid.length || y >=grid[0].length) return 0;
            if(memo[x][y] != -1) return memo[x][y];
            if(x == grid.length-1 && y == grid[0].length-1) return 1;
            return memo[x][y] = solve(grid,x+1,y) + solve(grid,x,y+1); 
        }
        public int uniquePaths(int m, int n) {
            int grid[][] = new int[m][n];
            memo = new int[m][n];
            for(int[]rows:memo) Arrays.fill(rows,-1);
            return solve(grid,0,0);
        }
    
}
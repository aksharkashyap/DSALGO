package BackTracking;

class Sudoku2 {
    class Solution {
        public boolean canPlace(char mat[][], int i, int j, int n, char num) {
            // Row and Column check
            for (int x = 0; x < n; x++) {
                if (mat[x][j] == num || mat[i][x] == num) {
                    return false;
                }
            }
            // Sub matrix check
            int rn = (int)Math.sqrt(n);
            int sx = (i/rn)*rn; // starting coordinate of sub-grid (abscissa)
            int sy = (j/rn)*rn; // starting coordinate of sub-grid (ordinate)
            for (int x = sx; x < sx+rn; x++) {
                for (int y = sy; y < sy+rn; y++) {
                    if (mat[x][y] == num) {
                        return false;
                    }
                }
            }
            // if number is not found then we can place this num value
            return true;
        }
        public boolean solveSudoku(char mat[][], int i, int j,int n) {
            // Base Case
            if (i == n) return true;
            // Row End Case
            if (j == n) return solveSudoku(mat,i+1,0,n);
            // Skip already filled matrix
            if (mat[i][j] != '.') return solveSudoku(mat,i,j+1,n);
            // Check for every Possible value
            for (int num = 1; num <= n; num++) {
                if (canPlace(mat,i,j,n,(char)(num+48))) {
                    mat[i][j] = (char)(num+48);
                    boolean couldWeSolve = solveSudoku(mat,i,j+1,n);
                    if (couldWeSolve) {
                        return true;
                    }
                }
            }
            // Apply Backtracking
            mat[i][j] = '.';
            return false;
        }
        public void solveSudoku(char[][] board) {
            solveSudoku(board,0,0,9);
           }
         }
}
package BackTracking;

class IsValidSudoku {
    boolean isValid(char[][]board, int N, int r, int c, char num){
        int row,col;
        //check row
        for(col=0;col<N;col++)
            if(col!=c && board[r][col]==num) return false;
        
        //check col
        for(row=0;row<N;row++)
            if(row!=r && board[row][c]==num) return false;
        
        //check grid
        int sqrt = 3;
        row = row - row % sqrt;
        col = col - col % sqrt;
        for(row=0;row<row+sqrt;row++)
            for(col=0;col<col+sqrt;col++)
                if(row!=r && col!=c && board[row][col]==num)
                    return false;
        
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        int N =board.length;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] == '.') continue;
                if(!isValid(board,N,i,j,board[i][j]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsValidSudoku s = new IsValidSudoku();
        char board[][] = { 
               {'1','.','3','4','5','6','7','8','9'},
               {'1','2','3','.','5','6','7','8','9'},
               {'1','2','3','4','5','6','7','8','9'},
               {'1','.','3','4','5','6','7','.','9'},
               {'1','2','3','.','5','6','7','8','9'},
               {'1','2','3','4','5','6','7','8','9'},
               {'1','2','3','4','5','6','7','8','9'},
               {'1','2','3','4','5','6','7','8','9'},
               {'1','2','3','4','5','6','7','8','9'}
        };
        boolean ans = s.isValidSudoku(board);
        System.out.print(ans);
    }
}
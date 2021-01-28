package BackTracking;
// follow the second solution given below 
class Sudoku {
    
    boolean isValidNum(int[][] board,int row, int col, int num,int N){

        //check row
        int c,r;
        for(c=0;c<N;c++)
            if(board[row][c]==num)
                return false;

        //check col
        for(r=0;r<N;r++)
            if(board[r][col]==num)
                return false;

        //check grid
        int sqrt = (int) Math.sqrt(N);
        row = row - row % sqrt;
        col = col - col % sqrt;
        
        for(r=row;r<row+sqrt;r++)
            for(c=col;c<col+sqrt;c++)
                if(board[r][c] == num)
                    return false;


        return true;
    }
    
    boolean solve(int[][]board,int N){
        //base case
        boolean isEmpty = false;
        int row=-1,col=-1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] ==0){
                    row = i;
                    col = j;
                    isEmpty = true;
                    break;
                }
                if(isEmpty) break;
            }
        }
        if(!isEmpty) return true;
        
        for(int num=1;num<=9;num++){ //try putting the numbers 
            if(isValidNum(board,row,col,num, N)){
                  board[row][col] = num;
                  if(solve(board,N)) 
                        return true;
                  else board[row][col] = 0;
                }
            }
        return false;
    }

    public void solveSudoku(int[][] board) {
        int N = board.length;
        if(solve(board,N)){
            //print board
            print_board(board,N);
        }else{
            System.out.println("Can't be solved");
        }      
    } 
    
    void print_board(int[][]board,int N){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                System.out.print(board[i][j]+ " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
      int[][] grid = { 
         {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
         {0, 0, 5, 2, 0, 6, 3, 0, 0} };

       Sudoku s = new Sudoku();
       s.solveSudoku(grid);  
    }
}

/**recommended approach-> recursive fashion
 *  boolean solve(char[][]board,int row,int col,char[]moves,int N){
        if(row==N) return true; //row base case
        if(col==N) return solve(board,row+1,0,moves,N); //col ended start with the new row
        if(board[row][col] != '.') return solve(board,row,col+1,moves,N); //if occupied move to next
        for(int i=0;i<moves.length;i++){
            char move = moves[i];
            if(isValid(board,row,col,move,N)){
                board[row][col] = move;
                if(solve(board,row,col+1,moves,N)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        char[]moves = {'1','2','3','4','5','6','7','8','9'};
        solve(board,0,0,moves,board.length);
        print_board(board,board.length);
    }
 */
package BackTracking;

class NQueenProblem {
    
    boolean isSafe(int[][] mat, int row, int col, int N){
        int r = row,c = col;
        //check upper side
        while(r>=0)
             if(mat[r--][c] == 1) return false;
        
        //check right upper diagonal
        r = row; c = col;
        while(r>=0 && c>=0)
            if(mat[r--][c--] == 1) return false;
    
        //check left upper diagonal
        r = row; c = col;
        while(r>= 0 && c<N)
            if(mat[r--][c++] == 1) return false;

        // no need to check down side becuase we are moving from up to down 
        //so clash can happen from upper side only so check them
        return true;
    }

    boolean solve(int mat[][], int row, int N){

        if(row == N)    // all rows are solved 
            return true;
    
        for(int col=0;col<N;col++){
            if(isSafe(mat, row,col, N)){
                mat[row][col] = 1;
                if(solve(mat, row+1, N)) 
                    return true;
                else 
                    mat[row][col] = 0;
            }
        }
        return false;
    }

    void n_queen(int mat[][],int N){
       int row = 0;
       if(solve(mat,row,N)){
            print_sol(mat,N);
       }
        
    }
    void print_sol(int[][]mat,int N){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                System.out.print(mat[i][j]+" ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        NQueenProblem q = new NQueenProblem();
        int N = 5;
        int mat[][]=new int[N][N];
        q.n_queen(mat,N);
    }
}
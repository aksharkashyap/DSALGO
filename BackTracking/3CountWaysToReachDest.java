package BackTracking;

/**
 * Given a maze with obstacles, count number of paths to reach rightmost-bottommost cell 
 * from topmost-leftmost cell. 
 * A cell in given maze has value -1 if it is a blockage or dead end, else 0.
 * From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only.
 */
class CountWaysToReachDest {
    static int count=0;
    
    static boolean isSafePath(int mat[][],int x, int y,int N){
        if(x<0 ||  x>=N || y<0 || y>=N || mat[x][y] != 0 )
            return false;
        return true;
    }

    static void solve(int[][]mat, int[][]visited , int x, int y, int N,int[]xMove,int[] yMove){
        int next_x,next_y;
        
        if( x== N-1 && y == N-1 && mat[x][y]==0 ){
            count++;
            return;
        }

        for(int i=0;i<2;i++){
                next_x = x + xMove[i];
                next_y = y + yMove[i];
            if(isSafePath(mat, next_x, next_y, N)){
                visited[next_x][next_y] = 1;
                solve(mat, visited, next_x, next_y, N, xMove, yMove);
                visited[next_x][next_y] = 0;
            }
        }
    }

    static void rat_in_a_maze(int[][] mat, int srcX, int srcY, int destX, int destY, int N) {
        int visited[][] = new int[N][N];
        if(mat[srcX][srcY] == -1)  // if src is blocked -> there is no way to move further
        {   System.out.println("0");
            return;
        }
        visited[srcX][srcY] = 1;
        int xMove[] = {0,1}; 
        int yMove[] = {1,0};
        solve(mat,visited,srcX,srcY,N,xMove,yMove);
        System.out.println("count: "+count);
    }
    public static void main(String[] args) {
        int mat[][] = {
            {0, 0, 0, 0}, 
            {0, -1, 0, 0}, 
            {-1, 0, 0, 0}, 
            {0, 0, 0, 0}
        };
        int N = mat.length;
        int srcX = 0, srcY = 0;
        int destX = N-1, destY = N-1;
        rat_in_a_maze(mat,srcX,srcY,destX,destY,N);
    }

}
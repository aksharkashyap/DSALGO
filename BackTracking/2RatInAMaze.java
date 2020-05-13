package BackTracking;
//slight variation of knight tour
/**A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., 
 * maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source 
 * and has to reach the destination. The rat can move only in two directions: forward and down.
In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path 
from source to destination. Note that this is a simple version of the typical Maze problem. 
For example, a more complex version can be that the rat can move in 4 directions and a more complex 
version can be with a limited number of moves. 

Complexity Analysis:
Time Complexity: O(2^(n^2)).
The recursion can run upperbound 2^(n^2) times.
Space Complexity: O(n^2).
Output matrix is required so an extra space of size n*n is needed.
*/

 class RatInAMaze {

    static boolean isSafePath(int mat[][],int x, int y,int N){
        if(x<0 ||  x>=N || y<0 || y>=N || mat[x][y] !=1 )
            return false;
        return true;
    }

    static boolean solve(int[][]mat, int[][]visited , int x, int y, int N,int[]xMove,int[] yMove){
        int next_x,next_y;
        
        if( x== N-1 && y == N-1 && mat[x][y]==1 ) return true;

        for(int i=0;i<2;i++){
                next_x = x + xMove[i];
                next_y = y + yMove[i];
            if(isSafePath(mat, next_x, next_y, N)){
                visited[next_x][next_y] = 1;
                if(solve(mat, visited, next_x, next_y, N, xMove, yMove))
                    return true;
                else visited[next_x][next_y] = 0;
            }
        }
        return false;
    }

    static void rat_in_a_maze(int[][] mat, int srcX, int srcY, int destX, int destY, int N) {
        int visited[][] = new int[N][N];
        visited[srcX][srcY] = 1;
        int xMove[] = {0,1}; 
        int yMove[] = {1,0};
        if(solve(mat,visited,srcX,srcY,N,xMove,yMove)){
            System.out.println("Solution exist");
            print_sol(visited, N);
        }
        else System.out.println("soln doesnt exist");
    }

    static void print_sol(int[][]visited,int N){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                System.out.print(visited[i][j]+" ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int mat[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        int N = mat.length;
        int srcX = 0, srcY = 0;
        int destX = N-1, destY = N-1;

        rat_in_a_maze(mat,srcX,srcY,destX,destY,N);
    }
}

//application -> total number of paths from src to dst(with some constraint)
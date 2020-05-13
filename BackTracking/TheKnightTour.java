package BackTracking;

import java.util.Arrays;

public class TheKnightTour {

    void printSolution(int sol[][],int N) { 
        for (int x = 0; x < N; x++) { 
            for (int y = 0; y < N; y++) 
                System.out.print(sol[x][y] + " "); 
            System.out.println(); 
        } 
    }
    
    boolean isValidMove(int[][]visited,int x, int y,int N){
        if(x>=N || x<0 || y>=N || y<0 || visited[x][y]!= -1)
            return false;
        return true;
    }

    void knight_tour(int N){
        int visited[][] = new int[N][N];
        //initialize board
        for(int row[] : visited)
            Arrays.fill(row,-1);
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        visited[0][0] = 0; //starting from 0,0
        if(solve(visited,1,0,0,xMove,yMove,N)){
            System.out.println("solution exist");
            //print the visited matrix
            printSolution(visited, N);
        }else System.out.println("soln doesnt exist");

    }

    boolean solve(int[][]visited,int curr_move, int x, int y,int [] xMove, int yMove[],int N){
        int next_x,next_y;

        if(curr_move == N*N)
            return true;  //if board is filled up completely

        for(int i=0;i<N;i++){
            next_x = x + xMove[i];
            next_y = y + yMove[i];

            if(isValidMove(visited, next_x, next_y,N)){
                visited[next_x][next_y] = curr_move;
                if(solve(visited, curr_move+1, next_x, next_y, xMove, yMove, N))
                    return true;
                //backtrack
                else visited[next_x][next_y] = -1;
            }
            
        }
    return false;
    }

    public static void main(String[] args) {
        
        TheKnightTour t = new TheKnightTour();
        int dimension = 8; //dimension of chesss board
        t.knight_tour(dimension);
    }
}
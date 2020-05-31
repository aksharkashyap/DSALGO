package GRAPH;
import java.util.*;

class _1_SnakeNLadder {
    
    static class qentry{
        int v;
        int dist;
    }

    static int solve(int moves[], int n){
        int visited[] = new int[n];
        Queue<qentry> q = new LinkedList<>();
        qentry qe = new qentry();
        qe.v = 0;
        qe.dist = 0;

        q.add(qe);
        visited[0] = 1;

        while(q.size() !=0){

           qe = q.remove();
           int v = qe.v;
           if(v == n-1) break;

           for(int j = v+1; j<=(v+6) && j<n; ++j){
                if(visited[j] == 0){
                    qentry a = new qentry();
                    a.dist = qe.dist+1;
                    visited[j] = 1;
                    if(moves[j] != -1)
                        a.v = moves[j];
                    else 
                        a.v = j;
                    q.add(a);
                }
           }
        }
        return qe.dist;
       
    }

    public static void main(String[] args) {
        int moves[] = new int[30];
        Arrays.fill(moves, -1);
        // Ladders 
        moves[2] = 21; 
        moves[4] = 7; 
        moves[10] = 25; 
        moves[19] = 28; 
  
        // Snakes 
        moves[26] = 0; 
        moves[20] = 8; 
        moves[16] = 3; 
        moves[18] = 6; 

        System.out.print(solve(moves,moves.length));
    }
}
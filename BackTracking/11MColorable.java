package BackTracking;

import java.util.*;

class MColorable{

    static boolean isSafe(int c,int[]colors,int graph[][],int V,int N){
        for(int i=0;i<N;i++)
            if(graph[V][i] == 1 && colors[i] == c) return false; // checking neighbour-> if neighbour has the same color return false
        return true;
    }

    static boolean solve(int graph[][], int colors[], int N,int m, int V){
        if(V == N) return true;
        for(int c=1;c<=m;c++){
            if(isSafe(c, colors,graph,V,N)){
                colors[V] = c;
                if(solve(graph, colors, N,m, V+1)) return true;
                colors[V] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V=4;
        int start=0; //start from 1st vertex and assign color 1 by 1 to further vertices
        int m=3;
        int colors[] = new int[V];
        int graph[][] = {
            { 0, 1, 1, 1 }, 
            { 1, 0, 1, 0 }, 
            { 1, 1, 0, 1 }, 
            { 1, 0, 1, 0 }
        };

        if(solve(graph, colors, graph.length, m,start)) 
            System.out.print(Arrays.toString(colors));
        else System.out.println("Not "+ m + " colorable");

    }
}
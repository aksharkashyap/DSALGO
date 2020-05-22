package GRAPH;

import java.util.Arrays;

public class HamiltonianCycle2 {
    int V = 5;
    int pathArr[] = new int[V];
    boolean isIncluded[] = new boolean[V];

    boolean isSafe(int[][]graph, int pos, int v){

        if(graph[pathArr[pos-1]][v] == 0) return false;

         /* Check if the vertex has already been included. 
           This step can be optimized by creating an array 
           of size V -> isIncluded */
         /* for(int i=0;i<pos;i++)
            if(pathArr[i] == v) return false;
         */
        if(isIncluded[v]) return false;

        return true;
    }

    boolean solve(int[][]graph,int pos){
        if(pos == V){
            if(graph[pathArr[pos-1]][pathArr[0]] == 1) return true;
            return false; 
        }

        for(int v=1;v<V;v++){
            if(isSafe(graph, pos,v)){
                pathArr[pos] = v ;
                isIncluded[v] = true;
                if(solve(graph,pos+1)) return true;
                pathArr[pos] = -1;
                isIncluded[v] = false;
            }
        }

        return false;
    }

    void printSolution() 
    { 
        System.out.println("Solution Exists: Following" + 
                           " is one Hamiltonian Cycle"); 
        for (int i = 0; i < V; i++) 
            System.out.print(" " + pathArr[i] + " "); 
  
        // Let us print the first vertex again to show the 
        // complete cycle 
        System.out.println(" " + pathArr[0] + " "); 
    } 

    public static void main(String[] args) {
        HamiltonianCycle2 obj = new HamiltonianCycle2();
        int graph1[][] = {{0, 1, 0, 1, 0}, 
            {1, 0, 1, 1, 1}, 
            {0, 1, 0, 0, 1}, 
            {1, 1, 0, 0, 1}, 
            {0, 1, 1, 1, 0}, 
        };
        Arrays.fill(obj.pathArr,-1);
        int PATH = 0;
        obj.pathArr[PATH] = 0;
        if(obj.solve(graph1,PATH+1)) obj.printSolution();
    }
}
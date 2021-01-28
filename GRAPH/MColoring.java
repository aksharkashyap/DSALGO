package GRAPH;
import java.util.*;
class MColoring{
    final int V=4;
    int color[];


    boolean graphColoring(int graph[][], int m){

        color = new int[V];
        Arrays.fill(color,0);

        if(!graphColoringUtil(graph, m,color,0))
                    return false;
        return true;
    }

     
/* A utility function to check if the current color assignment
is safe for vertex v i.e. checks whether the edge exists or not
(i.e, graph[v][i]==1). If exist then checks whether the color to 
be filled in the new vertex(c is sent in the parameter) is already
used by its adjacent vertices(i-->adj vertices) or not (i.e, color[i]==c) */

    boolean isSafe(int current_vertex, int graph[][], int color[],int c){ //c - color we want to assign
        for(int i=0;i<V;i++)
            if(graph[current_vertex][i] == 1 && c == color[i])
                return false;
        return true;
    }


    private boolean graphColoringUtil(int[][] graph, int m, int[] color, int v) {
        
        if(v==V)
            return true;

        for(int c=1; c<= m; c++){

            if(isSafe(v,graph,color,c)){
            
                color[v] = c;
                if(graphColoringUtil(graph, m,color,v+1))
                    return true;
            
                color[v] = 0;
            }
        }
        
        return false;
    }

    void printSolution(int color[]) 
	{ 
		System.out.println("Solution Exists: Following" + 
						" are the assigned colors"); 
		for (int i = 0; i < V; i++) 
			System.out.print(" " + color[i] + " "); 
		System.out.println(); 
	} 
    public static void main( String[] args) {
        
        MColoring coloring = new MColoring();
     
        int graph[][] = {
            {0,1,1,1},
            {1,0,1,0},
            {1,1,0,1},
            {1,0,1,0},
        };

        int m=2;
        System.out.print(coloring.graphColoring(graph,m));    
    }

}
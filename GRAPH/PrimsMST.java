package GRAPH;

import java.util.Arrays;

//greedy algorithm 
//choose the min weight vertex each time
//relax its neighbour
public class PrimsMST {
    
    static void solve(int start,int[][]graph, boolean visited[], int weight[], int V,int[]parent){
        
        weight[start] = 0;
        
        for(int i=0;i<V-1;i++){
            int minWeightVertex = getMinVertex(visited,weight,V);
            visited[minWeightVertex] = true;
            relax_neighbour(minWeightVertex,graph,visited,weight,V,parent);
        } 
        
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < V; i++) 
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);  //  graph[i][parent[i]] = weight[i]
    }

    static int getMinVertex(boolean visited[], int weight[], int V){
        int minV=-1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i< V;i++){
            if(!visited[i] && weight[i]<min){
                minV = i;
                min = weight[i];
            }
        }
        return minV;
    }

    static void relax_neighbour(int v,int[][]graph, boolean visited[], int weight[], int V, int[]parent){
        for(int i=0;i<V;i++){
            if(graph[v][i] !=0 && !visited[i] && (graph[v][i] < weight[i])){
                weight[i] = graph[v][i];
                parent[i] = v;
            }
            }
    }


    public static void main(String[] args) {
        int V = 5;
        boolean visited[] = new boolean[V];

        int parent[] = new int[V];
        Arrays.fill(parent,-1);

        int weight[] = new int[V];
        for(int i=0;i<V;i++) weight[i] = Integer.MAX_VALUE;
        int graph[][] = {
            { 0, 2, 0, 6, 0 }, 
            { 2, 0, 3, 8, 5 }, 
            { 0, 3, 0, 0, 7 }, 
            { 6, 8, 0, 0, 9 }, 
            { 0, 5, 7, 9, 0 } 
        };
        int start=0;
        solve(start,graph,visited,weight,V,parent);
    }
}
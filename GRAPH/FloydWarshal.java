package GRAPH;
/**
 * Floyd–Warshall algorithm is an algorithm for finding shortest paths in a weighted graph with positive 
 * or negative edge weights (but with no negative cycles). It does so by comparing all possible paths 
 * through the graph between each pair of vertices and that too with O(V^3) comparisons in a graph.
 * 
 * DP SOlution
 */

public class FloydWarshal {
    
    static int INF = 9999;

    static int[][] solve(int graph[][],int N){

        int dp[][] = new int[N][N];
        int i,j,k;
        //initialization
        for(i=0;i<N;i++)
            for(j=0;j<N;j++)
                dp[i][j] = graph[i][j];

        //find shortest path passing via -> k (intermediate vertex )
        for(k=0;k<N;k++)
            for(i=0;i<N;i++)
                for(j=0;j<N;j++)
                       dp[i][j] = Math.min(dp[i][k]+dp[k][j],dp[i][j]);    
        
        return dp;
    }

    static void printGraph(int dist[][], int V) 
    { 
        System.out.println("The following matrix shows the shortest "+ 
                         "distances between every pair of vertices"); 
        for (int i=0; i<V; ++i) 
        { 
            for (int j=0; j<V; ++j) 
            { 
                if (dist[i][j]==INF) 
                    System.out.print("INF "); 
                else
                    System.out.print(dist[i][j]+"   "); 
            } 
            System.out.println(); 
        } 
    } 

    public static void main(String[] args) {
        int graph[][] = { 
            {0,   5,  INF, 10}, 
            {INF, 0,   3, INF}, 
            {INF, INF, 0,   1}, 
            {INF, INF, INF, 0} 
          }; 
        int N = graph.length;
        int dp[][] = solve(graph, N);
        printGraph(dp, N);
    }
}
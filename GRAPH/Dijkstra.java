package GRAPH;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Dijsktra{
    
    int getMinVertex(int dist[],boolean visited[],int V){
       int min_vertex = -1;
       int min_dist = Integer.MAX_VALUE;
       for(int i=0;i<V;i++){
           if(!visited[i]  && dist[i] <= min_dist){
               min_vertex = i;
               min_dist = dist[i];
           }
       }

       return min_vertex;
   } 

    void relax_neighbour(int graph[][],boolean visited[],int i,int V,int dis[]){
        for(int j=0;j<V;j++){ //i - row and j-column
            if(!visited[j]  && graph[i][j]!=0 && dis[i]!=Integer.MAX_VALUE){
                int temp = dis[i] + graph[i][j];
                if(temp < dis[j])
                    dis[j] = temp ; 
            }
        } 
    } 

   void dijsktra(int graph[][],int V,int src){

    boolean visited[] = new boolean[V];
    int distance[] = new int[V];
    for(int i=0;i<V;i++) distance[i] = Integer.MAX_VALUE;
    distance[src] = 0;
    for(int count=0;count<V-1;count++){
        int min_dist_vertex = getMinVertex(distance,visited,V);
        visited[min_dist_vertex] = true;
        relax_neighbour(graph,visited,min_dist_vertex,V,distance);
    }

    for(int i : distance) 
        System.out.print(i+" ");
 }
   public static void main(String[] args) {
       int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
       { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
       { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
       { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
       { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
       { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
       { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
       { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
       { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
       int V  = graph.length;
       Dijsktra t = new Dijsktra();
       int src = 0;
       t.dijsktra(graph,V,src);
   }

   //adjacency list
   static void dijsktra_algo(List<List<int[]>> graph,int n, int src){
    boolean[]vis = new boolean[n];
    int[]dist = new int[n];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[src] = 0;

    for(int i=1;i<n;i++){
        //pick min distance vertex
        int min_dist_vertex=-1;
        int minVal = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            if(!vis[j] && dist[j] <= minVal){
                minVal = dist[j];
                min_dist_vertex = j;
            }
        }
        vis[min_dist_vertex] = true;
        //relax neighbours
        int destination, path;
        for(int[] dest_pairs : graph.get(min_dist_vertex)){
            destination = dest_pairs[0];
            if(vis[destination]) continue;
            path = dest_pairs[1];
            if(dist[min_dist_vertex] != Integer.MAX_VALUE && dist[destination] > path + dist[min_dist_vertex]){
                dist[destination] = path + dist[min_dist_vertex];
            }
        }
    }
 }


 //using priority queue ElogV


 static class Pair{
    int vertex;
    int distance;
    Pair(int vertex, int distance){
        this.vertex = vertex;
        this.distance = distance;
    }	
}

 static void dijsktra_pq(List<List<int[]>> graph,int n, int src){
    boolean[]vis = new boolean[n];
    int[] dist = new int[n];
    Arrays.fill(dist,Integer.MAX_VALUE);

    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance);
    dist[src] = 0;
    pq.offer(new Pair(src,0));
    
    while(pq.size()>0){
        //pick min distance vertex
        int min_dist_vertex = pq.poll().vertex;
        vis[min_dist_vertex] = true;
        //relax neighbours
        int destination, path;

        for(int[] dest_pairs : graph.get(min_dist_vertex)){
            destination = dest_pairs[0];
            if(vis[destination]) continue;
            path = dest_pairs[1];
            if(dist[min_dist_vertex] != Integer.MAX_VALUE && dist[destination] > path + dist[min_dist_vertex]){
                dist[destination] = path + dist[min_dist_vertex];
            }
            pq.offer(new Pair(destination, dist[destination]));
        
        }
     }
    }
}
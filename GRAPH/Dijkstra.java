package GRAPH;

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

    void explore_neighbour(int graph[][],boolean visited[],int i,int V,int dis[]){
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
        explore_neighbour(graph,visited,min_dist_vertex,V,distance);
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
}
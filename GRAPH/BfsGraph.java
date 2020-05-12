package GRAPH;
import java.util.*;
class BfsGraph{

    int V;
    LinkedList<Integer>[] graph;
    //vertex initialization
    BfsGraph(int V)
    {
        this.V = V;
        graph = new LinkedList[V];
        for(int i=0;i<V;i++){
            graph[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest){
            graph[src].add(dest);
    }

    public void bfs_util(Queue<Integer> queue,boolean[] visited, int v)
    {
        visited[v] = true;
        System.out.print(v+" ");
        for(int i=0;i<graph[v].size();i++){
            queue.add(graph[v].get(i));
            int node = queue.remove();
            if(!visited[node])
                bfs_util(queue, visited,node);
        }
        
        
    }
    public void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];
        for(int v=start;v<V;v++)
        {
            if(!visited[v])
                bfs_util(queue,visited,v);
        } 
    }

    public static void main(String args[]){
            BfsGraph g = new BfsGraph(4);
            g.addEdge(0, 1); 
            g.addEdge(0, 2); 
            g.addEdge(1, 2); 
            g.addEdge(2, 0); 
            g.addEdge(2, 3); 
            g.addEdge(3, 2); 

            g.bfs(3);

    }
}
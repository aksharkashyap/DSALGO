package GRAPH;
import java.util.*;

class CycleInDirectedGraph{
    List<List<Integer>> adj;
    int V;

    CycleInDirectedGraph(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }


    void addEdge(int src, int dest){
        adj.get(src).add(dest);
    }

    boolean isCycle(int v , boolean recStack[], boolean visited[]){
        if(recStack[v]) return true;
        if(visited[v]) return false;

        recStack[v] = true; // add to rec stack
        visited[v] = true;  //mark visited
        List<Integer> lis = adj.get(v);

        for(int i : lis)
            if(isCycle(i, recStack, visited))
                return true;

        recStack[v] = false;  //remove from rec stack
        return false;
    }

    boolean solve(){
        boolean recStack[] = new boolean[V];
        boolean visited[] = new boolean[V];
        for(int i=0; i<V;i++){  // case if graph is disconnected
            if(isCycle(i, recStack, visited))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        CycleInDirectedGraph graph = new CycleInDirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(1,3);
        System.out.println(graph.solve());
    }

}
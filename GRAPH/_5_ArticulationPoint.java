package GRAPH;
import java.util.*;

public class _5_ArticulationPoint {
    List<List<Integer>> graph;

    int disc[],low[],parent[];
    boolean visited[], AP[];
    int V,time=1;

    _5_ArticulationPoint(int v){
        V = v;
        low = new int[v];
        disc = new int[v];
        AP = new boolean[v];
        parent = new int[v];
        Arrays.fill(parent,-1);
        visited = new boolean[v];
        graph = new ArrayList<>();
        for(int i=0;i<v;i++) graph.add(new ArrayList<>());
    }
    void addEdge(int src, int dest){
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    void dfs(int u){
        int children=0;
        visited[u] = true;
        disc[u] = low[u] = time++;
        for(int v : graph.get(u)){
            if(!visited[v]){
                children++;
                parent[v] = u;
                dfs(v);
                low[u] = Math.min(low[u], low[v]);
                if(parent[u] == -1 && children > 1) AP[u] = true; //for root node
                if(parent[u] != -1 && low[v] >= disc[u]) AP[u] = true;
            }// Update low value of u for parent function calls. 
            else if(v != parent[u]){ //dont take low-link value from parent(it can happen when cycle is present, so avoid that)
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void solve(){
        for(int i=0;i<V;i++)
            if(!visited[i])
                dfs(i);
        System.out.println("number of APs :"+ Arrays.toString(AP));
    }
    
    public static void main(String[] args) {
        _5_ArticulationPoint g = new _5_ArticulationPoint(12);
        g.addEdge(0, 1); 
        g.addEdge(1, 2); 
        g.addEdge(1, 3); 
        g.addEdge(2, 3);
        g.addEdge(2, 4); 
        g.addEdge(3, 4); 
        g.addEdge(1, 5); 
        g.addEdge(0, 6); 
        g.addEdge(5, 6); 
        g.addEdge(5, 7);
        g.addEdge(5, 8); 
        g.addEdge(7, 8);
        g.addEdge(8, 9); 
        g.addEdge(10, 11); 

        g.solve();
    }
}
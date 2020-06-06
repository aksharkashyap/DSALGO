package GRAPH;
import java.util.*;
//cut egde
 class _4_Bridges {
    List<List<Integer>> graph;
    int disc[],low[],parent[];
    boolean visited[];
    int V,time=1, numOfbridges=0;
    _4_Bridges(int v){
        V = v;
        low = new int[v];
        disc = new int[v];
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
        visited[u] = true;
        disc[u] = low[u] = time++;
        for(int v : graph.get(u)){
            if(!visited[v]){
                parent[v] = u;
                dfs(v);
                low[u] = Math.min(low[u], low[v]);
                if(low[v]>disc[u]){
                    System.out.println(u + "-" + v);
                    numOfbridges++;
                }
            }
            else if(v!=parent[u]){
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void solve(){
        int src = 0;
        dfs(src); 
        System.out.println("Total number of bridges :"+ numOfbridges);
    }
    
    public static void main(String[] args) {
        _4_Bridges g = new _4_Bridges(6);
        g.addEdge(0,1);
        g.addEdge(1,5);
        g.addEdge(1,3);
        g.addEdge(1,2);
        g.addEdge(3,4);

        g.solve();
    }
}
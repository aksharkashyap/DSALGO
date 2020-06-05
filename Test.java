
import java.util.*;
//strongly connected component

class TarjensAlgo{
    int low[], ID[];
    int id=0;
    boolean onStack[];
    Deque<Integer> stack;
    int V;
    List<List<Integer>> graph;

    TarjensAlgo(int V){
        this.V = V;
        graph = new ArrayList<>();
        stack = new ArrayDeque<>();
        onStack = new boolean[V];
        low = new int[V];
        ID = new int[V];
        Arrays.fill(ID, -1);
       
        for(int i=0;i<V;i++) graph.add(new ArrayList<>());
    }

    void addEdge(int src, int dest){
        graph.get(src).add(dest); //directed graph
    }

    void dfs(int u) {
        stack.push(u);
        onStack[u] = true;
        ID[u] = low[u] = id++;
    
        for (int v : graph.get(u)) {
          if (ID[v] == -1) dfs(v);
          if (onStack[v]) low[u] = Math.min(low[u], low[v]);
        }
    
        if (ID[u] == low[u]) {
          for (int node = stack.pop(); ; node = stack.pop()) {
            System.out.print(node +" ");
            onStack[node] = false;
            low[node] = ID[u];
            if (node == u) break;
          }
          System.out.println();

        }
      }

    void solve(){
        for(int i=0;i<V;i++)
            if(ID[i] == -1) dfs(i);
    }

    public static void main(String[] args) {
        TarjensAlgo g = new TarjensAlgo(8);
        g.addEdge(0,1);g.addEdge(0,4);
        g.addEdge(4,0);g.addEdge(4,5);
        g.addEdge(5,6);g.addEdge(6,7);
        g.addEdge(7,3);g.addEdge(3,6);
        g.addEdge(2,6);g.addEdge(1,5);
        g.addEdge(2,3);g.addEdge(2,1);
        
        g.solve();
    }
}
package GRAPH;
import java.util.*;
//strongly connected component

class TarjensAlgo{
    int low_link[];
    int disc[]; //discovery time
    int time=0;
    boolean onStack[];
    Deque<Integer> stack;
    int V;
    List<List<Integer>> graph;

    TarjensAlgo(int V){
        this.V = V;
        graph = new ArrayList<>();
        stack = new ArrayDeque<>();
        onStack = new boolean[V];
        low_link = new int[V];
        disc = new int[V];
        Arrays.fill(disc, -1);
        for(int i=0;i<V;i++) graph.add(new ArrayList<>());
    }

    void addEdge(int src, int dest){
        graph.get(src).add(dest); //directed graph
    }

    void dfs(int u){
    
        onStack[u] = true;
        disc[u] = low_link[u] = time++;
        stack.push(u);

        for(int v : graph.get(u)){
            if(disc[v]==-1) dfs(v);
            if(onStack[v]) low_link[u] = Math.min(low_link[u], low_link[v]);
        }

        if(low_link[u] == disc[u]){
            for(int x = stack.pop(); ;x=stack.pop()){
                onStack[x] = false; 
                System.out.print(x+" ");
                if(x == u) break;
            }
            System.out.println();
        }   

    }

    void solve(){
        for(int i=0;i<V;i++)
            if(disc[i]==-1) dfs(i);
       
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
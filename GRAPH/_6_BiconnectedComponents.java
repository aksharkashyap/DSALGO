package GRAPH;
import java.util.*;

public class _6_BiconnectedComponents {
    List<List<Integer>> graph;
    Deque<Edge> stack;
    int[]parent,disc,low;
    int v,time=0;
    int count=0;
    class Edge { 
        int u; 
        int v; 
        Edge(int u, int v) 
        { 
            this.u = u; 
            this.v = v; 
        } 
    }

    _6_BiconnectedComponents(int v){
        this.v = v;
        graph = new ArrayList<>();
        parent = new int[v];
        disc = new int[v];
        low = new int[v];
        stack = new ArrayDeque<>();
        Arrays.fill(parent,-1);
        for(int i=0;i<v;i++) graph.add(new ArrayList<>());
    }

    void addEdge(int src, int dest){
        graph.get(src).add(dest);
    }

    void dfs(int u){
        int children=0;
        disc[u]=low[u]= ++time;

        for(int v : graph.get(u)){
            if(disc[v] == 0){
                children++;
                stack.push(new Edge(u,v));
                parent[v] = u;
                dfs(v);
                low[u] = Math.min(low[u],low[v]);
                if((disc[u] == 1 && children > 1) || 
                    (disc[u] > 1 && low[v] >= disc[u])){
                    printComponents(u,v);
                    count++;
                }
            }
            else if(v != parent[u] && disc[v] < disc[u]){
                low[u] = Math.min(low[u], disc[v]);
                stack.push(new Edge(u,v));
            }
           
        }
    }

    void printComponents(int u, int v){

        while(stack.peek().u !=u || stack.peek().v !=v){
           
            System.out.print(stack.peek().u + "--" + stack.peek().v + " "); 
            stack.pop();

        }
       System.out.println(stack.peek().u + "--" + stack.peek().v + " ");
       stack.pop();
    }

    void solve(){

        for(int i=0;i<v;i++)
            if(disc[i]==0) dfs(i);
        
        int j = 0; 
  
            // If stack is not empty, pop all edges from stack 
        while (stack.size() > 0) { 
            j = 1; 
            System.out.print(stack.peek().u + "--" + stack.peek().v + " "); 
            stack.pop(); 
        } 
        if (j == 1) { 
            System.out.println(); 
            count++;
        } 
       
    }
    
    public static void main(String[] args) {
        _6_BiconnectedComponents g = new _6_BiconnectedComponents(12);
        g.addEdge(0, 1); 
		g.addEdge(1, 0); 
		g.addEdge(1, 2); 
		g.addEdge(2, 1); 
		g.addEdge(1, 3); 
		g.addEdge(3, 1); 
		g.addEdge(2, 3); 
		g.addEdge(3, 2); 
		g.addEdge(2, 4); 
		g.addEdge(4, 2); 
		g.addEdge(3, 4); 
		g.addEdge(4, 3); 
		g.addEdge(1, 5); 
		g.addEdge(5, 1); 
		g.addEdge(0, 6); 
		g.addEdge(6, 0); 
		g.addEdge(5, 6); 
		g.addEdge(6, 5); 
		g.addEdge(5, 7); 
		g.addEdge(7, 5); 
		g.addEdge(5, 8); 
		g.addEdge(8, 5); 
		g.addEdge(7, 8); 
		g.addEdge(8, 7); 
		g.addEdge(8, 9); 
		g.addEdge(9, 8); 
		g.addEdge(10, 11); 
		g.addEdge(11, 10); 
        g.solve();
        System.out.println("Above are " + g.count + " biconnected components in graph");
    }
}
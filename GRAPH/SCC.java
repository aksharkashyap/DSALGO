package GRAPH;
import java.util.Arrays;
import java.util.Stack;
//STRONGLY CONNECTED COMPONENTS(directed graph)

public class SCC {
    //dfs+stack,transpose,pop+dfs
    Stack<Integer> stack = new Stack<>();
    boolean visited[] = new boolean[5];

    void push_dfs(int graph[][], int V, int v){
        visited[v] = true;
        for(int i=0;i<V;i++)
            if(graph[v][i] !=0 && !visited[i])
                push_dfs(graph, V, i);
        stack.push(v);
    }

    void _dfs(int graph[][], int V, int v){
        visited[v] = true;
        System.out.print(v+ " ");
        for(int i=0;i<V;i++)
            if(graph[v][i] !=0 && !visited[i])
                _dfs(graph, V, i);
    }

    void pop_dfs(int graph[][], int V){

       while(stack.size() !=0){
         int popped = stack.pop();
         if(!visited[popped])
            _dfs(graph, V,popped);
         System.out.println();
       }

    }

    void transpose(int graph[][], int V){
        
        for(int r=0;r<V;r++){
            for(int c=r+1;c<V;c++){
                int x = graph[r][c];
                graph[r][c] = graph[c][r];
                graph[c][r] = x;
            }
        }
    }

    void print(int graph[][], int V){
        System.out.println();
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        SCC s = new SCC();
        int g[][]={
            {0,0,1,1,0},
            {1,0,0,0,0},
            {0,1,0,0,0},
            {0,0,0,0,1},
            {0,0,0,0,0}
        };
        int V = g[0].length;
        for(int i=0; i<V;i++)
            if(!s.visited[i]) s.push_dfs(g,V,i);
    
        s.transpose(g,V);
          
        Arrays.fill(s.visited, false);
        s.pop_dfs(g,V);
       
    }
}

/**
 * SCC algorithms can be used as a first step in many graph algorithms that work only on strongly 
 * connected graph.In social networks, a group of people are generally strongly connected (For example, 
 * students of a class or any other common place). Many people in these groups generally like some common 
 * pages or play common games. The SCC algorithms can be used to find such groups and suggest the commonly 
 * liked pages or games to the people in the group who have not yet liked commonly liked a page or played a 
 * game.
 */

 //brute forc -> n^3
 //kosarajun -> n two pass
 // tarjan -> n single pass
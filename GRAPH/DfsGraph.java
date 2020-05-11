package GRAPH;
import java.util.*;
class DfsGraph{
    int V;
    LinkedList<Integer>[] graph;

    DfsGraph(int V){
        this.V=V;
        graph = new LinkedList[V];
        for(int i=0;i<V;i++)
            graph[i] = new LinkedList<>();
    }

    public void add_edge(int src, int dest){
        graph[src].add(dest);
    }

    //note-- need not to use extra stack in dfs because recursive call is itself using call stack function.... which will perfom our task
    public void dfs_util(Stack stack, boolean[] visited, int v){
        visited[v] = true;
       // boolean check=false;
        System.out.print(v+" ");
       // stack.push(v);

      //  int peek = (int) stack.peek();
        for(int i=0;i<graph[v].size();i++)
            {
                if(!visited[graph[v].get(i)])
                        {
                        dfs_util(stack, visited, graph[v].get(i));
                      //  check = true;
                        }
            }
           // if(!check)
             //   stack.pop();
    }

    public void dfs(){
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i])
                dfs_util(stack,visited,i);
        }
    }

    public static void main(String args[]){

         DfsGraph g = new DfsGraph(6);
         g.add_edge(1,0);g.add_edge(0,1);
         g.add_edge(1,3);g.add_edge(3,1);
         g.add_edge(4,3);g.add_edge(3,4);
         g.add_edge(4,0);g.add_edge(0,4);
         g.add_edge(0,2);g.add_edge(2,0);
         g.add_edge(0,5);g.add_edge(5,0);
         g.dfs();
    }

}
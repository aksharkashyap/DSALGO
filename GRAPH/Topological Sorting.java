package GRAPH;

import java.util.*;

class TopologicalSort{
    int V;
    LinkedList<Integer>[] graph;
    
    TopologicalSort(int V){
        this.V = V;

        graph = new LinkedList[V]; //array of linkedlist
        for(int i=0;i<V;i++)
        {
            graph[i] = new LinkedList<>();
        }
    }

    public void sortUtil(int v, Stack stack, boolean[]visited){

        visited[v] = true;
        Iterator<Integer> itr = graph[v].iterator();
        Integer i;
        while(itr.hasNext()){
             i = itr.next();
             if(!visited[i])
                    sortUtil(i, stack, visited);
        }
        stack.push(v);
       
    }

    public void sort_topological(){
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        //Arrays.fill(visited,false);

        for(int i=0;i<V;i++)
                if(!visited[i])
                        sortUtil(i, stack, visited);
        
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop()+" ");
        }

                    

    }
    public void add_Edge(int src, int dest){
           graph[src].add(dest);
    }

    public void printGraph() 
    {        
        for(int i = 0; i <V; i++) 
        { 
            System.out.println("Adjacency list of vertex "+ i); 
            System.out.print("head"); 
            for(Integer pCrawl: graph[i]){ 
                System.out.print(" -> "+pCrawl); 
            } 
            System.out.println("\n"); 
        } 
    } 

    public static void main(String args[]){
        TopologicalSort graph = new TopologicalSort(6);
        graph.add_Edge(5,0);
        graph.add_Edge(5,2);
        graph.add_Edge(4,0);
        graph.add_Edge(4,1);
        graph.add_Edge(3,1);
        graph.add_Edge(2,3);
       // graph.printGraph();
       graph.sort_topological();
    }
}
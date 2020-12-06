package GRAPH;
import java.util.*;

/**
 * Dial's algorithm(optimized disktra)
 * O(E + (maxWeight * V))
 */ 

class Node{
    Node prev,next;
    int data;
    Node(int data){
    this.data = data;
    }
} 

class Graph{
    int v;
    List<List<int[]>> edges;

    Graph(int v){
        this.v=v;
        edges = new ArrayList<>();
        for(int i=0;i<v;i++) edges.add(new ArrayList<>());

        //doubly linkedlist initialize

    }

    void addEdge(int src, int dest, int weight){
        edges.get(src).add(new int[]{dest,weight});
        edges.get(dest).add(new int[]{src,weight});
    }
    //distance and iterator
    //List<Pair> = new ArrayList<>();

    
}

public class Dijsktra_dial {
    public static void main(String[] args) {
          // create the graph given in above fugure 
    int V = 9; 
    Graph g = new Graph(V); 
  
    //  making above shown graph 
    g.addEdge(0, 1, 4); 
    g.addEdge(0, 7, 8); 
    g.addEdge(1, 2, 8); 
    g.addEdge(1, 7, 11); 
    g.addEdge(2, 3, 7); 
    g.addEdge(2, 8, 2); 
    g.addEdge(2, 5, 4); 
    g.addEdge(3, 4, 9); 
    g.addEdge(3, 5, 14); 
    g.addEdge(4, 5, 10); 
    g.addEdge(5, 6, 2); 
    g.addEdge(6, 7, 1); 
    g.addEdge(6, 8, 6); 
    g.addEdge(7, 8, 7); 
    //  maximum weighted edge - 14 
    //g.shortestPath(0, 14); 
    }
}

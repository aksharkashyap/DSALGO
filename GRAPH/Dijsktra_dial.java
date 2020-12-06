package GRAPH;
import java.util.*;

/**
 * Dial's algorithm(optimized disktra)
 * O(E + (maxWeight * V))
 */ 

 /*note: linkedlist in java is implemented using doubly linkedlist so remove operation through reference is O(1)

 thats why I created a class Node to store the vertex and its reference so that we can remove it from the the bucket in O(1)
 */

class Graph{
    int v;
    List<List<int[]>> edges;

    class Pair{
        int distance;
        Node node_ref;
        Pair(){
            distance = Integer.MAX_VALUE;
            node_ref = null;
        }
    }
    class Node{
        int vertex;
        Node(int vertex){this.vertex=vertex;}
    }

    Graph(int v){
        this.v=v;
        edges = new ArrayList<>();
        for(int i=0;i<v;i++) edges.add(new ArrayList<>());
    }

    void addEdge(int src, int dest, int weight){
        edges.get(src).add(new int[]{dest,weight});
        edges.get(dest).add(new int[]{src,weight});
    }
    //distance and iterator
    //List<Pair> = new ArrayList<>();

    void shortestPath(int src, int maxWeight){
        int X = maxWeight * v;
        List<LinkedList<Node>> buckets = new ArrayList<>();
        for(int i=0;i<X+1;i++) buckets.add(new LinkedList<>());
        List<Pair> dist = new ArrayList<>(v); //distance and reference of node
        for(int i=0;i<v;i++) dist.add(new Pair());
        dist.get(src).distance = 0;
        buckets.get(0).add(new Node(src));
        int idx = 0;
        while(true){
            while(buckets.get(idx).size() == 0 && idx < X) idx++;
            if(idx == X) break;
            //take top vertex from bucket and pop it
            int u = buckets.get(idx).removeFirst().vertex;
         
            //process all neighbors
            for(int[] pairs : edges.get(u)){
                int v = pairs[0];
                int weight = pairs[1];
                int du = dist.get(u).distance;
                int dv = dist.get(v).distance;
                if(dv > du + weight){
                    if(dv != Integer.MAX_VALUE){
                        //if dv is not INF then it must be present in bucket so remove it via reference O(1)
                        buckets.get(dv).remove(dist.get(v).node_ref);
                    }
                    //update distance
                    dist.get(v).distance = du + weight;
                    dv = dist.get(v).distance;
                    //push vertex into updated distance bucket
                    buckets.get(dv).addFirst(new Node(v));
                    //storing updated reference
                    dist.get(v).node_ref = buckets.get(dv).getFirst();
                }
            }
        }

        for(int i=0;i<v;i++){
            System.out.println(i+" " +dist.get(i).distance);
        }

    }

    
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
    g.shortestPath(0, 14); 
    }
}

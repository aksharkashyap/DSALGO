package GRAPH;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphColoring {
    static LinkedList<Integer> graph[];
    static int V;
    GraphColoring(int v){
        V=v;
        graph = new LinkedList[v];
        for(int i=0;i<v;i++)
            graph[i] = new LinkedList<>();
    }

     static void edge(int src, int dest){
        graph[src].add(dest);
        graph[dest].add(src);
    }

     static void printGraph(){
         for(int i=0;i<V;i++){
             System.out.print(i+" ");
            Iterator itr = graph[i].iterator();
            while(itr.hasNext())
                   System.out.print(itr.next()+" ");
            System.out.println();
        }
    }

    static void graph_color(){
        int result[] = new int[V];
        Arrays.fill(result,-1); // all vertices as unassigned

        result[0] = 0;
        boolean available[] = new boolean[V];
        //Arrays.fill(available,true); // all colors available initially

        //assign colors to remaining n-1 vertices
        for(int u=1;u<V;u++){
                Arrays.fill(available,true); // true for next iteration
                Iterator<Integer> itr = graph[u].iterator();
                while(itr.hasNext())
                {   int i = itr.next();
                    if(result[i] != -1)
                        available[result[i]] = false;
                }
                //find the first available color
                int color;
                for(color=0;color<V;color++)
                    if(available[color])
                        break;
                result[u] = color; //assgin the found color
               
            }
            for(int u=0;u<V;u++)
                System.out.println("Vertex "+ u + " ---> Color " + result[u]);
    }

    public static void main(String[] args) {
        GraphColoring graph = new GraphColoring(5);
        edge(0, 1);
        edge(1, 3);
        edge(3, 2);
        printGraph();
        graph_color();
    }
}
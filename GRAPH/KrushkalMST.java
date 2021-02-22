package GRAPH;

import java.util.Comparator;
import java.util.PriorityQueue;

/*A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, 
edge-weighted undirected graph that connects all the vertices together, 
without any cycles and with the minimum possible total edge weight.
*/

class KrushkalMST{
    static UnionFIND_AK uf;
    class Edge{
        int src,dest,weight;
        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    void solve(PriorityQueue<Edge> pq, int V){
        int src,dest;
        int mst[][] = new int[V][V];

        while(pq.size() !=0){
            Edge minEdge = pq.poll();
            src = minEdge.src;
            dest = minEdge.dest;

            if(!uf.isFriend(src, dest)){    //isCycle
                mst[src][dest] = minEdge.weight;
                mst[dest][src] = minEdge.weight;
                uf.union(src, dest);
            }
        }
        print(mst,V);
    }
    public static void main(String[] args) {
        KrushkalMST m =  new KrushkalMST();
        /*int graph[][] = {
            {0,15,0,0,10},
            {15,0,9,7,3},
            {0,9,0,5,13},
            {0,7,5,0,0},
            {10,3,13,0,0}
        };*/
        int V = 5;
        uf = new UnionFIND_AK(V);

        //initialize edges
        Edge[] edge = new Edge[7];
        int e=0;

        edge[e++] = m.new Edge(0,1,15);
        edge[e++] = m.new Edge(1,4,3);
        edge[e++] = m.new Edge(1,2,9);
        edge[e++] = m.new Edge(1,3,7);
        edge[e++] = m.new Edge(2,4,13);
        edge[e++] = m.new Edge(4,0,10);
        edge[e++] = m.new Edge(2,3,5);

        // create priority queue and sort  it according to min weight edge
        PriorityQueue<Edge> pq = new PriorityQueue<>(m.new Sort());
        for(int i=0;i<edge.length;i++) pq.offer(edge[i]);
        m.solve(pq,V);

    }

    class Sort implements Comparator<Edge>{
        @Override
        public int compare(Edge a, Edge b) {
            return a.weight - b.weight; 
        }   
    }

    void print(int [][]mst,int V){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(mst[i][j] +" ");
            }
            System.out.println();
        }
    }


}

/**
 * Time Complexity: O(ElogE) or O(ElogV). 
 * Sorting of edges takes O(ELogE) time. 
 * After sorting, we iterate through all edges and apply find-union algorithm. 
 * The find and union operations can take atmost O(LogV) time. So overall complexity is O(ELogE + ELogV) time. 
 * The value of E can be atmost O(V2), so O(LogV) are O(LogE) same. 
 * Therefore, overall time complexity is O(ElogE) or O(ElogV)
 */
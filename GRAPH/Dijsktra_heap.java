package GRAPH;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class Dijsktra_heap {
//ElogV (Time complexity )
    class Pair{ 
        int dest,weight;
        Pair(int dest, int weight){
            this.dest=dest;
            this.weight=weight;
        }
    }
    class vd{
        int vertex,dist;
        vd(int vertex, int dist){this.dist=dist;this.vertex=vertex;}
    }
    int v;
    vd dist[];
    boolean vis[];
    List<List<Pair>> graph = new ArrayList<>();
    PriorityQueue<vd> pq = new PriorityQueue<>((a,b)-> a.dist-b.dist);

    Dijsktra_heap(int v){
        this.v=v;
        dist = new vd[v];
        vis = new boolean[v];
        dist[0] = new vd(0,0);
        for(int i=0;i<v;i++) graph.add(new ArrayList<>());
        for(int i=1;i<v;i++) dist[i] = new vd(i,Integer.MAX_VALUE);
    }

    void addEdge(int src, int dest, int weight){
        graph.get(src).add(new Pair(dest,weight));
        graph.get(dest).add(new Pair(src,weight));
    }

    void dijsktra(vd src){

        for(Pair p : graph.get(src.vertex)){
                if(!vis[p.dest]){
                    if(src.dist!=Integer.MAX_VALUE && (src.dist + p.weight) < dist[p.dest].dist){
                        dist[p.dest].dist = src.dist + p.weight;
                    }
                    vis[p.dest] = true;
                    dijsktra(dist[p.dest]);
                    vis[p.dest] = false;
                }
        }
    }

    void solve(){
        for(int i=0;i<v;i++) pq.add(dist[i]);
        while(pq.size()>0){
            vd src = pq.poll();
            vis[src.vertex] = true;
            dijsktra(src);
            vis[src.vertex] = false;
        }
    }

    public static void main(String[] args) {
       Dijsktra_heap obj = new Dijsktra_heap(5);
       obj.addEdge(0, 1, 25);
       obj.addEdge(0, 3, 2);
       obj.addEdge(1, 4, 6);
       obj.addEdge(4, 3, 5);
       obj.addEdge(2, 3, 5);
       obj.solve();
       for(int i=0;i<obj.dist.length;i++){
        System.out.println(obj.dist[i].vertex+" "+ obj.dist[i].dist);
       }
    }
}


package GRAPH;
import java.util.*;
//Below is the link to understand union by rank and path compression
//https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/#:~:text=The%20idea%20of%20path%20compression,nodes%20under%20x%20also%20compresses.&text=Following%20is%20union%20by%20rank,a%20cycle%20in%20a%20graph.
//we can also use union find algorithm to detect cyle in undirected graph

//this method is useful when the worst case happens(skewd graph(becomes linkedlist)) then O(n) find operation
//but by using path compression it will become O(logn)
//and combining both strategy the time complexity further reduces to almost constant(amortized)
//disjoint set
class UnionFIND_AK{
    int V;
    int total_sets;
    int parent[];
    int size[];

    UnionFIND_AK(int V){
        this.V=V;
        total_sets = V;
        parent = new int[V];
        size = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    void union(int a, int b){

         int x = find(a);
         int y = find(b);
         if(x == y){
             return;
         }
         //union by rank
         if(size[x] >= size[y]){
            parent[y] = x;
            size[x] += size[y];
         }else{
             parent[x] = y;
             size[y] += size[x];
         }
         total_sets--;
    }

    int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]); //path compression 
    }

    boolean isFriend(int a, int b){
        return parent[a]==parent[b];
    }
    

    public static void main(String[] args) {
      
        UnionFIND_AK t = new UnionFIND_AK(3);

        int graph[][]= {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph.length;j++){
                if(graph[i][j] == 1) t.union(i,j);
            }
        }
        System.out.print(t.total_sets);
    }
}
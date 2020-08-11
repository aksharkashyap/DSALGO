import java.io.*;
import java.util.*;

 class Test {
    List<List<Integer>> graph = new ArrayList<>();
    int V;
    int[] parent;
    int[] size;
    int components;

    void init_graph(int v){
        V = v;
        components = v;
        parent = new int[v];
        size = new int[v];
        Arrays.fill(size,1);
        for(int i=0;i<v;i++) parent[i] = i;
        for(int i=0;i<v;i++) graph.add(new ArrayList<>());
    }

    int find(int v){
        if(v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

    void union(int a, int b){
        int p1 = find(a);
        int p2 = find(b);
        if(p1 == p2) return;
        if(size[p1]<size[p2]){
            size[p2] += size[p1];
            parent[p1] = p2;
        }
        else{
            size[p1] += size[p2];
            parent[p2] = p1;
        }
        components--;
    }

    public static void main(String[] args) {
        
    }
}
/**
 * iterative inorder,postoder,pre
 */

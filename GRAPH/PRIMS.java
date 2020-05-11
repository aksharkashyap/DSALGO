package GRAPH;
import java.util.*;

class PRIMS{

    void prims_mst(int adj[][],int v){
        boolean visited[] = new boolean[v];
        int parent[] = new int[v];
        int weight[]= new int[v];
        for(int i=0;i<v;i++)
                 weight[i] = Integer.MAX_VALUE;
        weight[0] = 0;
        parent[0] = -1;

        for(int i=0;i<v;i++){
            int minVertex = findMinVertex(weight,visited);

            for(int j=0;j<v;j++){

                if(!visited[j] && adj[minVertex][j]!=0 && adj[minVertex][j] != Integer.MAX_VALUE){
                        int possibleMinWeight = adj[minVertex][j];
                        if(possibleMinWeight < weight[j])
                                {
                                    weight[j] = possibleMinWeight;
                                    parent[j] = i;
                                }
                }
            }
        }

        for(int i: weight)
            System.out.print(i+" ");


        }


        int findMinVertex(int weight[],boolean[] visited)
        {
            int minVertex = -1;
            int minWeight = Integer.MAX_VALUE;
            for(int i=0;i<weight.length;i++)
                {
                    if(weight[i] < minWeight && !visited[i])
                        {   minWeight = weight[i];
                            minVertex = i;
                            visited[i] = true;
                        }
                }
                //System.out.print("min vertex: "+ minVertex);
                return minVertex;
        }



    public static void main(String args[]){

        PRIMS p = new PRIMS();
        Scanner sc = new Scanner(System.in);
        int v = 5;
        int adj[][] = new int[v][v];
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                adj[i][j] = sc.nextInt();
        p.prims_mst(adj, v);
    }

}

/*
0 4 8 0 0
4 0 2 6 0
8 2 0 3 9
0 6 3 0 5
0 0 9 5 0
*/
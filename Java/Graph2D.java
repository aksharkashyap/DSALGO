//Graph-2d array
// add edge, remove edge
// add vertex, remove vertex
// disadvantage - fixed size array

package Java;

class Graph2D{
    int n;
    int adj[][]=new int[10][10];;
    Graph2D(int n){
        this.n=n;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adj[i][j] = 0;
            }
        }
    }
    //undirected graph
    public void add_Edge(int src, int dest){
        adj[src][dest]=1;
        adj[dest][src]=1;
    }

    public void add_vertex(){
        n++;
        for(int i=0;i<n;++i){
            adj[i][n-1] = 0;
            adj[n-1][i] = 0;
        }
    }

    public void remove_vertex(int x){
        if(x>n)
        {
            System.out.println("vertex not present");
            return;
        }else
        {
            while(x<n)
            {   //shifting the row left side
                for(int i=0;i<n;i++)
                {
                    adj[i][x] = adj[i][x+1];
                }
                //shifting the coloumn to upper side
                for(int i=0;i<n;i++)
                {
                    adj[x][i] = adj[x+1][i];
                }
                x++;
            }
            n--;
        }
    }

    public void print_graph(){
        for(int i=0;i<n;i++){
            //System.out.print("'"+i+"'");
            for(int j=0;j<n;j++){
                System.out.print(" "+adj[i][j]);
            }
            System.out.println("\n");
        }
    }


public static void main(final String args[]){
    int nodes=5;
    Graph2D g = new Graph2D(nodes);
    g.add_Edge(0,1);
    g.add_Edge(0,3);
    g.add_Edge(1,2);
    g.add_Edge(2,3);
    //g.add_Edge(2,4);
   // g.print_graph();
    //g.add_vertex();
    //g.print_graph();
    //g.remove_vertex(1);
   // g.print_graph();


}
    

}
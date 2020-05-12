package Java;
import java.util.*;

//graph -
// add and remove nodes
// bfs bfs
class GraphLL{
    int V;
   static LinkedList<Integer> adj[];

    GraphLL(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
        {
         adj[i] = new LinkedList<>();   
        }
    }

    public void print_graph(){

        for(int i=0;i<V;i++){
           // System.out.print(" "+i);
           for(int j=0;j<adj[i].size();j++){
            System.out.print(" "+adj[i].get(j));
            }
           /* for(Integer a : adj[i])
            {
                System.out.print(" "+a);
            }*/
        System.out.print("\n");
    }
    }

    void BFS(int s) 
    { 
        boolean visited[] = new boolean[V]; 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            s = queue.poll(); 
            System.out.print(s+" "); 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 

    public void bfs(int s){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        boolean visited[] = new boolean[V];
        visited[s]=true;
        while(!q.isEmpty()){
            s = q.poll();
            System.out.println(s);
            for(int i=0;i<adj[s].size();i++)
            {
                if(!visited[i])
                {
                    q.add(adj[s].get(i));
                    visited[i]=true;
                }
            }
        }
    }

    void DFSUtil(int v,boolean visited[]) 
    { 
        visited[v] = true; 
        System.out.print(v+" "); 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
    void DFS(int v) 
    { 
        boolean visited[] = new boolean[V]; 
        DFSUtil(v, visited); 

        /*   //for disconnected graph- we have to call recursive function for every vertex- if its not visited
        
             for (int i=0; i<V; ++i) 
                if (visited[i] == false) 
                    DFSUtil(i, visited); 
                    
                */
    }

    boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack){
        
        if(recStack[i])
            return true;
        if(visited[i])
            return false;

        visited[i]=true;
        recStack[i]=true;

        ListIterator<Integer> itr = adj[i].listIterator();
        while(itr.hasNext()){
            int n = itr.next();
            if(isCyclicUtil(n,visited,recStack))
                return true;
        }
        recStack[i]=false;
        return false;
    }

    boolean isCyclic(){

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i=0;i<V;i++)
            if(isCyclicUtil(i,visited,recStack))
                return true;

        return false;
    }


    public void addEdge(int src, int dest){
       //directed graph
        adj[src].add(dest);
   

     /*//undirected graph
        adj[src].add(dest);
        adj[dest].add(src);
     
     */
    }
    public static void main(String args[]){
            GraphLL g = new GraphLL(5);
            g.addEdge(0, 1); 
            g.addEdge(1, 2); 
            g.addEdge(2, 3); 
            g.addEdge(3, 0);  
            g.addEdge(1, 4);  
            //g.print_graph();
            int START_NODE =3;
           // g.bfs(START_NODE);
            //g.DFS(START_NODE);
            if(g.isCyclic())
                System.out.println("cycle");
            else System.out.println("no cycle");
    }

}
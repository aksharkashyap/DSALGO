package GRAPH;
import java.io.*; 
import java.util.*;

//we can also use union find algorithm and bfs

public class CycleInUndirectedGraph {
  
	private int V;
	private LinkedList<Integer> adj[]; 

	CycleInUndirectedGraph(int v) { 
		V = v; 
		adj = new LinkedList[v]; 
		for(int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	void addEdge(int v,int w) { 
		adj[v].add(w); 
		adj[w].add(v); 
	} 

	// A recursive function that uses visited[] and parent to detect cycle in subgraph reachable from vertex v. 
	Boolean isCyclicUtil(int v, Boolean visited[], int parent) 
	{ 
		
		visited[v] = true; 
		Integer i; 

		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> it = adj[v].iterator(); 
		while (it.hasNext()) 
		{ 
			i = it.next(); 
			// If an adjacent is not visited, then recur for that 
			// adjacent 
			if (!visited[i]){ 
				if (isCyclicUtil(i, visited, v)) 
					return true; 
			} 
			// If an adjacent is visited and not parent of current vertex, then there is a cycle. 
			else if (i != parent) 
				return true; 
		} 
		return false; 
	} 

	
	Boolean isCyclic() 
	{ 
		
		Boolean visited[] = new Boolean[V]; 
	
		// Call the recursive helper function to detect cycle in different DFS trees 
		for (int u = 0; u < V; u++) 
			if (!visited[u]) // Don't recur for u if already visited 
				if (isCyclicUtil(u, visited, -1)) 
					return true; 

		return false; 
	} 


	// Driver method to test above methods 
	public static void main(String args[]) 
	{ 
		// Create a graph given in the above diagram 
		CycleInUndirectedGraph g1 = new CycleInUndirectedGraph(5); 
		g1.addEdge(1, 0); 
		g1.addEdge(0, 2); 
		g1.addEdge(2, 1); 
		g1.addEdge(0, 3); 
		g1.addEdge(3, 4); 
		if (g1.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't contains cycle"); 

        CycleInUndirectedGraph g2 = new CycleInUndirectedGraph(3); 
		g2.addEdge(0, 1); 
		g2.addEdge(1, 2); 
		if (g2.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't contains cycle"); 
	} 
} 
// This code is contributed by Aakash Hasija 

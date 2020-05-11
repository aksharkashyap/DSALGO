package GRAPH;
import java.util.*;

public class Bfs2 {
	static Queue<Integer> queue = new LinkedList<>();
    
    static void bfs(int[][]graph,boolean[]visited,int V){
		System.out.print(V+" ");
		for(int i=0;i<graph[V].length;i++)
			if(graph[V][i] == 1 && !visited[i]) {
				visited[i] = true;
				queue.offer(i);
			}

		while(queue.size()>0) bfs(graph, visited, queue.poll());
	}

	public static void main(String[] args) {
		int graph[][] = {
			{0,1,0,1,0},{1,0,1,0,1},{0,1,0,0,0},{1,0,0,0,1},{0,1,0,1,0}
		};
		int n = graph.length;
		boolean visited[] =  new boolean[n];
		for(int i=0;i<n;i++)
			if(!visited[i]) {
				visited[i] = true;
				bfs(graph, visited,i);
			}
	}
}

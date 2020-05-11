package GRAPH;

import java.util.*;
//the only diff from dfs is that we are using addnl stack apart from the recursion function-call-stack
class Topological2{
	static Stack<Integer> stack = new Stack<>();
	static void dfs_topology(int[][]graph,boolean[]visited,int V){

		for(int i=0;i<graph[V].length;i++){

			if(graph[V][i] == 1 && !visited[i]){
				visited[i] = true;
				dfs_topology(graph, visited, i);
			}
		}
		stack.push(V); // this is the extra step from dfs
	}


	public static void main(String[] args) {
		int graph[][] = {
			{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,1,0,0},{0,1,0,0,0,0},{1,1,0,0,0,0},{1,0,1,0,0,0}
		};
		int n = graph.length;
		boolean visited[] =  new boolean[n];
		for(int i=0;i<n;i++)
			if(!visited[i]) {
				visited[i] = true;
				dfs_topology(graph, visited,i);
			}
		while(stack.size()>0) System.out.print(stack.pop()+" ");
	}
}
package GRAPH;

class Dfs2{
	
	static void dfs(int[][]graph,boolean[]visited,int V){

		for(int i=0;i<graph[V].length;i++){
			if(graph[V][i]==1 && !visited[i]){
				visited[i] = true;
				dfs(graph, visited, i);
			}
		}
		System.out.print(V+" ");
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
				dfs(graph, visited,i);
			}
	}
}
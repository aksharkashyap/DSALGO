package _CP_Template;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CodeChef_test
{   

    public static void main (String[] args) throws java.lang.Exception
	{
		FastReader fs = new FastReader();
		//int t = fs.nextInt();
		//while(t-- > 0){
			solve(fs);
		//}
			
	}

	static void solve(FastReader fs){
		int n = fs.nextInt(); //num of cities
		int m = fs.nextInt(); //roads
		int q = fs.nextInt(); //queries

		List<List<int[]>> graph = new ArrayList<>();

		for(int i=0;i<n;i++) graph.add(new ArrayList<>());

		int a,b,L;
		for(int i=0;i<m;i++){
			a = fs.nextInt();
			b = fs.nextInt();
			L = fs.nextInt();
			graph.get(a).add(new int[]{b,L});
			graph.get(b).add(new int[]{a,L});
			/**
			 * connect A-B and B-A
			 * L is distance
			 */
		}
		int[]srcs = new int[q];
		for(int i=0;i<q;i++){
			srcs[i] = fs.nextInt();
		}
		int src_city;
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<q;i++){
			src_city = srcs[i];
			int[] ans = compute(graph,n,src_city);
			sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
		}
		print(sb);
	}

	static class Pair{
		int vertex;
		int distance;
		Pair(int vertex, int distance){
			this.vertex = vertex;
			this.distance = distance;
		}	
	}

	static int[] compute(List<List<int[]>> graph,int n, int src){
		boolean[]vis = new boolean[n];
		int[] dist = new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);

		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance);
		dist[src] = 0;
		pq.offer(new Pair(src,0));
		
		while(pq.size()>0){
			//pick min distance vertex
			int min_dist_vertex = pq.poll().vertex;
			vis[min_dist_vertex] = true;
			//relax neighbours
			int destination, path;

			for(int[] dest_pairs : graph.get(min_dist_vertex)){
				destination = dest_pairs[0];
				if(vis[destination]) continue;
				path = dest_pairs[1];
				if(dist[min_dist_vertex] != Integer.MAX_VALUE && dist[destination] > path + dist[min_dist_vertex]){
					dist[destination] = path + dist[min_dist_vertex];
				}
				pq.offer(new Pair(destination, dist[destination]));
			
			}
		}

		int maxans = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(dist[i] != Integer.MAX_VALUE 
				&& maxans < dist[i]) maxans = dist[i];
		}
		int count = 0;
		for(int i=0;i<n;i++){
			if(dist[i] == maxans) count++;
		}

		return new int[]{maxans,count};
	}
	


	//-------------------------------------------------
	static void print(int n){System.out.println(n);}
	static void print(long n){System.out.println(n);}
	static void print(double n){System.out.println(n);}
	static void print(StringBuilder s){System.out.println(s);}
	static void print(String s){System.out.println(s);}
	static final int MOD = (int) 1e9+7;
	static final int INT_MAX = Integer.MAX_VALUE;
	static final int INT_MIN = Integer.MIN_VALUE;
	static void swap(int[]arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	static int[] arrayInput(FastReader fs, int n){
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = fs.nextInt();
		return arr;
	}
	static void ruffleSort(int arr[]){
        for (int i = 0; i < arr.length; i++){ 
            int t = (int) Math.random() * arr.length; 
            int x = arr[t]; 
            arr[t] = arr[i]; 
            arr[i] = x; 
		}
		Arrays.sort(arr);
    } 
	static class FastReader{ 
		BufferedReader br; StringTokenizer st; 
		public FastReader(){ br = new BufferedReader(new InputStreamReader(System.in));} 
		String next(){ 
			while (st == null || !st.hasMoreElements()){ 
				try{st = new StringTokenizer(br.readLine()); } 
				catch (IOException e){e.printStackTrace();}} 
			return st.nextToken(); 
		} 
		int nextInt(){return Integer.parseInt(next());} 
		long nextLong(){return Long.parseLong(next());} 
		float nextFloat(){return Float.parseFloat(next());}
		double nextDouble(){return Double.parseDouble(next());} 
		String nextLine(){ 
			String str = ""; 
			try{str = br.readLine();} 
			catch (IOException e){e.printStackTrace();} 
			return str; 
		} 
	}
}
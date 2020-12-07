package _CP_Template;

import java.util.*;
import java.lang.*;
import java.io.*;

class CodeChef
{   
    static void solve(){
		StringBuilder output = new StringBuilder();



		print(output);
    }

    public static void main (String[] args) throws java.lang.Exception
	{
    	FastReader fs = new FastReader(); 
		int t = fs.nextInt(); 
		while (t-- > 0) 
		{ 	
			solve();
			pw.flush();
			pw.close();
		} 
	}
	//-------------------------------------------------
	static void print(StringBuilder s){pw.println(s);}
	static final int MOD = (int) 1e9+7;
	static final int INT_MAX = Integer.MAX_VALUE;
	static final int INT_MIN = Integer.MIN_VALUE;
	static PrintWriter pw = new PrintWriter(System.out);

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
        for(int i = 0; i<arr.length; i++){ 
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
		int nextInt(){return Integer.parseInt(next());} //4 byte
		long nextLong(){return Long.parseLong(next());} // 8 byte
		float nextFloat(){return Float.parseFloat(next());} //4 byte (upto 6 or 7 decimal points)
		double nextDouble(){return Double.parseDouble(next());} //8 byte (upto 15 decimal points)
		String nextLine(){ 
			String str = ""; 
			try{str = br.readLine();} 
			catch (IOException e){e.printStackTrace();} 
			return str; 
		} 
	}
}
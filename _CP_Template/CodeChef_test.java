package _CP_Template;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CodeChef_test
{   

    public static void main (String[] args) throws java.lang.Exception
	{
		FastReader fs = new FastReader();
		
	//	int t = fs.nextInt();
	//	while(t-- > 0){
			int n = fs.nextInt();
			int[] arr = arrayInput(fs, n);
			int max = Integer.MIN_VALUE, idx_max = -1;
			for(int i=0;i<n;i++) if(max < arr[i]){
				max = arr[i];
				idx_max = i;
			}
			int oprn = 0;
			while(idx_max > 0){
				swap(arr, idx_max, idx_max-1);
				idx_max--;
				oprn += 1;
			}

			int min = Integer.MAX_VALUE, idx_min = -1;
			for(int i=0;i<n;i++) if(min >= arr[i]){
				min = arr[i];
				idx_min = i;
			}
			if(idx_min != -1) oprn += n - idx_min - 1;
			print(oprn);

	//}
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
	static void sort(int arr[]){
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
		double nextDouble(){return Double.parseDouble(next());} 
		String nextLine(){ 
			String str = ""; 
			try{str = br.readLine();} 
			catch (IOException e){e.printStackTrace();} 
			return str; 
		} 
	}
}
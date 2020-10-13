package _CP_Template;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CodeChef_test
{   

	static int rem=0,t=0,g=0;
	static int solve(int a[], int target, int[]ans){
		if(target == 0){
			if(t!=g) System.out.println();
			for(int x : ans) System.out.print(x+" ");
			return 1;
		}

		for(int i=0;i<3;i++){
			if(target - a[i] >= 0){
				ans[i] += 1; 
				if(solve(a, target-a[i],ans) == 1) return 1;
				ans[i] -= 1;
			}
		}
		return -1;
	}
    public static void main (String[] args) throws java.lang.Exception
	{
		FastReader fs = new FastReader();
		
		int g = fs.nextInt();
		t = g;
		while(t-- > 0){
			int target = fs.nextInt();
			int arr[] = {3,5,7};
			int ans[] = {0,0,0};
			if(solve(arr,target,ans) == -1){
				if(t!=g) System.out.println();
				System.out.print(-1);
			}
		}
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
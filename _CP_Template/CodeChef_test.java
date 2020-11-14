package _CP_Template;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CodeChef_test
{   

    public static void main (String[] args) throws java.lang.Exception
	{
		FastReader fs = new FastReader();
		int n = fs.nextInt();
		if(n == 0 || n == 1){
			print(0 +" "+0+" "+ n);
			return;
		}
		List<Long>fib = fibo(n);
		int size = fib.size();
		System.out.print(fib.get(size-3) +" " + fib.get(size-3) + " " + fib.get(size-4));

	}

	static List<Long>fibo(int n){
		List<Long> fib = new ArrayList<>();
		fib.add(0l);
		fib.add(1l);
		long curr = 1l;
		while(curr < n){
			curr = fib.get(fib.size()-1) + fib.get(fib.size()-2);
			fib.add(curr);
		}
		return fib;
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
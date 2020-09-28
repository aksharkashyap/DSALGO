package _CP_Template;

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef_test
{   

    public static void main (String[] args) throws java.lang.Exception
	{
    	FastReader fs = new FastReader(); 
		int n = fs.nextInt();
		int t = fs.nextInt();
		String s = fs.nextLine();
		Queue<Character> q = new LinkedList<>();
		for(int i=0;i<n;i++) q.offer(s.charAt(i));
		while(q.size()>0){
			int size = q.size();
			while(size-- > 0){
				char a = q.poll();
				if((size!=0 && a==q.peek()) || a=='G' || (a=='B' && size==0) ) q.offer(a);
				else{
					q.offer(q.poll());
					q.offer(a);
					size--;
				} 
			}
			t--;
			if(t == 0) break;
		}
		StringBuilder sb = new StringBuilder();
		while(q.size()>0) sb.append(q.poll());
		print(sb);
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
    
	static int[] arrayInput(FastReader fs, int n){
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = fs.nextInt();
		return arr;
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
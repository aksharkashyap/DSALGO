//package _CP_Template;

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{   
    static String solve(int[] arr, int n){
        Arrays.sort(arr);
        int i=0,diff=0;
        while(i<n-1){
            diff = Math.abs(arr[i]-arr[i+1]);
            if(diff > 1) return "NO";
            i++;
        }
        return "YES";
    }

    public static void main (String[] args) throws java.lang.Exception
	{
    	FastReader s=new FastReader(); 
		int t = s.nextInt(); 
        while (t-- > 0) 
        { 	int n = s.nextInt();
            int[]arr = new int[n];
            for(int i=0;i<n;i++) arr[i] = s.nextInt();
			String ans = solve(arr,n);
            System.out.println(ans);  
		} 
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
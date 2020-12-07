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
		} 
		pw.close();
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
    
	static int[] arrayInput(FastReader fs, int n) throws IOException{
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
		final private int BUFFER_SIZE = 1 << 16; 
		private DataInputStream din; 
		private byte[] buffer; 
		private int bufferPointer, bytesRead; 
		public FastReader(){ 
			din = new DataInputStream(System.in); 
			buffer = new byte[BUFFER_SIZE]; 
			bufferPointer = bytesRead = 0; 
		} 
		public FastReader(String file_name) throws IOException{ 
			din = new DataInputStream(new FileInputStream(file_name)); 
			buffer = new byte[BUFFER_SIZE]; 
			bufferPointer = bytesRead = 0; 
		} 
		public String readLine() throws IOException{ 
			byte[] buf = new byte[64]; // line length 
			int cnt = 0, c; 
			while ((c = read()) != -1){ 
				if (c == '\n') break; 
				buf[cnt++] = (byte) c; 
			} 
			return new String(buf, 0, cnt); 
		} 
		public int nextInt() throws IOException{ 
			int ret = 0; 
			byte c = read(); 
			while (c <= ' ') c = read(); 
			boolean neg = (c == '-'); 
			if (neg) c = read(); 
			do{ 
				ret = ret * 10 + c - '0'; 
			} while ((c = read()) >= '0' && c <= '9'); 
			if (neg) return -ret; 
			return ret; 
		} 
		public long nextLong() throws IOException{ 
			long ret = 0; 
			byte c = read(); 
			while (c <= ' ') c = read(); 
			boolean neg = (c == '-'); 
			if (neg) c = read(); 
			do { 
				ret = ret * 10 + c - '0'; 
			}while ((c = read()) >= '0' && c <= '9'); 
			if (neg) return -ret; 
			return ret; 
		} 
		public double nextDouble() throws IOException{ 
			double ret = 0, div = 1; 
			byte c = read(); 
			while (c <= ' ') c = read(); 
			boolean neg = (c == '-'); 
			if (neg) c = read(); 
			do { 
				ret = ret * 10 + c - '0'; 
			}while ((c = read()) >= '0' && c <= '9'); 
			if (c == '.'){ 
				while ((c = read()) >= '0' && c <= '9') 
				{ ret += (c - '0') / (div *= 10);} 
			} 
			if (neg) return -ret; 
			return ret; 
		} 
		private void fillBuffer() throws IOException{ 
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
			if (bytesRead == -1) buffer[0] = -1; 
		} 
		private byte read() throws IOException{ 
			if (bufferPointer == bytesRead) fillBuffer(); 
			return buffer[bufferPointer++]; 
		} 
		public void close() throws IOException{ 
			if (din == null) return; 
			din.close(); 
		} 
	}
}
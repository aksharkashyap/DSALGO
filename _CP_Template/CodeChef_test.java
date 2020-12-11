package _CP_Template;

import java.util.*;
import java.lang.*;
import java.io.*;

class CodeChef_test
{   static StringBuilder output;
	
    static void solve() throws IOException{

 	}
 
	public static void main (String[] args) throws java.lang.Exception
	{
		fs = new FastReader();
		output = new StringBuilder();
		int t = fs.nextInt(); 
		while (t-- > 0) 
		{ 	
			solve();
			output.append("\n");
		}
		print(output);
		pw.flush();
		pw.close();
	}
	//-------------------------------------------------
	static int[] arrayInput(int n) throws IOException{
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = fs.nextInt();
		return arr;
	}
	static void print(StringBuilder s){pw.println(s);}
	static final int MOD = (int) 1e9+7;
	static final int INT_MAX = Integer.MAX_VALUE;
	static final int INT_MIN = Integer.MIN_VALUE;
	static FastReader fs;
	static PrintWriter pw = new PrintWriter(System.out);

	static void swap(int[]arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
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
    //--------reader section-----------------
	static class FastReader{
		private byte[] buf=new byte[1024];
		private int index;
		private InputStream in;
		private int total;
		public FastReader(){in=System.in;}
		public int scan()throws IOException{
			if(total<0) throw new InputMismatchException();
			if(index>=total){
				index=0; total=in.read(buf);
				if(total<=0) return -1;
			}
			return buf[index++];
		}
		public int nextInt()throws IOException{
			int integer=0;
			int n=scan();
			while(isWhiteSpace(n)) n=scan();
			int neg=1;
			if(n=='-'){ neg=-1; n=scan();}
			while(!isWhiteSpace(n)){
				if(n>='0'&&n<='9'){
					integer*=10; integer+=n-'0';
					n=scan();
				}
				else throw new InputMismatchException();
			}
			return neg*integer;
		}
		public long nextLong()throws IOException{
			long ll=0l;
			int n=scan();
			while(isWhiteSpace(n)) n=scan();
			int neg=1;
			if(n=='-'){ neg=-1; n=scan();}
			while(!isWhiteSpace(n)){
				if(n>='0'&&n<='9'){
					ll*=10; ll+=n-'0';
					n=scan();
				}
				else throw new InputMismatchException();
			}
			return neg*ll;
		}
		public double nextDouble()throws IOException{
			double doub=0; int n=scan();
			while(isWhiteSpace(n))
			n=scan();
			int neg=1;
			if(n=='-'){ neg=-1; n=scan();}
			while(!isWhiteSpace(n)&&n!='.'){
				if(n>='0'&&n<='9'){
					doub*=10; doub+=n-'0'; n=scan();
				}
				else throw new InputMismatchException();
			}
			if(n=='.'){
				n=scan();
				double temp=1;
				while(!isWhiteSpace(n)){
					if(n>='0'&&n<='9'){
						temp/=10; doub+=(n-'0')*temp; n=scan();
					}
					else throw new InputMismatchException();
				}
			}
			return doub*neg;
		}
		public String scanString()throws IOException
		{
			StringBuilder sb=new StringBuilder();
			int n=scan();
			while(isWhiteSpace(n)) n=scan();
			while(!isWhiteSpace(n)){
				sb.append((char)n); n=scan();
			}
			return sb.toString();
		}
		private boolean isWhiteSpace(int n){
			if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)return true;
			return false;
		}
	}	
}
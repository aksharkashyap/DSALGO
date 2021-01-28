package _CP_Template;

import java.util.*;
import java.io.*;

class CodeChef_test
{   static StringBuilder out;
	static int M = (int)1e6+1;
	static boolean prime[] = new boolean[M];
	static int[]ans = new int[M];

	static void solve() throws IOException{
		int n = fs.nextInt();
		pw.println(ans[n]);
	}
	 
 
	public static void main (String[] args) throws java.lang.Exception
	{
		fs = new FastReader();
		out = new StringBuilder();
		sieve();
		int t = fs.nextInt(); 
		while (t-- > 0) 
		{ 	
			solve();
			//out.append("\n");
		}
		//print(out);
		pw.flush();
		pw.close();
	}

	static void sieve(){
        Arrays.fill(prime,true);

        for(int i=2; i<=Math.sqrt(M);i++){
            if(prime[i]){
                for(int j = i*i; j<M; j+=i)
                    prime[j] = false;
            }
        }
		Arrays.fill(ans,0,4,0);
		ans[5]=1;
		for(int i=6;i<M;i++){
			if(prime[i] && prime[i-2]) ans[i] = ans[i-1]+1;
			else ans[i] = ans[i-1];
		}
    }
	//-------------------------------------------------
	static long[] arrayInput(int n) throws IOException{
		long[] arr = new long[n];
		for(int i=0;i<n;i++) arr[i] = fs.nextLong();
		return arr;
	}
	static void print(StringBuilder s){pw.println(s);}
	static final int MOD = (int) 1e9+7;
	static final int INT_MAX = Integer.MAX_VALUE;
	static final int INT_MIN = Integer.MIN_VALUE;
	static FastReader fs;
	static PrintWriter pw = new PrintWriter(System.out);

	static void swap(long[]arr, int a, int b){
		long temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	static void ruffleSort(long arr[]){
		for(int i = 0; i<arr.length; i++){ 
			int t = (int) Math.random() * arr.length; 
			long x = arr[t]; 
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
		public String nextString()throws IOException
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
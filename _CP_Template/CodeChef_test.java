package _CP_Template;

import java.util.*;
import java.io.*;

class CodeChef_test
{   static StringBuilder out;

	static void solve() throws IOException{
			String str = fs.nextString();
			char[]arr = {  '@', '#', '%', '&', '?' };
			Set<Character> set = new HashSet<>();
			for(char ch : arr) set.add(ch);
			if(str.length() < 10){
				pw.println("NO");
				return;
			}
			boolean lower=false,upper=false,digit=false,sp=false;
			for(int i=1; i<str.length()-1;i++){
				char ch = str.charAt(i);
				if(set.contains(ch)) sp = true;
				else if(Character.isLowerCase(ch)) lower = true;
				else if(Character.isUpperCase(ch)) upper = true;
				else if(Character.isDigit(ch)) digit = true;
			}
			if(Character.isLowerCase(str.charAt(0))) lower = true;
			if(lower && upper && digit && sp){
				pw.println("YES");
			}
			else{
				pw.println("NO");
			}
	}
	 
 
	public static void main (String[] args) throws java.lang.Exception
	{
		fs = new FastReader();
		out = new StringBuilder();
		int t = fs.nextInt(); 
		while (t-- > 0) 
		{ 	
			solve();
		}
		print(out);
		pw.flush();
		pw.close();
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
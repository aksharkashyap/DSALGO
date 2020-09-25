import java.util.*;
import java.io.*;

// do question on comparator and comparablee
import java.util.*;
import java.lang.*;

class Test
{
 public static void main (String[] args) throws java.lang.Exception
	{
    	FastReader s=new FastReader();
		while(true){
			int t = s.nextInt();
			if(t==42)break;
			System.out.println(t);
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


/**
 * 2 to 5 OS
 * 6 to 9 DBMS, networks,sql
 * 10 to 12 projects story
 * morning 7 to 11 html,css,javascript basics
 * dopeher amazon previous questions 
 */
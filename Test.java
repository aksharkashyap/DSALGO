import java.util.*;
import java.io.*;
import java.math.*;

class Codeforces
{   static StringBuilder out;
    
    static void solve() throws IOException{
       long n,e,h,a,b,c;
       //a,b,c -> price of omelete, milkshake, cake
       // e -eggs and h- choco bars left
       /**
        * first check whther it is possible to feed n people
        2e - 1
        3h - 1
        1e 1h - 1
        */
        n = fs.nextLong(); e = fs.nextLong();
        h = fs.nextLong(); a = fs.nextLong();
        b = fs.nextLong(); c = fs.nextLong();
        long req = Math.min(e,h);
        if(e == req){
            req += (h-req)/3;
        }
        else{
            req += (e-req)/2;
        }
        if(n > req){
            pw.println(-1); return;
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
        pw.flush();
        pw.close();
    }
    //-------------------------------------------------
    static long[] arrayInput(int n) throws IOException{
        long[] arr = new long[n];
        for(int i=0;i<n;i++) arr[i] = fs.nextLong();
        return arr;
    }
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
    static boolean isPrimeProbable(BigInteger bi){
        return bi.isProbablePrime(10);
    }
    static BigInteger nextProbablePrime(BigInteger bi){
        return bi.nextProbablePrime();
    }
    static final int MOD = (int) 1e9+7;
    static final int INT_MAX = Integer.MAX_VALUE;
    static final int INT_MIN = Integer.MIN_VALUE;
    static FastReader fs;
    static PrintWriter pw = new PrintWriter(System.out);

    //--------Reader section-----------------
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
        return str;}
    }
}
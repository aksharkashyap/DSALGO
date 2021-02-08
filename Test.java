import java.util.*;
import java.io.*;
import java.math.*;

class Main
{   static StringBuilder out;
    static void solve() throws IOException{
       int n = fs.nextInt();
       String[]str = new String[n];
       Set<String> set = new HashSet<>();
       for(int i=0;i<n;i++){
           str[i] = fs.next();
           set.add(str[i]);
       }
       long ans = 0;
       String a,b;
       StringBuilder x,y;
       for(int i=1;i<n;i++){
            a = str[i];
            for(int j=0;j<i;j++){
                b = str[j];
                x = new StringBuilder(a);
                x.setCharAt(0,b.charAt(0));
                y = new StringBuilder(b);
                y.setCharAt(0,a.charAt(0));
                if(!set.contains(x.toString()) && !set.contains(y.toString())) ans += 2l;
            }
       }
       pw.println(ans);
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
    static boolean isPrimeProbable(BigInteger bi){
        return bi.isProbablePrime(10);
    }
    static BigInteger nextProbablePrime(BigInteger bi){
        return bi.nextProbablePrime();
    }
    //--------reader section-----------------
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
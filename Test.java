import java.util.*;
import java.io.*;

class Test{
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        String x = fs.nextLine();
        System.out.print(x);
    }
}

class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
        while(st==null || !st.hasMoreElements()){
            try{
                st = new StringTokenizer(br.readLine());
            }catch(Exception e){e.printStackTrace();}
        }
        return st.nextToken();
    }
    int nextInt(){ return Integer.parseInt(next()); }
    float nextFloat(){ return Float.parseFloat(next()); }
    String nextLine(){
        String st = "";
        try{st = br.readLine();}
        catch(Exception e){e.printStackTrace();}
        return st;
    }
}
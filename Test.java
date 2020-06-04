import java.util.*;
import java.io.*;

class FastReader{
    StringTokenizer st;
    BufferedReader br;
    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
        while(st == null || !st.hasMoreElements()){
            try{
            st = new StringTokenizer(br.readLine());
            }
            catch(IOException e){e.printStackTrace();}

        }
        return st.nextToken();
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    float nextFloat(){
        return Float.parseFloat(next());
    }
    String nextLine(){
        String str = "";
        try{
        str = br.readLine();
        }
        catch(IOException e) {e.printStackTrace();}
        return str;
    }

}
import java.util.*;
import java.lang.*;
import java.io.*;

class Atm{
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int T=sc.nextInt();
        for(int a=1;a<=T;a++)
        {
            int N = sc.nextInt();
            int X = sc.nextInt();
            int arr[]=new int[N];
            for(int i=0;i<N;i++)
            {
                arr[i]=sc.nextInt();
            }
            Queue<Integer> q1=new LinkedList<>();
            Queue<Integer> q2=new LinkedList<>();
            List<Integer> ans=new ArrayList<>();
            for(int i=1;i<=N;i++)
            {
                q1.add(i);
                q2.add(arr[i-1]);
            }
            while(!q1.isEmpty())
            {
                int temp1=q1.poll();
                int temp2=q2.poll();
                if(temp2<=X)
                {
                    ans.add(temp1);
                }
                else
                {
                    q1.add(temp1);
                    q2.add(temp2-X);
                }
            }
            System.out.print("Case #"+a+": ");
            for(int i=0;i<ans.size();i++)
            {
                System.out.print(ans.get(i)+" ");
            }
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
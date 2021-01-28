package DP.LcsVaratiations;
import java.util.*;
class LIS{
    //longest increasing subsequence
    //------- some probelm in this code in online compiler
   /* public static int lis(int input[], int n){
        int output[] = new int[n];
        output[0] = 1;

        for(int i=1;i<n;i++)
        {
            output[i]=1;
            for(int j=i-1;j>=0;j--)
            {
                    if(input[j]>input[i])
                        continue;
                    int possibleAns = output[j]+1;
                    if(possibleAns > output[i])
                        output[i] = possibleAns;
            }
        }

        int best=0;
        for(int i=0;i<n;i++)
            if(best<output[i])
                best = output[i];
        output = null;
        return best;
    }

    */

    public static int lis(int[] arr, int n)
    {
         int lis[] = new int[n]; 
          int i,j,max = 0; 
           for ( i = 0; i < n; i++ ) 
              lis[i] = 1; 
           for ( i = 1; i < n; i++ ) 
              for ( j = 0; j < i; j++ )  
                         if ( arr[i] > arr[j] && lis[i] < lis[j] + 1) 
                    lis[i] = lis[j] + 1; 
           for ( i = 0; i < n; i++ ) 
              if ( max < lis[i] ) 
                 max = lis[i];
            return max; 
    }
    public static void main(String args[])
    {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int result = lis(arr,n);
        arr = null;
        System.out.println(result);
    }
}
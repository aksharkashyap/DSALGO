/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static int solve(int[]A,int[]B,int m, int n, int k){
        int ptr1=0,ptr2=0;
       // System.out.print(Arrays.toString(B));
        while(ptr1 < m && ptr2 < n){
            
            if(A[ptr1] <= B[ptr2]){ 
                k--;
               // System.out.print(A[ptr1]+" ");
                if(k == 0) return A[ptr1];
                ptr1++;
                
            }
            else{
                k--;
              //  System.out.print(B[ptr2] +" ");
                if(k == 0) return B[ptr2];
                ptr2++;
            }
        }
        
        while(ptr1 < m){
            k--;
            if(k == 0) return A[ptr1];
            ptr1++;
        }
        while(ptr2 < n){
            k--;
            if(k == 0) return B[ptr2];
            ptr2++;
        }
        return -1;
    }
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0){
	        int n,m,k;
	        n = sc.nextInt();
	        m = sc.nextInt();
	        k = sc.nextInt();
	        int[]B = new int[n];
	        int[]A = new int[m];
	        for(int i=0;i<n;i++){ B[i] = sc.nextInt(); }
	        for(int i=0;i<m;i++){ A[i] = sc.nextInt(); }
	        int ans = solve(A,B,m,n,k);
	        System.out.println(ans);
	    }
	}
}
package Stackk;

import java.util.Arrays;

/**
 * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a
 *  number of contiguous bars. For simplicity,assume that all bars have same width and the width is 1 unit.
For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 2, 6}. The largest 
possible rectangle possible is 12 (see the below figure, the max area rectangle is highlighted in red)
 */

import java.util.Stack;

/**
 * Brute force O(n^2) divide and conquer - avg- O(nlogn) but in worst case
 * O(n^2) segment tree O(nlogn) stack O(n)
 */



class Histogram{
    //brute force O(n^2)
    static void solve_brute_force(int arr[], int n){
        int max=0;
        int curr=0;

        for(int i=0;i<n;i++){
            curr=0;
            int k;
            // goto left
            if(i>0){
                k=i;
                for(k=i;k>=0;k--){
                    if(arr[k] >= arr[i]) curr += arr[i];
                    else break; 
                }
            }

            //goto right
            if(i<n-1){
                k=i;
                for(k=i+1;k<n;k++){
                    if(arr[k] >= arr[i]) curr += arr[i];
                    else break; 
                }
            }
            if(max < curr) max=curr;
        }
        System.out.println(max);
    }

    static class pair{
        int first,second;
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
  
    static int[] NSL(int arr[], int n){ //nearest smaller to left
        Stack<pair> stack = new Stack<>(); 
        int[] idx_nsl = new int[n];
        for(int i=0;i<n;i++){
            if(stack.size() == 0){
                idx_nsl[i] = -1;
            }else{
                while(stack.size()>0 && stack.peek().second > arr[i]) stack.pop();
                if(stack.size() == 0) idx_nsl[i] = -1;
                else idx_nsl[i]  = stack.peek().first;
            }
            stack.push(new pair(i,arr[i]));
        }
        return idx_nsl;
    }

    static int[] NSR(int arr[], int n){ //next smaller to right
        Stack<pair> stack = new Stack<>(); 
        int[] idx_nsr = new int[n];
        for(int i=n-1;i>=0;i--){
            if(stack.size() == 0){
                idx_nsr[i] = n;
            }else{
                while(stack.size()>0 && stack.peek().second > arr[i]) stack.pop();
                if(stack.size() == 0) idx_nsr[i] = n;
                else idx_nsr[i]  = stack.peek().first;
            }
            stack.push(new pair(i,arr[i]));
        }
        return idx_nsr;
    }

    static void solve_stack(int arr[], int n){
        int[] a = NSR(arr, n);
        int[] b = NSL(arr, n);
        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = (a[i] - b[i] -1) * arr[i];
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(ans));
        int max=0;
        for(int i=0;i<n;i++)
            max = Math.max(ans[i],max);
        System.out.print(max);

    }

    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        solve_brute_force(arr, arr.length);
        solve_stack(arr, arr.length);
        
    }
}



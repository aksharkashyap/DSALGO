package SORTING;

import java.util.Arrays;

public class RadixSort {

    static int getMax(int arr[], int n){
        int max=0;
        for(int i=0;i<n;i++)
            max = Math.max(max, arr[i]);
        return max;
    }
    static void count_sort(int arr[],int n, int exp){
      int output[] = new int[n];
      int count[] = new int[10];
      Arrays.fill(count,0);

      for(int i=0;i<n;i++)
        count[(arr[i]/exp)%10]++; // store in the count
      
      for(int i=1;i<10;i++)
        count[i]  += count[i-1];  
      
      for(int i=n-1;i>=0;i--){ // build the output array
        output[count[(arr[i]/exp) %10]-1] = arr[i];
        count[(arr[i]/exp) %10]--;
      }
     
      for(int i=0;i<n;i++)
            arr[i]=output[i];
    }

    static void radix_sort(int arr[],int n){
        int max = getMax(arr,n);
        for(int exp=1;(max/exp)>0;exp *=10)
            count_sort(arr,n,exp);
    }

    public static void main(String[] args) {

        int[]arr = {10,43,2,3,5,334,53};
        radix_sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
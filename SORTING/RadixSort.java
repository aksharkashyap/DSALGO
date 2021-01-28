package SORTING;

import java.util.Arrays;

public class RadixSort {

    static int getMax(int arr[], int n){
        int max=0;
        for(int i=0;i<n;i++) max = Math.max(max, arr[i]);
        return max;
    }
    static void count_sort(int arr[],int n, int exp){
      int output[] = new int[n];
      int count[] = new int[10];

      for(int i=0;i<n;i++) count[(arr[i]/exp)%10]++; // store in the count
      
      for(int i=1;i<10;i++) count[i]  += count[i-1];  
      
      for(int i=n-1;i>=0;i--){ // build the output array
        output[count[(arr[i]/exp) %10]-1] = arr[i];
        count[(arr[i]/exp) %10]--;
      }
     
      for(int i=0;i<n;i++) arr[i]=output[i];
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



/**
 class Test{

   static void countSort(int[] arr, int k){

         int[] count = new int[10];
         int output[] = new int[arr.length];

         for(int i=0;i<arr.length;i++) count[(arr[i]/k) % 10]++;
         
         for(int i=1;i<10;i++) count[i] += count[i-1]; //prefix sum

         for(int i=arr.length-1;i>=0;i--) output[--count[(arr[i]/k) % 10]] = arr[i];

         int i=0; for(int v : output) arr[i++] = v;
   }

    public static void main(String[] args) {
      
      int arr[] = {1234,2134,9853,245,1322};
      int max = 9853; //max element
      for(int i=1; (max/i) >0; i=i*10){ // we need to do -> div by k mod 10 to extract digits 
           countSort(arr, i);
      }
      System.out.print(Arrays.toString(arr));
    }
}
 */


 /**
  * Complexity

Since radix sort is a non-comparative algorithm, it has advantages over comparative sorting algorithms.
For the radix sort that uses counting sort as an intermediate stable sort, the time complexity is O(d(n+k)).

Here, d is the number cycle and O(n+k) is the time complexity of counting sort.
Thus, radix sort has linear time complexity which is better than O(nlog n) of comparative sorting algorithms.

If we take very large digit numbers or the number of other bases like 32-bit and 64-bit 
numbers then it can perform in linear time however the intermediate sort takes large space.
This makes radix sort space inefficient. This is the reason why this sort is not used in software libraries.

Radix Sort Applications
  Radix sort is implemented in
  DC3 algorithm (Kärkkäinen-Sanders-Burkhardt) while making a suffix array.
  places where there are numbers in large ranges
  */
package SORTING;

import java.util.Arrays;

class CountSort{

     static int[] count_sort(int arr[]){
        int output[] = new int[arr.length];
        int mMAx = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++) mMAx = Math.max(mMAx, arr[i]);
        
        int count[] = new int[mMAx+1];
        
        for(int i=0;i<arr.length;i++)  ++count[arr[i]];
        

        //modify the count so that it can store sum of previous counts;
        for(int i=1;i<=mMAx;i++) count[i] += count[i-1];
        
        //placing the values in our output array
        for(int i=arr.length-1;i>=0;i--){
            int X = count[arr[i]];
            output[X-1]=arr[i];
            --count[arr[i]];
        }
        return output;
    }

    public static void main(String args[]){
        int arr[]= {2,3,4,13,12,5,5};
        int get[]= count_sort(arr);
        for(int i: get){
            System.out.print(i+" ");
        }        
    }

}

/**
 * Overall complexity = O(max)+O(size)+O(max)+O(size) = O(max+size)

Worst Case Complexity: O(n+k)
Best Case Complexity: O(n+k)
Average Case Complexity: O(n+k)

In all the above cases, the complexity is the same because no matter how the elements are placed in the array, 
the algorithm goes through n+k times.

There is no comparison between any elements, so it is better than comparison based sorting techniques. 
But, it is bad if the integers are very large because the array of that size should be made.

Space Complexity:

The space complexity of Counting Sort is O(max). Larger the range of elements, larger is the space complexity.


Counting sort is used when:
    there are smaller integers with multiple counts.
    linear complexity is the need
 */
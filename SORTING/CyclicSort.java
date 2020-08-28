package SORTING;
import java.util.Arrays;

/**
 * cyclic sort for numbers from 1 to n [O(n) time and O(1) space and n-1 swaps]
   if(numbers are not starting from 1 but are consecutive(including all elements) so we can make this algorithm work by 
   instead of substring by 1 we can substract by minimum number)
 */
class CyclicSort {

    static void cyclicSort(int arr[], int n){
        int i=0;
        while(i<n){
            if(arr[i]!=i+1){
                int idx = arr[i]-1;
                int temp = idx+1;
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
            else i++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,2,1,3,5};
        cyclicSort(arr,arr.length);
        System.out.print(Arrays.toString(arr));
    }
}

//practice question
//https://leetcode.com/problems/shuffle-string/
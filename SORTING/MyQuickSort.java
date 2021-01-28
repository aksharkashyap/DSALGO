package SORTING;
/** 
 Finding the correct position for the pivot->
 * all the values which are left to pivot must be <=
 * all the values which arr right to pivot must be >
 */

import java.util.*;
public class MyQuickSort {
    public static void main(String[] args) {
        int arr[] = {2,10,6,9,15,7};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int arr[],int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partion(int arr[],int start,int n){
        int pivot = arr[n];
        int i=start-1;
        for(int j=start; j<n;j++){
            if(arr[j]<=pivot)
                swap(arr,++i,j);
        }
        swap(arr, ++i,n);
        return i;
    }

    static private void sort(int arr[],int start ,int end){
            /* if(start>=end) return; 
            int pivot_Index = partion(arr,start,end);
            sort(arr,start,pivot_Index-1); //0 to parition_index -1
            sort(arr,pivot_Index+1,end); // partition_index+1 to arr.length
            */

            while(start<end){
                int pivot_Index = partion(arr,start,end);
                sort(arr,start,pivot_Index-1); //0 to parition_index -1 // left 
                start = pivot_Index+1; // partition_index+1 to arr.length  //right
               }
            
    }
}
package SORTING;

public class Selection {

    //avg/worst/best case o(n^2)
    //unstable- may change order of elements

    //The good thing about selection sort is it never makes more than O(n) 
    //swaps and can be useful when memory write is a costly operation.
    
    
    //bubble, insertion and merge stable

    /**
     * Online/Offline technique –
        A sorting technique is considered Online if it can accept new data while the procedure 
        is ongoing i.e. complete data is not required to start the sorting operation.
        Among the comparison based techniques discussed, only ""Insertion Sort"" qualifies for this because of
        the underlying algorithm it uses i.e. it processes the array (not just elements) from left to right and if new 
        elements are added to the right, it doesn’t impact the ongoing operation.
     
     */

    public static void swap(int i, int j, int[] arr){
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
    }


    public static void selection(int arr[], int n){
        for(int i=0;i<n;i++){
            boolean flag = false;
            int ptr=i;
            for(int j=i+1; j<n;j++){
                 if(arr[ptr] > arr[j])
                        {
                            ptr = j;
                            flag = true;
                        }
            }
            if(flag) swap(i,ptr,arr);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,4,15,3,2};
        selection(arr,arr.length);
        for(int i : arr)
            System.out.print(i+" ");
    }
}
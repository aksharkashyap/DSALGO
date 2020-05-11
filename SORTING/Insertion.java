package SORTING;

public class Insertion {
 //best case O(n)- when array is already sorted
    //worst when array is reverse sorted
    public static void insertion(int []arr, int n){
        for(int i=1;i<n;i++){
            int k = i;
            int j = i-1;
            while(j>=0 && arr[k] < arr[j])
                swap(arr,k--,j--);
        }
    }
    
    public static void swap(int arr[],int j, int i){
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
    }

    public static void main(String args[]){
            int arr[] = {25,10,10,7,30,11};
            insertion(arr,arr.length);
            for(int i: arr)
                System.out.print(i+" ");
    }
}
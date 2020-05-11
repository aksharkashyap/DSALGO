package SORTING;

public class Bubble {

    //best case O(n)- when array is already sorted
    //worst when array is reverse sorted

    private static void swap(int i, int j, int arr[]){
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    private static void bubble(int arr[],int n){
        boolean swapped=false;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1])
                    {
                        swap(j,j+1,arr);
                        swapped = true;
                    }
            }
            if(swapped == false)
                break;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,4,15,3,2};
        bubble(arr,arr.length);
        for(int i : arr)
            System.out.print(i+" ");
    }

}
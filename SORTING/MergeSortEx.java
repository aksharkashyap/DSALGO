package SORTING;
import java.util.*;

public class MergeSortEx {

    static void sort(int[]arr,int start, int end){
        if(start>=end) return;
        int mid = start + (end-start)/2;
        sort(arr, start, mid); // left
        sort(arr, mid+1, end); //right
        merge(arr,start,end,mid);
    }

    static void merge(int[] arr, int start, int end, int mid ){
        int n1 = mid-start+1;
        int n2 = end-mid;
        int a[] = new int[n1];
        int b[] = new int[n2];

         /*Copy data to temp arrays*/
         for (int i=0; i<n1; ++i) 
            a[i] = arr[start+i];  // start to mid
     
         for (int j=0; j<n2; ++j) 
            b[j] = arr[(mid+1)+j];  // mid+1 to end
    
        int i=0,j=0,k=start;
        while(i<n1 && j<n2){
            if(a[i] > b[j]) arr[k++] = b[j++];
            else arr[k++] = a[i++];
        }
        while(i<n1) arr[k++] = a[i++];
        while(j<n2) arr[k++] = b[j++];
    }
    
    public static void main(String[] args) {
        int arr[] = {2,10,12,5,1,22,6,9,15,7};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
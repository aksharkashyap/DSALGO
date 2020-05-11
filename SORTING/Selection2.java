package SORTING;
import java.util.*;
public class Selection2 {
     // selection
     // swap 
     //counter shift
        public static void main(String[] args) {
            int arr[] = {2,10,12,5,1,22};
            selection_sort(arr,arr.length);
            System.out.println(Arrays.toString(arr));
        }
    
        static void selection_sort(int arr[],int n){
            for(int i=0;i<n;i++){
                int pos = find_min(arr,i,n);
                swap(arr, i, pos);
            }
        }
        static int find_min(int arr[],int i,int n){
            int min_index = i;
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            return min_index;
        }
        static void swap(int arr[],int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    
}
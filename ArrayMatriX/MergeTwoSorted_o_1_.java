package ArrayMatriX;
import java.util.*;

//insertion sort based
class MergeTwoSorted{
    /** time O(m*n) [linear * insertionSort]
     * 
     */
   
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            if(arr[i] < arr[i-1]) swap(arr,i-1,i);
        }
    }

    static void merge(int a[], int b[], int alen, int blen){

        for(int i=0;i<alen;i++){
            if(b[0] < a[i]){
                int temp = a[i];
                a[i] = b[0];
                b[0] = temp;
                insertionSort(b);
            }
        }
    }

    public static void main(String[] args) {
        int b[] = {44,48,77,88};
        int a[] = {1,32,46,47,78,80};
        int alen = a.length;
        int blen = b.length;
        merge(a,b,alen,blen-1);
        System.out.print(Arrays.toString(a) + " " + Arrays.toString(b));
    }
}

//GAP based
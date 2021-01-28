package HeapVariations;
import java.util.*;
public class KSortedArray {


    static private void k_sort(int arr[],int k){

        PriorityQueue<Integer> heap = new PriorityQueue<>(); //min heap
        int ptr=0;
        for(int i=0;i<arr.length;i++){
            heap.offer(arr[i]);
            if(heap.size()>k) arr[ptr++] = heap.poll();
        }
        while(!heap.isEmpty())
            arr[ptr++] = heap.poll();
    }

    public static void main(String[] args) {
        int arr[]= {6,5,3,2,8,10,9};
        int k = 3;
        k_sort(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
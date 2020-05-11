package HeapVariations;
import java.util.*;
//connect ropes to minimize the cost
// pop two minimum(x,y) - add to sum (totalsum)
// push back this newly formed rope(sum of x,y)
//continue until heap.size()>1 
//return the totalsum

public class ConnectRopes {

    static private int minimize_cost(int[]arr,int n){
        int sumTotal = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i=0;i<n;i++)
            heap.offer(arr[i]);

        while(heap.size()>1){
            int x = heap.poll();
            int y = heap.poll();
            int sum = x+y;
            sumTotal += sum;
            heap.offer(sum);
        }
        return sumTotal;
    }
    public static void main(String[] args) {
        int arr[] = {12,43,52,52,43,11};
        int size = arr.length;
        int ans = minimize_cost(arr, size);
        System.out.println(ans);
    }
}
import java.util.*;

class Test{

    static int solve(int arr[], int lo, int hi){
        
        if(lo == hi) return lo;
        if(hi-lo == 1) return arr[lo] > arr[hi] ? lo : hi;
    
        int mid = lo + (hi-lo)/2;
        int left = solve(arr, lo, mid-1);
        int right = solve(arr,mid,hi);

        return arr[left] > arr[right] ? left : right;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,39,10,4,11,2,44};
        int ans = solve(arr,0,arr.length-1);
        System.out.print(arr[ans]);
    }
}
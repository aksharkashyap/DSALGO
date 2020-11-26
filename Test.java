import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,8,10};
        int ans = upper_bound(arr, 0, arr.length-1,3);
        
    }
    
    static int upper_bound(int[]m,int start,int end, int val){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(m[mid] <= val) start = mid+1;
            else end = mid - 1;
        }
        return start;
    }
}

/**
 * (1) find min(from 1st column of every row) and 
 * max(from last column of every row) element of MATRIX
 * (2) BinarySearch every row[i] for count of how many elements are less than mid
 * (3) if(count < r*c+1/2) min = mid +1
 * (4) else max = mid
 */

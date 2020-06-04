package DP;
//kadens modified algo for largest sum contiguous subarray
// works for both +ve/-ve elements
//original kadens alog doesnt work for -ve elements

public class Kadens {

    static int solve(int arr[], int n){
        int meh=0, msf = Integer.MIN_VALUE;
        int start=0, end=0;

        for(int i=0;i<n;i++){
            meh = meh + arr[i];
            if(meh < arr[i]){
                meh = arr[i];
                start=i;
            }
            if(msf < meh){
                msf = meh;
                end = i;
            }
        }
        System.out.println("subarray: "+start + " to "+ end);
       return msf;
    }
    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = arr.length;
        int msf = solve(arr, n);
        System.out.println("Maximum contiguous sum is"+ " "+msf);
    }


    public int maxSubArray(int[] arr) {
        
        int msf = Integer.MIN_VALUE;
        int curr = 0;
        
        for(int i=0;i<arr.length;i++){
            curr += arr[i];
            if(curr < arr[i]) curr = arr[i];
            if(curr > msf) msf = curr;
        }
        return msf;
    }
    
}


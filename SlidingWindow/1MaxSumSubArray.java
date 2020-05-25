package SlidingWindow;

class MaxSumSubArray{

    static void solve(int[]arr, int n, int k){
        int sum=0;

        if (n < k) { 
            System.out.println("Invalid: n must be greater"); 
        } 

        for(int i=0;i<n;i++){
            if(i<k) sum += arr[i];
            else{
                int temp = sum + arr[i] - arr[i-k];
                if( temp > sum) sum = temp;
            }
        }
        System.out.print(sum);
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4; //window size
        int arr2[] = {100, 200, 300, 400};
        int k2 = 2;
        solve(arr2,arr2.length,k2);
    }
}
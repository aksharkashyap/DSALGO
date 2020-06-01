package Recursion;

class MaxNumber{

    static int solve(int arr[],int n){
        if(n == -1) return -1;
        if(n == 0) return arr[n];
        
        int temp = solve(arr, n-1);
        return temp > arr[n] ? temp : arr[n];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,11,3,2,22,4,1,3};
        int n = arr.length;
        int max = solve(arr,n-1);
        System.out.println(max);
    }
}
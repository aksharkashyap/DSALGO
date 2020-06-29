package Recursion;
import java.util.Arrays;

//immitating the insertion sort(fixing the largest value first here) in recursive way
class SortArray{

    static void solve(int arr[], int n){
        if(n == arr.length) return;
        solve(arr, n+1);
        int maxPos = sort(arr,0,n,n);
        swap(arr,n, maxPos); 
    }

    static int sort(int arr[],int i, int n, int max){
        if(i == n) return i;
        int temp = sort(arr, i+1, n, max);
        if(arr[temp] > arr[i]) return temp;
        return i;
    }

    static void swap(int arr[], int i , int j){
        int temp= arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[]args){
        int arr[] = {20,1,2,1,25,9,11};
        solve(arr,0);
        System.out.println(Arrays.toString(arr)); 
    }
}
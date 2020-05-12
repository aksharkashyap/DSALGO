package BinarySearchProblems;
//search on reverse sorted array

public class ReverseSortedArray {

    static private int binary_Search(int arr[],int start, int end,int key){

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid] == key)
                return mid;

            else if(arr[mid] > key)
                start = mid+1;

            else end = mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {18,17,16,15,14,13,12,11};
        int n = arr.length;
        int key = 18;
        int ans = binary_Search(arr,0,n-1,key);
        System.out.println(ans);
    }
}
package BinarySearchProblems;

public class FindFirstOccInfiniteSortedArray {

    static int ans=-1;
    static int binary_search(int[]arr,int start,int end, int key){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]== key){
                ans = mid;
                end = mid-1;
            }
            if(arr[mid] <  key) start = mid+1;
            else end = mid-1;
        }
        return ans;
    }


    static int find_bound(int[]arr,int key){ // find the range [start,end] where the key lies
        int start = 0; 
        int end = 1;
        while(key  > arr[end]){
            start = end;
            end*=2;
        }
        return binary_search(arr, start, end, key);
    }   

    public static void main(String[] args) {
        int arr[] = {1,2,2,2,5,12,14,20,20,20,30,34,38,40,43,50,52,55,60};
        int key = 2;
        int x = find_bound(arr, key);
        System.out.println(x);
    }
}
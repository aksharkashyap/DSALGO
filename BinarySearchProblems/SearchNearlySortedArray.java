package BinarySearchProblems;

// an elements can be present at these i'th , i-1'th or i+1'th positions from its original position
// find the key

public class SearchNearlySortedArray {


    static public int binary_search(int[]arr,int start, int end, int key,int n){
        while(start<=end){
            int mid = start+(end-start)/2;
            int prev = (mid+n-1)%n;
            int next = (mid+1)%n;
            if(arr[mid]==key) return mid;   
            if(arr[prev]==key) return prev;// if (mid > start && arr[mid - 1] == x) return (mid - 1); 
            if(arr[next]==key) return next; // if (mid < end && arr[mid + 1] == x) return (mid + 1); 
            if (arr[mid] > key) end = mid-2;
            if (arr[mid] < key) start = mid+2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {5,10,10,20,40};
        int n = arr.length;
        int key = 10;
        int ans = binary_search(arr,0,n-1,key,n);
        System.out.println(ans);
    }

}
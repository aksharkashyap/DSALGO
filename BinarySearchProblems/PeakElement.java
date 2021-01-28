package BinarySearchProblems;

public class PeakElement {
    
    static int peak_search(int arr[],int start,int end){
        while(start<=end){
            int mid = start+(end-start)/2;
            
            if(mid>start && mid<end && arr[mid] >arr[mid+1] && arr[mid]>arr[mid-1])
                return mid;
            if(mid==0 && arr[mid+1]<arr[mid]) return mid;
            if(mid==arr.length-1 && arr[mid-1]< arr[mid]) return mid;
            if(mid<end && arr[mid+1] >arr[mid]) start = mid+1;
            if(mid>start && arr[mid-1] > arr[mid]) end = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1};
        if(arr.length <2) System.out.print("No peak");
        else {int ans = peak_search(arr,0,arr.length-1);
        System.out.print(ans);
        }
    }
}

/**
 * application -1) bitonic(increasing then decreasing) array given - find a given key
 * ans-> find peak element then apply binary search on its left(asc) and right(desc)
 * 
 * 2) find max element in bitonic array --> ans -> find peak element
 */ 
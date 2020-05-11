package BinarySearchProblems;

/**
 * Consider an array of distinct numbers sorted in increasing order. 
 * The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.

Examples:

Input : arr[] = {15, 18, 2, 3, 6, 12}
Output: 2
Explanation : Initial array must be {2, 3,
6, 12, 15, 18}. We get the given array after 
rotating the initial array twice.

Input : arr[] = {7, 9, 11, 12, 5}
Output: 4

Input: arr[] = {7, 9, 11, 12, 15};
Output: 0
 */

public class NumOfTimesArrayRotated {
        // Returns count of rotations for an array which is first sorted in ascending order, then rotated 
    
    static int countRotations(int arr[], int start,int end) { 
        
        if (end < start) return 0; // This condition is needed to handle  // the case when array is not rotated at all  
        if (end == start) return start; // If there is only one element left

        int mid = start + (end - start)/2; // Find mid // /*(start + end)/2;*/ 
  
        if (mid < end && arr[mid+1] < arr[mid]) // Check if element (mid+1) is minimum element. Consider the cases like {3, 4, 5, 1, 2} 
            return (mid + 1); 
        
        if (mid > start && arr[mid] < arr[mid - 1]) // Check if mid itself is minimum element 
            return mid; 
  
        if (arr[end] > arr[mid]) // Decide whether we need to go to left half or right half 
            return countRotations(arr, start, mid - 1); 
  
        return countRotations(arr, mid + 1, end); 
    }


    public static void main(String[] args) {
       int arr[] = {4,5,6,7,0,1,2};
       int y = countRotations(arr,0,arr.length-1);
       System.out.println(y);
    }
}











 /* vague algorithm
    static int binary_search(int arr[],int start,int end,int n){
            while(start<=end){
                int mid = start + (end-start)/2;
                int prev = (mid+n-1) % n;
                int next = (mid+1) % n;
                if(arr[mid]<arr[next] && arr[mid] < arr[prev])
                    return mid;
                else if(arr[mid]>arr[start])// right is sorted go to left
                    start = mid;
                else if(arr[mid]<= arr[end]) //left is sorted search in unsorted side (right)
                    end = mid;
                
            }
            return 0;
    }
    */
    

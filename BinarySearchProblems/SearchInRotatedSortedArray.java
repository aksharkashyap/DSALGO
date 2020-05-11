package BinarySearchProblems;

    // find min element using num of time array rotated
    // apply normal binary search in its left
    // apply normal binaray search in its right

class SearchInRotatedSortedArray {
    
    static int countRotations(int arr[], int start, int end) { 
       
       if (end < start)  return 0; 
       if (end == start) return start; 
       int mid = start + (end - start)/2;  
       if (mid < end && arr[mid+1] < arr[mid]) 
           return (mid + 1); 
       // Check if mid itself is minimum element 
       if (mid > start && arr[mid] < arr[mid - 1]) 
           return mid; 
       // Decide whether we need to go to left // half or right half 
       if (arr[end] > arr[mid]) 
           return countRotations(arr, start, mid - 1); 
       return countRotations(arr, mid + 1, end); 
   } 
 
   int binary_search(int arr[],int start, int end,int key){
       while(start<=end){
           int mid = start+(end-start)/2;
           if(arr[mid] == key) return mid;
           else if(arr[mid] < key) start = mid+1;
           else end = mid-1;
       }
       return -1;
   }
   
   public int search(int[] nums, int target) {
       int n = nums.length;
       if(n==0) return -1;
       
       int min = countRotations(nums,0,n-1);
       if(nums[min] == target) return min;
   
       int x = binary_search(nums,0,min,target);
       int y = binary_search(nums,min,n-1,target);
       
       return x == -1 ? y : x; 
   }
}
/* given an infinite sorted array , search an element in it
that is -> end is not known(dont use arr.length function) - only start is known
- vimp problem for interview
*/
package BinarySearchProblems;

class InfiniteSortedArray{

    public static int binary_search(int arr[],int start, int end, int key){

        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] == key) return mid;
            else if(arr[mid] < key) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
    // note this functions assumes to be array is infinite so their is not index out of bound checking(theoritically)
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
        int arr[] = {1,2,3,4,5,12,14,20,22,25,30,34,38,40,43,50,52,55,60};
        int key = 52;
        int x = find_bound(arr, key);
        System.out.println(x);
    }

}
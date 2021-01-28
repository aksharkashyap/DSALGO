package BinarySearchProblems;

public class FindCeil {
    //given a sorted array
    //if element is present return it
    //if not present then return its ceil 

    static int binary_search(int arr[],int start, int end,int n,int key){
            int ans=-1;
            while(start<=end){
                int mid = start+(end-start)/2;
                if(arr[mid] == key)
                    return arr[mid];
                else if(arr[mid] < key)
                    start = mid+1;
                else {
                    ans = arr[mid]; //possible candidate
                    end = mid-1;
                }
            }
            return ans;
        }
        public static void main(String[] args) {
            int arr[] = {1,2,3,4,5,12,14,20};
            int key = 19;
            int n = arr.length;
            int x = binary_search(arr,0,n-1,n,key);
            System.out.println(x);
        }
    
}
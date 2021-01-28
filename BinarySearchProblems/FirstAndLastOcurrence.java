package BinarySearchProblems;

//first and last occurrance of a given number

public class FirstAndLastOcurrence {
    static int res=-1;
    static private int binary_search(int arr[], int start, int end, int key){

        while(start<=end){
            int mid = start+(end-start)/2;

            if(arr[mid] == key){ // 1st occurrance
                res = mid;
                end = mid-1;  // for last occurance start = mid+1
            }
            else if(arr[mid] < key)
                start = mid+1;
            else if(arr[mid] > key)
                end = mid-1;

        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,3,3,6,7,8};
        int n = arr.length;
        int key = 3;
        int x =binary_search(arr,0,n-1,key);
        System.out.println(x);

    }

}
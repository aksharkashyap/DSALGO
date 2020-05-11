package BinarySearchProblems;

//find next alphabet after key (within the sorted array)
public class NextAlphabeticalElement {
    static char ans = '\0';
    private static char binary_search(char[] arr, int start, int end, int n, char key) {
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] <= key) start = mid+1;
            if(arr[mid] > key) {
                ans = arr[mid];
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        char arr[] = {'a','b','c','e','f','g'};
        char key = 'c';
        int n = arr.length;
        char x = binary_search(arr,0,n-1,n,key);
        if(x=='\0') System.out.println("No next alphabet is present");
        else System.out.println(x);
    }
}
package BinarySearchProblems;
/**
 * ALLOCATE MINIMUM NUMBER OF PAGES:

Given number of pages in n different books and m students. The books are arranged in ascending order of 
number of pages. Every student is assigned to read some consecutive books. 
The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum
 */
public class AllocateMinPages {
    
    static int max(int arr[]){
        int max_el = -1;
        for(int i=0;i<arr.length;i++)
            max_el = Math.max(max_el,arr[i]);
        return max_el;
    }
    static int sum(int arr[]){
        int s = 0;
        for(int i=0;i<arr.length;i++)
            s+=arr[i];
        return s;
    }
    
    static boolean isValid(int arr[],int mid,int m){
        int student=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>mid){
                student++;
                sum=arr[i];
            }
            if(student>m) return false;
        }
        return true;
    }
    static int res = Integer.MAX_VALUE;
    static int binary_search(int arr[], int m,int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;

            if(isValid(arr,mid,m)){
                res = Math.min(res, mid);
                end = mid-1; 
            }
            else start = mid+1;
        }
        return res;
    }

    public static void main(String[] args) {
        
        int pages[] = {12,34,67,90};
        int m = 2;

        if (pages.length < m) System.out.println("Allocation not possible");
        else{
        int start = max(pages);
        int end = sum(pages);
        int ans = binary_search(pages,m,start,end);
        System.out.println(ans);
        }
    }
}
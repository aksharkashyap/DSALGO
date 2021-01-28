package ArrayMatriX;
// majority element Given an array of size n, 
// The majority element is the element that appears more than ⌊ n/2 ⌋ times.

/** Approaches
 * brute force  -> n^2
 * sorting  -> nlogn
 * hashmap -> n
 * divide and conquer  -> nlogn
 * boyer-moore voting algo -> n
 * randmization -> O(infinite){
    generate random element between 0 to arr.length
    rand.nextInt(max - min) + min;
    then check whether it is satisfiying the condition 
    }
 */

public class MajorityElement {
    
        int count(int arr[], int start, int end, int num){
            int c=0;
            for(int i=start;i<=end;i++){
                if(arr[i] == num) c++;
            }
            return c;
        }
        
        //divide and conquer
        int solve(int arr[], int start, int end){
            if(start >= end) return arr[start];
            int mid = start + (end-start)/2;
            
            int left = solve(arr,start, mid);
            int right = solve(arr,mid+1,end);
            
            if(left == right) return left;
            
            return count(arr,start,end,left) > count(arr,start,end,right) ? left : right;
        }
        
        
        
        public int majorityElement(int[] arr) {
            //boyer-moore algorithm
            /*int n = arr.length;
            int k = n/2;
            int maj=0;
            int count=0;
            for(int i=0;i<n;i++){
                if(count == 0) maj = arr[i];
                if(maj == arr[i]) count++;
                else{
                    count--;
                }
                
            }
            return maj;
            */
            
            return solve(arr,0,arr.length-1);
            
            
        }
    
}
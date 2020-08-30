package SlidingWindow;
/** https://leetcode.com/problems/count-number-of-nice-subarrays/
Note : we will check all the possibilities of subarray ending at end'th index
1) prefix sum array of odd counts
2) maintain a window size where Sum[right]-Sum[left]==k
3) Got the subarray ?? now move the left boundry (to check for other possibilites)
4) if Sum[i]==Sum[i-1] then [Subarray count ending at end'th position == count ending at end'+1 position]
*/

class CountNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int left=0,right=0 ,n=nums.length,count=0,prev=0;
        
        int[] prefixOddSum = new int[n+1];
        
        for(int i=0;i<n;i++){ 
            prefixOddSum[i+1] = (nums[i]%2== 0) ? prefixOddSum[i] : prefixOddSum[i]+1;
        }
        
        while(right<=n){
            if(prefixOddSum[right] >= k){
                if(right>0 && prefixOddSum[right] == prefixOddSum[right-1]){//case like 0 1 1 2 2 3 3 [prefix_sum_array]
                    count += prev; //same number of subarrays
                }
                else{
                    prev = 0;
                    while(prefixOddSum[right] - prefixOddSum[left] == k){ //look for other possibilities ending at end'th index
                        prev++; //subarray count
                        left++; //move the left boundry
                    }
                    count += prev;
                }
            }
            right++;
        }
        return count;
    }
}
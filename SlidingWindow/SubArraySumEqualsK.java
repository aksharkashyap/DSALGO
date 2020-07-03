package SlidingWindow;
/**
 * Given an array of integers 
 * and an integer target, you need to find the total number of continuous subarrays whose sum equals to target.
 */

// brute force + sliding window O(n^3)
class SubArraySum_1 {
    public int subarraySum(int[] nums, int target) {   
        int ans=0;
        for(int k=1;k<=nums.length;k++) //window size
            for(int i=0;i<=nums.length-k;i++)  //left boundry
               if(sum(nums,i,i+k)==target) ans++;   //left boundry + k 
        
        return ans;
    }
    int sum(int nums[],int i, int j){
        int sum=0;
        for(int k=i;k<j;k++) sum+=nums[k];
        return sum;
    }
}

//brute force + sliding window + prefix sum O(n^2)
class SubArraySum_2 {
    public int subarraySum(int[] nums, int target){
        int ans=0;
        
        int prefixSum[] = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1;i<nums.length;i++) prefixSum[i] = nums[i] + prefixSum[i-1];
        
        for(int k=1;k<=nums.length;k++) //window size
            for(int i=0;i<=nums.length-k;i++)
                if(prefixSum[i+k-1] - prefixSum[i] + nums[i] == target) ans++;
        
        return ans;
    }
}
package SlidingWindow;

import java.util.HashMap;

/**
 * Given an array of integers and an integer target, you need to find the total
 * number of continuous subarrays whose sum equals to target.
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

//slide in n^2
class SubArraySum_3 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }
}

//slide in n^2 without space
class SubArraySum_4 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}

//hashmap O(n)
class SubArraySum_5 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
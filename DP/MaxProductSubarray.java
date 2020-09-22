package DP;
//kadens algo for multiplication
//https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity

public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        
        int r = nums[0];
        
        for(int i=1,imax=r,imin=r; i<nums.length; i++){
            
            if(nums[i] < 0){
                //swap imax,imin
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            
            imax = Math.max(nums[i], nums[i]*imax);
            imin = Math.min(nums[i], nums[i]*imin);
            r = Math.max(r,imax);
        }
        return r;
    }
}

/**
 * max,min keep track, kadens algo modification, when you hit negative number swap(max,min) , 
 I am keeping track of the min number because In future it can become positive and it will 
 turn out to be maximum number
 */
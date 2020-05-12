package DP;
public class Ladder {
    
    static int find(int[] nums, int low, int high,int jump,int sum){
        if(low > high)
            return sum;
        sum+=nums[low];
        return find(nums,low+jump,high,jump,sum);
    }
    
    
    public static int rob(int[] nums) {
        int sum=0,jump=2;
        while(jump<nums.length){
            sum = Math.max(find(nums,0,nums.length-1,jump,sum),sum);
            jump++;
        }
        return sum;
    }

        public static void main(String args[])
        {
            int arr[] = {2,7,9,3,1};
            System.out.println(rob(arr));
        }
    
}
package SegmentTree;
//segment tree size -> 4*n aprox
//tutorial : /https://www.youtube.com/watch?v=-dUiRtJ8ot0
class ST {

    int[] segT,nums;
    
    public ST(int[] nums) {
        if(nums.length != 0){
        int x = (int) (Math.ceil(Math.log(nums.length) / Math.log(2))); 
        int max_size = 2 * (int) Math.pow(2, x) - 1; 
        segT= new int[max_size];
        this.nums = nums;
        buildTree(0,0,nums.length-1);
        }
    }
    void buildTree(int idx,int left, int right){
        if(left==right){
            segT[idx] = nums[left];
            return;
        }
        int mid = left + (right-left)/2;
        buildTree(2*idx+1,left,mid);
        buildTree(2*idx+2,mid+1,right);
        segT[idx] = segT[2*idx+1] + segT[2*idx+2];
    }
    
    public void point_update(int i, int val){ //update the single cell in O(logn) time
        int diff = val - nums[i];
        nums[i] = val;
        point_update(0,0,nums.length-1,diff,i);
    }
    
    void point_update(int idx, int left, int right, int diff,int i){
        if (i < left || i > right) return; 
        segT[idx] += diff;
        if(left>=right) return;
        int mid = left + (right-left)/2;
        point_update(2*idx+1,left,mid,diff,i);
        point_update(2*idx+2,mid+1,right,diff,i);
    }
    
    public int sumRange(int i, int j) {
       return query(0,0,nums.length-1,i,j);
    }
    
    int query(int idx, int left, int right,int l, int r){
        if(left >= l && right <= r)  return segT[idx];    //complete overlap
        if(right < l || left > r) return 0; //outside the range 
        int mid = left + (right-left)/2;
        int leftSum = query(2*idx+1,left,mid,l,r);
        int rightSum = query(2*idx+2,mid+1,right,l,r);
        return leftSum+rightSum;
    }
}
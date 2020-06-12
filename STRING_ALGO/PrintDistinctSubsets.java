package STRING_ALGO;
import java.util.*;
//https://leetcode.com/problems/subsets/


/*Time complexity: (n*2^n) to generate all subsets and then copy them into output list.

Space complexity:  (n*2^n) to keep all the subsets of length NN, since each of NN elements could be present or absent.
 */

//method 1 cascading
public class PrintDistinctSubsets {
    /*
    Steps:
    1-> add empty subset to your answer set
    
    Traverse from o to n-1 elements
    2 -> pick i'th element add it to all the existing subsets(the subsets which you previously added to your answer set)
    */
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> v = new ArrayList<>();  //create answer set, lets call it v
        v.add(new ArrayList<>());  // add empty subset to your answer set
        for(int i=0; i<nums.length; i++){
            int size=v.size(); //store the current size (as arraylist is dynamic if you directly use size() in your for loop then this will lead to infinite loop beacause size will be keep growing
            for(int j=0;j<size;j++){
                List<Integer> val = new ArrayList<>(v.get(j)); //get the previous elements of the subset at j'th position
                val.add(nums[i]);  //add the current item 
                v.add(val); // now add this new subset to answer set
            }
        }
        return v;
    }
}

//method 2 Backtracking
//Power set is all possible combinations of all possible lengths, from 0 to n.
class PowerSet {
    List<List<Integer>> v = new ArrayList<>();
    void solve(int idx,int len, List<Integer> val, int[]nums, int n){
        
        if(val.size() == len){
            v.add(new ArrayList<>(val));
            return;
        }
        
        for(int i=idx;i<n;i++){
            val.add(nums[i]);
            solve(i+1,len,val,nums,n);
            val.remove(val.size()-1);
        }
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        
        for(int len=0;len<=n;len++) //loop over the length of combination 
            solve(0,len, new ArrayList<>(), nums,n);
        
        return v;
    }
}

//method 3 - using bitmasking
class PowerSetBitmasking {
    List<List<Integer>> v = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        int RANGE = (1<<nums.length); // 2^n
        for(int i=0;i<RANGE;i++){
            int idx=0,num=i;
            List<Integer> val = new ArrayList<>();
            while(num>0){
                if((num & 1) == 1) val.add(nums[idx]);
                idx++;
                num = num>>1;
            }
            v.add(val);
        } 
        return v;
    }
}

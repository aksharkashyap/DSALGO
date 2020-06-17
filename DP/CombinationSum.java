package DP;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
   
        List<List<Integer>> v = new ArrayList<>();
        
        void solve(int[] weight, int target, int i, int j, List<Integer> list){
            
            if(i>=j || target < 0) return;
            
            if(target == 0){
                v.add(new ArrayList<>(list));
                return;
            }
            
            list.add(weight[i]);
            solve(weight,target-weight[i],i,j,list); //include 
            
            list.remove(list.size()-1); 
            solve(weight,target,i+1,j,list);       //dont include
        }
        
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            solve(candidates, target,0,candidates.length, new ArrayList<>());
            return v;
        }

}
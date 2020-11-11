package BackTracking;
import java.util.List;
import java.util.ArrayList;

class SubsetGenerate{
    
    static void power_set(int[]set, List<Integer> subList,int start,int n){ 
      
        System.out.println(subList);

        for(int i=start;i<n;i++){
            subList.add(set[i]);
            power_set(set, subList, i+1, n);
            subList.remove(subList.size()-1);
        }

    } 

    public static void main(String[] args) {
        int[]arr = {1,2,3};
        int n = arr.length;
        power_set(arr,new ArrayList<>(),0,n);
    }
}

//for bitmasking verion see -> BitManipulation folder
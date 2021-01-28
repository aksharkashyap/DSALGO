package Stackk;
import java.util.*;
//next largetst element to the right
class $_1_NLE{

    static void solve(int arr[], int n){
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];
        
        for(int i=n-1;i>=0;i--){

            if(stack.size() == 0){
                ans[i] = -1;
            }
            else {
                while(!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
                if(stack.size() == 0) arr[i] = -1;
                else ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        System.out.print(Arrays.toString(ans));
        
    }
    public static void main(String[] args) {
        int ar[] = {4,2,2,4,5,6};
        int n = ar.length;
        solve(ar,n);
    }
}

/**
 *  the complexity is still order of N only, as the second loop is subjective to a condition. 
 * Try to dry run the code and you will get it. In such problems where "the second loop is subjective to a 
 * condition" it is usually a constant factor (K) * N complexity, where k can be >1 or even <1 
 * (depends upon the each problem input) but no where near O(N^2).
 */
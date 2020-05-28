package Stackk;
import java.util.*;

public class $_3_StockSpan {

    static class Pair{
        int val, idx;
        Pair(int val, int idx){
            this.val=val;
            this.idx=idx;
        }
    }

    static void solve(int arr[],int n){
        Stack<Pair> stack = new Stack<>();
     
        int ans[] = new int[n];
       
        for(int i=0;i<n;i++){
           
            if(stack.size() == 0 || stack.peek().val > arr[i]){
                    ans[i] = 1;
            }else{
                while(stack.size()!=0 && stack.peek().val <= arr[i]) stack.pop();
                if(stack.size() == 0) ans[i] = 1;
                else ans[i] = i - stack.peek().idx;
            }
            stack.push(new Pair(arr[i],i));
        }

        System.out.print(Arrays.toString(ans));

    }
    public static void main(String[] args) {
        int arr[] = {100,80,60,70,60,75,85};
        int n = arr.length;
        solve(arr,n);
    }
}
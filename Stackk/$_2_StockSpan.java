package Stackk;
import java.util.Arrays;
import java.util.Stack;

class StockSpan  {
    
    static void solve(int arr[],int n){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp_stack = new Stack<>();
        int ans[] = new int[n];
       
        for(int i=0;i<n;i++){
            int count=1;
            if(stack.size()==0 || stack.peek() > arr[i]){
                ans[i] = count; 
            }else{
                while(stack.size()>0 && stack.peek() <= arr[i]){
                    temp_stack.push(stack.pop());
                    count++;
                }
                ans[i] = count;
                while(temp_stack.size()!=0) stack.push(temp_stack.pop());
            }
            stack.push(arr[i]);
        }

        System.out.print(Arrays.toString(ans));

    }
    public static void main(String[] args) {
        
        int arr[] = {100,80,60,70,60,75,85};
        int n = arr.length;
        solve(arr,n);
    }
}
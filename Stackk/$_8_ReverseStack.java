package Stackk;
import java.util.Arrays;
import java.util.Stack;

class $_8_ReverseStack{

    static void solve(Stack<Integer> stack){
        if(stack.empty()) return;
        int temp = stack.pop();
        solve(stack);
        helper(stack,temp);
        
    }

    static void helper(Stack<Integer> stack, int x){
        if(stack.empty()) stack.push(x);
        else{
            int temp = stack.pop();
            helper(stack,x);
            stack.push(temp);
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int arr[] = {1,2,3,4,5,6};
        for(int i : arr) stack.push(i);
        solve(stack);
        System.out.println(Arrays.toString(stack.toArray()));
    }
}
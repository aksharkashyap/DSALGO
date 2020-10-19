package Recursion;
import java.util.*;

class DeleteMidOfStack { 

    static void solve(Stack<Integer> stack, int n){
        if(n == 1){stack.pop(); return;}
        int x = stack.pop();
        solve(stack, n-1);
        stack.push(x);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = {1,2,3,4,5};
        for(int x : arr) stack.push(x);
        solve(stack, arr.length - arr.length/2);
        for(int x : stack) System.out.print(x+" ");
    }
}
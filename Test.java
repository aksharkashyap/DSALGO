import java.util.*;
import java.io.*;

class Test{

    static void sort(Stack<Integer> stack){
        if(stack.size() == 0 ) return;
        int x = stack.pop();
        sort(stack);
        helper(stack, x);
    }

    static void helper(Stack<Integer> stack, int val){
        if(stack.size() == 0){
            stack.push(val);
        }
        else if(stack.peek() < val){
            int x = stack.pop();
            helper(stack, val);
            stack.push(x);
        }
        else{
            stack.push(val);
        }
    }


    public static void main(String[] args) {
        int[]arr = {1,6,5,4,5};
        Stack<Integer> stack = new Stack<>();
        for(int v : arr) stack.push(v);
        sort(stack);
        while(stack.size()>0) System.out.print(stack.pop()+" ");
    }
}
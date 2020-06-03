package Stackk;

import java.util.Stack;
import java.util.Arrays;
import java.util.ListIterator;
class SortStack{

    static void solve(Stack<Integer> stack){
        if(stack.empty()) return;
        int temp = stack.pop();
        solve(stack);
        helper(stack,temp);
        
    }

    static void helper(Stack<Integer> stack, int x){
        if(stack.empty()) stack.push(x);
        else{
            int temp = stack.peek();
            if(x < temp){
                stack.pop();
                helper(stack, x);
                stack.push(temp);
            }
            else stack.push(x);
        }
    }

    static void printStack(Stack<Integer> s) 
    { 
       ListIterator<Integer> lt = s.listIterator(); 
         
       // forwarding 
       while(lt.hasNext()) 
           lt.next(); 
         
       // printing from top to bottom 
       while(lt.hasPrevious()) 
           System.out.print(lt.previous()+" "); 
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int arr[] = {6,5,3,4,6,1};
        for(int i : arr) stack.push(i);
        solve(stack);
        System.out.println(Arrays.toString(stack.toArray()));
    }
    
}
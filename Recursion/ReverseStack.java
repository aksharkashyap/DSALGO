package Recursion;
import java.util.*;
class RevereseStack{
    
    static void reverse_stack(Stack<Integer> stack){
        if(stack.size() == 0)return;
        int s = stack.pop();
        reverse_stack(stack);
        insert_at_bottom(stack,s);
    }

    static void insert_at_bottom(Stack<Integer> stack,int s){
        if(stack.isEmpty()) stack.push(s);
        else{int a = stack.pop();
            insert_at_bottom(stack,s);
            stack.push(a);
        }
    }
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        int x[] = {1,2,3,4,5,6};
        for(int i: x) stack.push(i);
        
        reverse_stack(stack);
        while(stack.size()!=0) System.out.println(stack.pop());
    }
}
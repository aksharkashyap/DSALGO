package Stackk;
import java.util.Stack;

/*
Approach 1: using 2 stacks
Approach 2 : using single max variable (major problem is Integer overflow){
    push : Encrypted_top_value = 2 * x - max
           [to remember the old max value, we put the encrypted value into the stack]
    pop :  max = 2 * max - stack.pop() 
           [max has smaller value than stack_top -> fetch the old max value, 
           because current max element is now going to be popped]
}
*/
class MaxStack  {

    Stack<Integer> value_stack = new Stack<>();
    int max = -1;
   
    int peek_max(){
        if(value_stack.size() == 0) return -1;
        return max;
    }
   
    void pop(){
       if(value_stack.size() == 0) return;
       if(value_stack.peek() > max){
           max = 2 * max - value_stack.pop();
       }
       else{
           value_stack.pop();
       }
    }
   
    void push(int x){
       if(value_stack.size() == 0){
           max = x;
           value_stack.push(x);
       }
       else if(x > max){
           value_stack.push(2 * x - max);
           max = x;
       }
       else{
           value_stack.push(x);
       }
   }
}

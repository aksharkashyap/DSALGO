package Stackk;
//implement stack with push(),pop(),getMin()
import java.util.Stack;

class $_7_MinStack{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    int getMin(){
        if(stack2.size() == 0) return -1;
        return stack2.peek();
    }

    void push(int x){
        if(stack2.size() == 0) stack2.push(x);
        else if(stack2.peek() > x) stack2.push(x);
        
        stack1.push(x);
    }

    int pop(){
        int a = -1;
        if(stack1.size() != 0){
           a = stack1.pop();
            if(a == stack2.peek()) stack2.pop();
        }
        return a; 
    }

    public static void main(String[] args) {
        $_7_MinStack a = new $_7_MinStack();
        a.push(5);
        System.out.println(a.getMin());
        a.push(-5436);
        a.push(-342);
        System.out.println(a.getMin());
        a.pop();
        System.out.println(a.getMin());

    }
}
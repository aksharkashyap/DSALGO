package Design;
//implement stack with push(),pop(),getMin()
import java.util.Stack;
// O(n) space
class MinStack{
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
        MinStack a = new MinStack();
        a.push(5);
        System.out.println(a.getMin());
        a.push(-5436);
        a.push(-342);
        System.out.println(a.getMin());
        a.pop();
        System.out.println(a.getMin());

    }
}


//O(1) space

class MinStack_2{
    Stack<Integer> stack = new Stack<>();
    int min=0;

    void push(int x){
        if(stack.size() == 0){
            min = x; 
            stack.push(x);
        }
        if(x < min){
            stack.push(2 * x - min);
            min = x;
        }
        else stack.push(x);
    }

    void pop(){
        if(min > stack.peek()) min = 2* min - stack.peek();
        stack.pop();
    }

    int getMin(){
        return min;
    }

    int top() {
        if(stack.peek() < min) return min;
        return stack.peek();
    }

}












package Java;
import java.util.*;
class MinStack {

    //https://leetcode.com/problems/min-stack/discuss/522390/Java-singly-linked-list-with-2-pointers-3-ms-beats-100-time-!!
    /** initialize your data structure here. */
    int min = Integer.MAX_VALUE;
    Stack sta = new Stack();
    Node TOP;
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            next = null;
        }
    }
    
    public void push(int x) {
        Node new_node = new Node(x);
        if(TOP == null)
            TOP = new_node;
        Node temp = TOP;
        TOP = new_node;
        new_node.next = temp;
        
        if(min>=x)
            {min = x;
            if(!sta.isEmpty()) sta.pop();
            sta.push(x);
            }
    }
    
    public void pop() {
        if(TOP == null)
            {}
        Node temp = TOP;
        TOP = temp.next;
    }
    
    public int top() {
        return TOP.val;
    }
    
    public int getMin() {
        return (int)sta.peek();
    }

    public static void main(String args[]){
       
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}


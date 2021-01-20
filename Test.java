import java.util.*;
import java.io.*;

class Test{


    public static void main(String[] args) {
        int[] arr = {11,12,13,14,15,16,17,18,19,20};
        Queue<Integer> Q = new LinkedList<>();
        for(int v : arr) Q.offer(v);
        int size = Q.size();
        int half = size / 2;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<half;i++){
            insertAtBottom(stack,Q.poll());
        }
        for(int i=0;i<half;i++){
            Q.offer(stack.pop());
            Q.offer(Q.poll());
        }
        while(Q.size()>0) System.out.println(Q.poll());
    }

    static void insertAtBottom(Stack<Integer> stack, int val){
        if(stack.size() == 0){
            stack.push(val);
            return;
        }
        int x = stack.pop();
        insertAtBottom(stack, val);
        stack.push(x);
    }
}
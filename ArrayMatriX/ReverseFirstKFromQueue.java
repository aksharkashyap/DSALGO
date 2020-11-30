package ArrayMatriX;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class ReverseFirstKFromQueue{

    public static void main(String[] args) {
        //Input
        Queue<Integer> Q = new LinkedList<>();
        int[] arr = {1,2,3,4,5,6};
        for(int v : arr) Q.offer(v);
        int k = 3, n = arr.length;
        //Program    
        if(Q.isEmpty() || k > Q.size() || k <=0) return;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<k;i++) stack.push(Q.poll()); // push first k items to Queue
        for(int i=0;i<k;i++) Q.offer(stack.pop()); // offer these k items(stored in stack) into queue from back 
        for(int i=0;i<n-k;i++) Q.offer(Q.poll()); // offer remaining n-k items [poll() from front, offer() from rear]
        for(int i=0;i<n;i++) System.out.print(Q.poll()+" ");

        /**
         * O(N) time
         * O(K) space
         */
    }
}
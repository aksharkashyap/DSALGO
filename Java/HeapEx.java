package Java;
import java.util.*;
/*

//heap is a complete binary treee
Mapping the elements of a heap into an array is trivial: 
if a node is stored a index k, then its left child is 
stored at index 2k+1 and its right child at index 2k+2.

*/
class HeapEx{
    
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //min heap
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //max heap

    public static void minHeap()
    {
        minHeap.add(20);
        minHeap.add(30);
        minHeap.add(40);
        minHeap.remove(); //remove min
        System.out.println("HeadMinHeap: " + minHeap.peek()); // peek min

    }
    public static void maxHeap()
    {   maxHeap.add(20);
        maxHeap.add(30);
        maxHeap.add(40);
        System.out.println("HeadMaxHeap: " + maxHeap.peek());

    }

    public static void printMinHeap()
    {
        Iterator<Integer> itr  = minHeap.iterator();
        while(itr.hasNext())
        {
            System.out.print(" "+itr.next());
        }
    }

    public static void main(String args[]){
        minHeap();
        maxHeap();
        printMinHeap();

    }
}
package LinkedList;

class QuickSortList{
    Node head;
    class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    void print_list(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print("->"+temp.val);
            temp = temp.next;
        }
        System.out.println();
    }

    Node partition(Node start, Node end){

        if(start == end || start == null || end == null) return start;

        Node pivot_prev = start;
        Node curr = start;
        int pivot  = end.val;

        while(start!=end){
            if(start.val <= pivot){
                pivot_prev = curr;
                int temp = curr.val;
                curr.val = start.val;
                start.val = temp;
                curr = curr.next;
            }
            start = start.next;
            if(start == null) break;
        }
        int temp = curr.val;
        curr.val = pivot;
        end.val = temp;

        return pivot_prev;
    }

    void sort(Node start, Node end){
        if(start == end) return;
        Node pivot_prev = partition(start, end);

        sort(start, pivot_prev);  // recure to left side

        if(pivot_prev!=null && pivot_prev == start)  //if pivot is start
            sort(pivot_prev.next, end);  
        else if(pivot_prev!=null && pivot_prev.next!=null) // if pivot is in between the start and end
            sort(pivot_prev.next.next, end);
    }

    public static void main(String[] args) {
        
        QuickSortList list = new QuickSortList();
        Node node1 = list.new Node(12);
        Node node2 = list.new Node(21);
        Node node3 = list.new Node(22);
        Node node4 = list.new Node(14);
        Node node5 = list.new Node(13);
        Node node6 = list.new Node(20);
        Node node7 = list.new Node(21);
        list.head = node1;
        node1.next = node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;

        Node end = list.head;
        while(end.next!=null) end = end.next;
        
        list.print_list(list.head);
        list.sort(list.head,end);
        list.print_list(list.head);
    }

}


/**
 * Why is Merge Sort preferred for Linked Lists?

In case of linked lists the case is different mainly due to difference in memory allocation of arrays and linked lists. 
Unlike arrays, linked list nodes may not be adjacent in memory.

Unlike array, in linked list, we can insert items in the middle in O(1) extra space and O(1) time. 

Therefore merge operation of merge sort can be implemented without extra space for linked lists.

In arrays, we can do random access as elements are continuous in memory. 

Let us say we have an integer (4-byte) array A and let the address of A[0] be x then to access A[i], 
we can directly access the memory at (x + i*4). Unlike arrays, we can not do random access in linked list.

Quick Sort requires a lot of this kind of access. 

In linked list to access i’th index, 
we have to travel each and every node from the head to i’th node as we don’t have continuous block of memory.
 
Therefore, the overhead increases for quick sort. Merge sort accesses data sequentially and the need of 
random access is low.
 */
package LinkedList;
//swapping method
// o(n^2)
// space -o(n)
// traverse head to null
// pass the curr_node to sort_forward
// sort-> compare the curr_value to-> head to curr_node and place it to currect position
public class InsertionSortList2 {
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

    
    void sort_forward(Node head, Node j){
        
        while(head!=j){
            if(head.val > j.val){
                int temp = head.val;
                head.val = j.val;
                j.val = temp;
            }
            head = head.next;
        }
    }

    void insertion_sort(Node head){
        if(head==null || head.next==null) return;
        Node j = head.next;
        while(j!=null){
            sort_forward(head,j);
            j = j.next;
        }
    }
 
    //[10,20,30,4,5,11,23,12,9]
    public static void main(String[] args) {
        InsertionSortList2 list = new InsertionSortList2();
        Node node1 = list.new Node(40);
        Node node2 = list.new Node(40);
        Node node3 = list.new Node(40);
        Node node4 = list.new Node(40);
        list.head = node1;
        node1.next = node2;
        node2.next=node3;
        node3.next=node4;

        list.print_list(list.head);
        list.insertion_sort(list.head);
        list.print_list(list.head);
    }
}

/**
 * This algorithm is a slight modification of insertion sort for arrays, the need of modification 
 * arose because linked list can't be traversed backwards, 
 * so we need to traverse in forward direction if we want to preserve the O(n^2) time complexity
 * 
 * /* 
 Algorithm steps:
 1) traverse list head until head becomes null
 2) pass the curr_node to "sort_forward" function
 3) sort_forward function ->compare the curr_value from head to curr_node and place it to currect position

*** time complexity - > O(n^2) (worst case occurs when list is reverse sorted)
*** space complexity -> O(1)


Note-> Still if you want to perform insertion sort exactly as we do for arrays, then the worst case time complexity will be o(n^3) becuase here we have to find the back_pointer in order to traverse backwards and for that we need to traverse from head to current pointer additionally for each if condition where (list(back_ptr) < list(curr_ptr])
in the worst case when list is reverse sorted we need to find back_ptr for every current node,
hence leading to time complexity O(n^3)
 */
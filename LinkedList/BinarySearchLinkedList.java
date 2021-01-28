package LinkedList;
import LinkedList.LinkedListUtil.ListNode;

public class BinarySearchLinkedList {
 

     ListNode middle_node(ListNode start, ListNode last){ 
        if (start == null) 
            return null; 
  
        ListNode slow = start; 
        ListNode fast = start.next; 
  
        while (fast != last) 
        { 
            fast = fast.next; 
            if (fast != last)  
            { 
                slow = slow.next; 
                fast = fast.next; 
            } 
        } 
        return slow; 
    } 

    private ListNode binary_search(ListNode head, int val){
        ListNode start = head;
        ListNode last = null;

        do{
            ListNode mid = middle_node(start, last);
            if(mid == null) return null;
            if(mid.val == val) return mid;

            else if(mid.val < val) start = mid.next;
            else last = mid;

        }while(last == null || last!=start);

        return null;
    }

    public static void main(String[] args) {
        BinarySearchLinkedList list = new BinarySearchLinkedList();
        LinkedListUtil util = new LinkedListUtil();
        util.print(util.head);
        if (list.binary_search(util.head,4) == null)
            System.out.println("\nValue not present");
        else System.out.println("\nvalue present"); 
    }
}
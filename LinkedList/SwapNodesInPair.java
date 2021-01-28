package LinkedList;
import LinkedList.LinkedListUtil.ListNode;
import java.util.ArrayList;

public class SwapNodesInPair {
    //RECURSIVE
    public ListNode swapPairs(ListNode head) {
        if(head == null)  return head;
        if(head.next == null) return head; //to handle odd length list
        ListNode node = swapPairs(head.next.next); // jump two nodes
        ListNode temp = head.next; // this will be returned so keep it
        head.next.next = head; //alter pointer(swapping)
        head.next = node;  // link current pointer to the returned pointer
        return temp;
    }
}

//iterative
class SwapNodeInPair2 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;
        while (point.next != null && point.next.next != null) { 
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;
            point.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            point = swap1;
        }
        return dummy.next;
    }
}


 // Iterative using space
 class SwapNodeInPair3 {
    class Pair{
        ListNode key,value;
        Pair(ListNode key, ListNode value){
            this.key = key;
            this.value = value;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ArrayList<Pair> map = new ArrayList<>();
        ListNode curr = head;
        
        while(curr!=null){
            map.add(new Pair(curr,curr.next));
            if(curr.next !=null) curr = curr.next.next;
            else curr = curr.next;
        }
        
        ListNode dummy = new ListNode(0);
        curr = dummy;
        for(Pair m : map){
            if(m.value == null){
                curr.next = m.key;
                curr = curr.next;
            }
            else{
                curr.next = m.value;
                m.value.next = m.key;
                curr = m.key;
            }
        }
        curr.next = null;
        return dummy.next;
    }
}
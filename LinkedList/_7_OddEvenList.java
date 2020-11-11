package LinkedList;

class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
//my 
class OddEvenList2 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
       
        ListNode oddNode = head;
        ListNode evenNode = new ListNode(0),even=evenNode;
        ListNode trackOdd = null; //to handle even length linkedlist
        
        while(oddNode!=null && oddNode.next!=null){
            even.next = oddNode.next;
            even = even.next;
            
            oddNode.next = oddNode.next.next;
            trackOdd = oddNode;
            oddNode = oddNode.next;
        }
        even.next = null;
        if(oddNode == null) trackOdd.next = evenNode.next;
        else if(oddNode.next == null) oddNode.next = evenNode.next;  
        return head;
    }
}
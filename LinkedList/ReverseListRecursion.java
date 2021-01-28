package LinkedList;

import LinkedList.LinkedListUtil.ListNode;

public class ReverseListRecursion {
 
    ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        //change references for middle chain 
        head.next.next = head;
        head.next = null;
        //send back new head node in every recursion 
        return last;
    }
    public static void main(String[] args) {
        ReverseListRecursion list = new ReverseListRecursion();
        LinkedListUtil util = new LinkedListUtil();
        util.print(util.head);
        ListNode h = list.reverse(util.head);
        util.print(h);
    }

}
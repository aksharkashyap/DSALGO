package LinkedList;

import LinkedList.LinkedListUtil.ListNode;
public class ReverseBetweenTwo {
   
    ListNode reverse_util(ListNode head,ListNode ptr1, ListNode ptr2){
        if(head == null || head.next == null) return head;
        ListNode prev = ptr2.next; //initialize prev to ptr2.next to avoid lossing the further nodes after ptr2
        ListNode curr = ptr1; 
        //------------reverse given range
        while(curr!=ptr2){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;
        
        //----------------------------uptil now ptr1 to last tak ka data we get now-> head to ptr1 ke nodes link krna hi
        if(head == ptr1 && curr == ptr2) return curr; // agar puri list hi reverse ho chuki hi to return curr direct
        else{
            ListNode temp=head;
            while(temp.next!=ptr1)
                temp = temp.next;
            temp.next = curr;
            return head;
        }
    }


    public static void main(String[] args) {
        ReverseBetweenTwo list = new ReverseBetweenTwo();
        LinkedListUtil util = new LinkedListUtil();
        util.print(util.head);
        ListNode x = list.reverse_util(util.head,util.node1,util.node4);
        util.print(x);

    }
}
package LIST;
//Given a linked list, rotate the list to the right by k places, where k is non-negative.
//https://leetcode.com/problems/rotate-list/

public class _5_RotateList {

        public ListNode rotateRight(ListNode head, int k) {
            if(head == null) return null;
            
            int length=0;
            ListNode temp = head;
            while(temp!=null){ temp = temp.next; length++;} 
            
            k = k % length; //improvement [newK = k % length]  this will make sure that upper loop wont run more than LENGTH time (because if k is very large then normal brute force will become much slower)
            
            ListNode curr,tail,headBeforeRotation; curr=tail=head;
            while(k-->0){
                headBeforeRotation = curr;
                while(curr.next!=null){
                    tail = curr;
                    curr = curr.next;
                }
                curr.next = headBeforeRotation;
                tail.next = null;
            }
            
            return curr;  
        }
}
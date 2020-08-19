package LIST;

//remove duplicates from sorted list 2 - leetcode
public class RemoveDuplicates2 {
    
    public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode curr = head,prev = null;
            while(curr!=null){
                if(curr.next!=null && curr.val == curr.next.val){
                    while(curr.next!=null && curr.val == curr.next.val) curr = curr.next; 
                    if(prev!=null) prev.next = curr.next; //skip the duplicates
                    else head = curr.next; //handle the case where head is having duplicates 
                }
                else prev = curr;
                curr = curr.next;
            }
           return head;
    }
}
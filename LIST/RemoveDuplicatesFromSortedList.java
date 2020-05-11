package LIST;

public class RemoveDuplicatesFromSortedList {
   
    class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    
        public ListNode deleteDuplicates(ListNode head) {
        
            if(head == null || head.next == null) return head;
            
            ListNode result;
            
            if(head.val == head.next.val)
                result = deleteDuplicates(head.next);
            else{ 
                 result = head;
                 result.next = deleteDuplicates(head.next);
            }
            return result;
        }
    
}
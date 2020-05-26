package LIST;
/*
Time Complexity: O(N) considering the list consists of N nodes.
We process each of the nodes at most once 
 * (we don't process the nodes after the n^{th} node from the beginning.
Space Complexity: O(1) since we simply adjust some pointers in the original 
linked list and only use O(1) additional memory for achieving the final result
*/
public class ReverseBwTwo4 {
    public class ListNode {
        int val;
        ListNode next;
       ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(head == null || head.next == null) return head;
            ListNode ptr1=head ,ptr2=head;
            int counter=1;
            while(counter++ !=m)
                ptr1 = ptr1.next;
            
            counter=1;
            while(counter++ !=n)
                ptr2 = ptr2.next;
                
            ListNode prev = ptr2.next; 
            ListNode curr = ptr1; 
            //------------reverse given range
            while(curr!=ptr2){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            curr.next = prev;
        
            if(head == ptr1 && curr == ptr2) return curr;
            else{
                ListNode temp=head;
                while(temp.next!=ptr1)
                    temp = temp.next;
                temp.next = curr;
                return head;
            }
        }
    
}
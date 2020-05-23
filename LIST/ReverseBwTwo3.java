package LIST;

public class ReverseBwTwo3 {
    
//First, I know the classic recursive way to reverse a linked list:
    public class ListNode {
        int val;
        ListNode next;
       ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
//Then I come up this way to reverse the first N elements:

    ListNode successor = null;
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }    
//Finally I solve this problem:

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            // You can also expand the code here to get rid of the helper function 'reverseN'
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
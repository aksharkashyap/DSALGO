package LIST;
import LIST.LinkedListUtil.ListNode;

class PalindromeLinkedList {
    
    boolean flag=true;
    ListNode solve(ListNode p1, ListNode p2){
        if(p1 == null) return p2;
        ListNode node = solve(p1.next,p2);
        if(node.val != p1.val) flag = false;
        return node.next;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode p1,p2;
        p1=p2=head;
        solve(p1,p2);
        return flag;
    }
}
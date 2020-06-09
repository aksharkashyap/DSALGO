package LIST;
import LIST.LinkedListUtil.ListNode;
/*approaches:
1) goto middle and reverse the half list 
2) use stack
3) use recursion
*/
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

//iterative solution
// O(1) spcae
// o(n) time
class PalindromeLinkedList2 {
    
    public boolean isPalindrome(ListNode head) {
        ListNode p1,mid,fast,midTemp=null;
        mid=fast=p1=head;
        
        //goto midddle
        while(fast !=null && fast.next!=null){
            mid = mid.next;
            fast = fast.next.next;
        }
        
        ListNode t=null;
        //start reversing
        while(mid !=null){
            t = mid.next;
            mid.next = midTemp;
            midTemp = mid;
            mid = t; 
        }
        
       //now traverse both the heads simultaneously 
        while(midTemp!=null){
            int x = midTemp.val;
            int y = p1.val;
            if(x!=y) return false;
            midTemp=midTemp.next;
            p1=p1.next;
        }
        
        return true;
    }
}
package LIST;

public class MergeTwoSortedList {

  static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
  // iterative
    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(l1!=null && l2!=null){
            if(l1.val > l2.val){
                head.next = l2;
                l2 = l2.next;
            }    
        
            else if(l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
            }
             head = head.next;
            }
        while(l1!=null){
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }
        while(l2!=null){
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        
        if(l1 == null && l2 == null)
            head.next= null;

        return dummy.next;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return l1;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        return merge(l1,l2);
    }
}

//recursive
/*
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode result;
        if(l1.val <= l2.val){
                result = l1;
                result.next = mergeTwoLists(l1.next,l2);
        }else{
            result = l2;
            result.next = mergeTwoLists(l1,l2.next);
        }
        
        return result;
    } 
*/
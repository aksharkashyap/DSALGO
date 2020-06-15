package LIST;
import java.util.*;

public class CloneList {

    class ListNode{
        int val;
        ListNode next;
        ListNode random;
        ListNode(int val){
            this.val = val;
            next=random=null;
        }
    }

/**The idea is to use Hashing. Below is algorithm.
    1. Traverse the original linked list and make a copy in terms of data.
    2. Make a hash map of key value pair with original linked list node and copied linked list node.
    3. Traverse the original linked list again and using the hash map adjust the next and random reference of 
       cloned linked list nodes. 
*/

    public ListNode copyRandomList(ListNode head) {
        if(head == null) return null;
        Map<ListNode,ListNode> map = new HashMap<>();
        ListNode orgCurr=head, cloneCurr=null;
        
        while(orgCurr!=null){
            cloneCurr = new ListNode(orgCurr.val);
            map.put(orgCurr,cloneCurr);
            orgCurr = orgCurr.next;
        }
        orgCurr = head;
        
        while(orgCurr!=null){
            cloneCurr = map.get(orgCurr);
            cloneCurr.next = map.get(orgCurr.next);
            cloneCurr.random = map.get(orgCurr.random);
            orgCurr = orgCurr.next;
        }
        
        return map.get(head);
    }

}
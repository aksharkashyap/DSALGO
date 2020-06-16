package LIST;

import java.util.*;


class ListNode{
    int val;
    ListNode next;
    ListNode random;
    ListNode(int val){
        this.val = val;
        next=random=null;
    }
}
public class CloneList {

    

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

// o(1) solution
class CloneList2 {

    public ListNode copyRandomList(ListNode head) {
        if(head==null) return null;
        ListNode cloneNode=null, orgNode=head;

        while(orgNode != null) {
            cloneNode = new ListNode(orgNode.val);
            cloneNode.next = orgNode.next;
            orgNode.next = cloneNode;
            orgNode = cloneNode.next;
        }
        orgNode = head;
        cloneNode = orgNode.next;
        while(orgNode != null) {
            if(orgNode.random!=null) orgNode.next.random = orgNode.random.next;
            orgNode = orgNode.next.next;
        }
        orgNode = head;
        cloneNode = orgNode.next;
        ListNode newNode = cloneNode;
        while(orgNode != null) {
            orgNode.next = newNode.next;
            if(newNode.next != null) newNode.next = newNode.next.next;
            orgNode = orgNode.next;
            newNode = newNode.next;
        }
        return cloneNode;
    }
}
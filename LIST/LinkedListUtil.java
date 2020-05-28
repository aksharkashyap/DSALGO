package LIST;

public class LinkedListUtil {
    ListNode head;
    ListNode node1,node2,node3,node4,node5;
    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { 
            this.val = val; 
            next = null;
        }
    }

   LinkedListUtil(String x){    //linked list of 0,1,2s
    node1 = new ListNode(1);
    node2 = new ListNode(1);
    node3 = new ListNode(2);
    node4 = new ListNode(0);
    node5 = new ListNode(2);
    head = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
   }
   LinkedListUtil(){
     node1 = new ListNode(2);
     node2 = new ListNode(3);
     node3 = new ListNode(4);
     node4 = new ListNode(5);
     node5 = new ListNode(6);
    head = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
   }

   public void print(ListNode head2){
        while(head2!=null)
            {
                System.out.print(head2.val + "->");
                head2 = head2.next;
            }
            System.out.print("NULL\n");
    }
}
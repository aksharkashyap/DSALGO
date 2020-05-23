package LIST;

public class ReverseListRecursion {
    ListNode head;
    class ListNode {
        int val;
        ListNode next;
    
        ListNode(int val) { 
            this.val = val; 
            next = null;
        }
    }

    ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    void print(ListNode head){
        while(head!=null)
            {
                System.out.print(head.val + "->");
                head = head.next;
            }
            System.out.print("NULL");
    }


    public static void main(String[] args) {
        ReverseListRecursion list = new ReverseListRecursion();
        ListNode node1 = list.new ListNode(1);
        ListNode node2 = list.new ListNode(2);
        ListNode node3 = list.new ListNode(3);
        ListNode node4 = list.new ListNode(4);
        ListNode node5 = list.new ListNode(5);
        list.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode h = list.reverse(list.head);
        list.print(h);
    }

}
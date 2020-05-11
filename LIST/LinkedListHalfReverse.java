package LIST;
public class LinkedListHalfReverse {
    Node head;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    Node reverse_half(Node root) {
        Node dummy = new Node(0);
        Node head = dummy;
        Node slow, fast;
        slow = fast = root;
        // ------------------
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // ------------------
        Node temp = root;
        while (temp != slow) {
            head.next = temp;
            head = head.next;
            temp = temp.next;
        }
        head = temp;

        // ------------------
        Node prev, next;
        prev = next = null;
        Node current = slow.next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = prev;
        // ----------------------
        return dummy.next;
    }

    void print_list(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListHalfReverse list = new LinkedListHalfReverse();
        Node node1 = list.new Node(1);
        Node node2 = list.new Node(2);
        Node node3 = list.new Node(3);
        Node node4 = list.new Node(4);
        Node node5 = list.new Node(5);
        list.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node get = list.reverse_half(list.head);
        list.print_list(get);

    }



}
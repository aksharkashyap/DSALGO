package LinkedList;
//reverse list between 1 to n

public class Reverse1ToN {
    Node head;
    class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    Node successor;
    Node reverse(Node head, int n){
        if(n == 1){
            successor = head.next;
            return head;
        }
        Node last = reverse(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    static void print_list(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print("->"+temp.val);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Reverse1ToN list = new Reverse1ToN();
        Node node1 = list.new Node(1);
        Node node2 = list.new Node(2);
        Node node3 = list.new Node(3);
        Node node4 = list.new Node(4);
        Node node5 = list.new Node(5);
        Node node6 = list.new Node(6);
        Node node7 = list.new Node(7);
        list.head = node1;
        node1.next = node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        Node x = list.reverse(node1, 3);
        print_list(x);
    }
}
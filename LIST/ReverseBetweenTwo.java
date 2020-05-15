package LIST;

import LIST.MergeSortLinkedList.Node;

public class ReverseBetweenTwo {
    Node head;
    class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    Node reverse_util(Node head,Node ptr1, Node ptr2){
        if(head == null || head.next == null) return head;
        Node prev = ptr2.next; //initialize prev to ptr2.next to avoid lossing the further nodes after ptr2
        Node curr = ptr1; 
        //------------reverse given range
        while(curr!=ptr2){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;
        
        //----------------------------uptil now ptr1 to last tak ka data we get now-> head to ptr1 ke nodes link krna hi
        if(head == ptr1 && curr == ptr2) return curr; // agar puri list hi reverse ho chuki hi to return curr direct
        else{
            Node temp=head;
            while(temp.next!=ptr1)
                temp = temp.next;
            temp.next = curr;
            return head;
        }
    }

    void print_list(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print("->"+temp.val);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseBetweenTwo list = new ReverseBetweenTwo();
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
        list.print_list(list.head);
        Node x = list.reverse_util(list.head,node2, node4);
        list.print_list(x);

    }
}
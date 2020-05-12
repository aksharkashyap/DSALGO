package LIST;

public class BinarySearchLinkedList {
    Node head;
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            next = null;
        }
    }

    private void print_list(){
        Node temp = head;
        while(temp!=null){
            System.out.print("->"+temp.val);
            temp = temp.next;
        }
        System.out.println();
    }

     Node middle_node(Node start, Node last){ 
        if (start == null) 
            return null; 
  
        Node slow = start; 
        Node fast = start.next; 
  
        while (fast != last) 
        { 
            fast = fast.next; 
            if (fast != last)  
            { 
                slow = slow.next; 
                fast = fast.next; 
            } 
        } 
        return slow; 
    } 

    private Node binary_search(Node head, int val){
        Node start = head;
        Node last = null;

        do{
            Node mid = middle_node(start, last);
            if(mid == null) return null;
            if(mid.val == val) return mid;

            else if(mid.val < val) start = mid.next;
            else last = mid;

        }while(last == null || last!=start);

        return null;
    }

    public static void main(String[] args) {
        BinarySearchLinkedList list = new BinarySearchLinkedList();
        Node node1 = list.new Node(11);
        Node node2 = list.new Node(13);
        Node node3 = list.new Node(14);
        Node node4 = list.new Node(15);
        list.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        list.print_list();
        if (list.binary_search(list.head,15) == null)
            System.out.println("Value not present");
        else System.out.println("value present"); 
    }
}
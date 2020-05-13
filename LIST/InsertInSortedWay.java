package LIST;
// create a list in such a way so that elements are in sorted order
class InsertInSortedWay{

    Node head;
    class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    void print_list(){
        Node temp = head;
        while(temp!=null){
            System.out.print("->"+temp.val);
            temp = temp.next;
        }
        System.out.println();
    }

    void sortedInsert(Node new_node) 
    { 
         Node current; 
         /* Special case for head node */
         if (head == null || head.val >= new_node.val) { 
            new_node.next = head; 
            head = new_node; 
         } 
         else { 
            /* Locate the node before point of insertion. */
            current = head; 
            while (current.next != null && current.next.val < new_node.val) 
                  current = current.next; 
            new_node.next = current.next; 
            current.next = new_node; 
         } 
     } 
    public static void main(String[] args) {
        InsertInSortedWay list = new InsertInSortedWay();
        Node node1 = list.new Node(1);
        Node node2 = list.new Node(3);
        Node node3 = list.new Node(5);
        Node node4 = list.new Node(4);
        list.sortedInsert(node1);
        list.sortedInsert(node2);
        list.sortedInsert(node3);
        list.sortedInsert(node4);
        list.print_list();
    }

}
    /*
    Node insert(Node head,Node node){
        if(node == null) return null;
        Node temp = head;
        Boolean flag = true;
        Node prev = null;

        //-----------before head node
        if(head.val > node.val){
            node.next = head;
            head = node;
            return head;
        }

        //between two nodes----------
        while(temp!=null && flag){
            if(temp.val > node.val){
                Node t = prev.next;
                prev.next = node;
                node.next= t;
                flag = false;
            }
            prev = temp;
            temp = temp.next;
        }
        //---------------------------
        //after last end
        if(flag){
            prev.next = node;
        }
        return head;
    }

// geek solve
    public static void main(String[] args) {
        InsertInSortedWay list = new InsertInSortedWay();
        Node node1 = list.new Node(24);
        Node node2 = list.new Node(89);
        Node node3 = list.new Node(93);
        Node node4 = list.new Node(24);
        list.head = node1;
        node1.next = node2;
        node2.next=node3;

        list.print_list(list.head);
        Node x = list.insert(list.head,node4);
        list.print_list(x);
    }
}
*/

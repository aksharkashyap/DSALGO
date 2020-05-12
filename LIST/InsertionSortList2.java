package LIST;

public class InsertionSortList2 {
    Node head;
    class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
            this.next = null;
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

    
    Node find_back_ptr(Node root, Node i){
        while(root!=null && root.next!=i)
            root=root.next;
        return root;
    }

    void insertion_sort(Node head){
        Node i = head;
        Node j;
        while(i!=null){
            Node i_temp = i;
            j = i_temp.next;

            while(i_temp!=null && j!=null && i_temp.val > j.val){
                int temp = i_temp.val;
                i_temp.val = j.val;
                j.val = temp;
                //---------------shift back the pointers
                j=i_temp;
                i_temp = find_back_ptr(head, i_temp);
              
            }

          i = i.next;  
        }
    }

    public static void main(String[] args) {
        InsertionSortList2 list = new InsertionSortList2();
        Node node1 = list.new Node(4);
        Node node2 = list.new Node(2);
        Node node3 = list.new Node(1);
        Node node4 = list.new Node(3);
        list.head = node1;
        node1.next = node2;
        node2.next=node3;
        node3.next=node4;

        list.print_list(list.head);
        list.insertion_sort(list.head);
        list.print_list(list.head);
    }
}
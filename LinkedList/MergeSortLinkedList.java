package LinkedList;

/** Applications-
 * merge two sorted lists
 * remove duplicates from sorted list
 */

public class MergeSortLinkedList {
    Node head;
    class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
  
    Node getMid(Node head){ 
        if (head == null) return head; 
        Node slow = head, fast = head.next; 
        while (fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        return slow; 
    } 
    
    Node merge_sort(Node head){
        if(head == null || head.next == null) return head;
        Node mid = getMid(head);
        Node nextOfMid = mid.next;
        mid.next = null;
        Node left = merge_sort(head);
        Node right = merge_sort(nextOfMid);
        Node sorted_list = sorted_merge(left,right);
        return sorted_list;
    }
    Node sorted_merge(Node left, Node right){
        if(left == null) return right;
        if(right == null) return left;
        Node result = null;
        if(left.val <= right.val){
            result = left;
            result.next = sorted_merge(left.next, right);
        }else{
            result = right;
            result.next = sorted_merge(left, right.next);
        }

        return result;
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
        MergeSortLinkedList list = new MergeSortLinkedList();
        Node node1 = list.new Node(12);
        Node node2 = list.new Node(21);
        Node node3 = list.new Node(22);
        Node node4 = list.new Node(14);
        Node node5 = list.new Node(13);
        Node node6 = list.new Node(20);
        Node node7 = list.new Node(21);
        list.head = node1;
        node1.next = node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        list.print_list(list.head);
        list.merge_sort(list.head);
        list.print_list(list.head);
    }
}


   /*
   public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
            
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(slow);
        return merge(firstHalf, secondHalf);
    }
    }*/




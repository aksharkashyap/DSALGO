package LinkedList;

import LinkedList.LinkedListUtil.ListNode;
//given two linkedlist 
//multiply nmber represented by them 

public class _2_MultiplicationList {
    
    static void multiply(ListNode l1, ListNode l2){
 
        int n1=0,n2=0;

        while(l1!=null){
            n1 = n1 * 10 + l1.val;
            l1 = l1.next;
        }
        while(l2!=null){
            n2 = n2 * 10 + l2.val;
            l2 = l2.next;
        }
        System.out.print(n1*n2);
    }

    public static void main(String[] args) {

        LinkedListUtil util = new LinkedListUtil();
        ListNode list2 = new ListNode(4);
        list2.next = new ListNode(5);
        multiply(util.head,list2);
    }
}
package LIST;
import LIST.LinkedListUtil.ListNode;
//Given two numbers represented by linked lists, write a function that 
//returns the head of the new linked list that represents the number that is the product of those numbers.
/*
Examples:

Input : 9->4->6
        8->4
Output : 7->9->4->6->4
*/

public class _3_MultiplyList {

    ListNode addition(ListNode h1, ListNode h2){


        return null;
    }

    ListNode multiply(ListNode h1, ListNode h2,int n){
        ListNode result = new ListNode(0);
        ListNode temp=result;

        //multiply 


        //------------------------------

        //insert 0 at head if(required) // verfify it
        ListNode head = new ListNode(0);
        ListNode h=head;
        ListNode x = result.next;
        while(n-- >0){
            ListNode t = new ListNode(0);
            t.next = x;
            x = t;
            h.next = t;
            h = h.next;
        }

        return n>0 ? head.next : result.next;
    }
    
    void solve(ListNode h1 , ListNode h2, ListNode h3){
        ListNode result = new ListNode(0);
        ListNode temp;
        int n=0;
        while(h1!=null){
            ListNode t_h2=h2;
            while(t_h2!=null){
                temp = multiply(h1, t_h2,n);
                result = addition(result,temp);
                t_h2 = t_h2.next;
            }
            n++;
        }

        //reverse result to get the answer or read it from the right
    }


    public static void main(String[] args) {
        LinkedListUtil util = new LinkedListUtil();
        _3_MultiplyList list = new _3_MultiplyList();

        ListNode h1 = new ListNode(5);
        h1.next = new ListNode(4);

        ListNode h2 = new ListNode(2);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(5);

        ListNode h3 = new ListNode(0);
        list.solve(h1,h2,h3);
        util.print(h3.next);
    }

}
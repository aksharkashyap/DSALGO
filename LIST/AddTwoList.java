package LIST;
import LIST.LinkedListUtil.ListNode;
//add two list into a third list
/**
 * Input: List1: 5->6->3  // represents number 365
          List2: 8->4->2 //  represents number 248
Output: Resultant list: 3->1->6  // represents number 613


Input: List1: 7->5->9->4->6  // represents number 64957
       List2: 8->4 //  represents number 48
Output: Resultant list: 5->0->0->5->6  // represents number 65005
 */

class AddTwoList{

    //note -> here h1,h2 are reversed list
    // to get the answer you can reverse the answer list or read it from right to left


    int generateNode(ListNode dummy, int carry, ListNode head){
        int num = head.val + carry;
        int nodeVal = num % 10;
        dummy.next = new ListNode(nodeVal);
        carry = num/10;
        return carry;
    }

    ListNode solve(ListNode h1, ListNode h2,ListNode h3, int carry){
        ListNode dummy=h3;

        while(h1!=null && h2!=null){    // run upto equal length
                int num = h1.val + h2.val + carry;
                int nodeVal = num % 10;
                dummy.next = new ListNode(nodeVal);
                carry = num/10;
                h1 = h1.next;
                h2 = h2.next;
                dummy = dummy.next;
            }

        while(h1!=null){
            carry = generateNode(dummy, carry, h1); //check if h1 is left
            h1 = h1.next;
            dummy = dummy.next;
        }
        while(h2!=null){
            carry = generateNode(dummy, carry, h2);  //check if h2 is left
            h2 = h2.next;
            dummy = dummy.next;
        }
        
        while(carry !=0){
            int nodeVal = carry % 10;
            dummy.next = new ListNode(nodeVal);
            carry = carry/10;
            dummy = dummy.next;
        }
        
        return h3;
    }

    public static void main(String[] args) {
        LinkedListUtil util = new LinkedListUtil();
        AddTwoList list = new AddTwoList();

        ListNode h1 = new ListNode(5);
        h1.next = new ListNode(4);

        ListNode h2 = new ListNode(2);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(5);

        ListNode h3 = new ListNode(0);
        ListNode head = list.solve(h1,h2,h3,0);
        util.print(head.next);
    }

}
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
// O(m + n) where m and n are number of nodes in first and second lists respectively.
class _1_AddTwoList{

    //note -> here h1,h2 are reversed list
    // to get the answer you can reverse the answer list or read it from right to left
    // here we are dealing with the single digits every time so carry can be 1 or 0 only
    // note that every node will contain single digit value only 

    int generateNode(ListNode dummy, int carry, int h1, int h2){
        int num = h1 + h2 +  carry;
        int nodeVal = num % 10;
        dummy.next = new ListNode(nodeVal);
        return num >= 10 ?  1 :  0; //carry  = num/10;
    }

    void solve(ListNode h1, ListNode h2,ListNode h3, int carry){
        ListNode dummy=h3; //you can return it as well

        while(h1!=null && h2!=null){    // run upto equal length
            carry = generateNode(dummy, carry, h1.val,h2.val);
            h1 = h1.next;
            h2 = h2.next;
            dummy = dummy.next;
            }

        while(h1!=null){
            carry = generateNode(dummy, carry, h1.val,0); //check if h1 is left
            h1 = h1.next;
            dummy = dummy.next;
        }

        while(h2!=null){
            carry = generateNode(dummy, carry, h2.val,0);  //check if h2 is left
            h2 = h2.next;
            dummy = dummy.next;
        }
        
        if(carry !=0) dummy.next = new ListNode(carry);
        
    }

    public static void main(String[] args) {
        LinkedListUtil util = new LinkedListUtil();
        _1_AddTwoList list = new _1_AddTwoList();

        ListNode h1 = new ListNode(5);
        h1.next = new ListNode(4);

        ListNode h2 = new ListNode(2);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(5);

        ListNode h3 = new ListNode(0);
        list.solve(h1,h2,h3,0);
        util.print(h3.next);
    }

}
package LinkedList;
import LinkedList.LinkedListUtil.ListNode;
//Given two numbers represented by linked lists, write a function that 
//returns the head of the new linked list that represents the number that is the product of those numbers.
/*
Examples:
Input : 9->4->6
        8->4
Output : 7->9->4->6->4
*/ 
/** algo-> old school method
*  1) reverse h1 and h2
 * 2) init a result list 
 * 3) temp = multiply h1 with every number of h2
 * 4) after every upper loop of h1 insert a 0 at the head of the list in multiply function
 * 5) to achieve step 4 make a count variable and ++ it on every h1=h1.next and pass it to multiply function
 * 6) while(n>0) push 0 to head
   7) result.next = addition of(temp, result.next)
   8) finally reverse the result.next list or read it from right

  */
public class _3_MultiplyList {
    
    int generateNode(ListNode dummy, int carry, int h1, int h2){
        int num = h1 + h2 +  carry;
        int nodeVal = num % 10;
        dummy.next = new ListNode(nodeVal);
        return num >= 10 ?  1 :  0; //or carry  = num/10; (when digit can cotain more than 1 digit)
    }
    ListNode addition(ListNode h1, ListNode h2, int carry){
        ListNode h3= new ListNode(0); 
        ListNode dummy = h3;
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
            carry = generateNode(dummy, carry,0,h2.val);  //check if h2 is left
            h2 = h2.next;
            dummy = dummy.next;
        }
        if(carry !=0) dummy.next = new ListNode(carry); 
        return h3.next;
    }
  
    ListNode multiply(ListNode h1, ListNode h2,int n){ // multiply h1 with all the numbers of h2
        ListNode result = new ListNode(0);
        ListNode temp=result;
        int carry=0;

        //multiply 
        while(h2!=null){
            int mult = h1.val * h2.val + carry;
            carry = mult/10;
            int val = mult % 10;
            temp.next = new ListNode(val);
            temp = temp.next;
            h2 = h2.next;
        }
        if(carry!=0) temp.next = new ListNode(carry);

        //insert 0 at head if(required)
        ListNode t=null;
        while(n-- >0){
            t = new ListNode(0);
            ListNode mytemp = result.next;
            result.next = t;
            t.next = mytemp;
        }

        return n>0 ? t : result.next;
    }
    
    void solve(ListNode h1 , ListNode h2, ListNode result){
        ListNode temp;
        int n=0;
        while(h1!=null){
            temp = multiply(h1, h2,n);
            result.next = addition(result.next,temp,0);
            h1 = h1.next;
            n++;
        }
         //reverse result to get the answer or read it from the right
    }

    public static void main(String[] args) {
         LinkedListUtil util = new LinkedListUtil();
        _3_MultiplyList list = new _3_MultiplyList();

        ListNode h1 = new ListNode(5);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(5);

        ListNode h2 = new ListNode(2);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(5);
        
        //number is 545 * 532
        //h1 and h2 are reversed list

        ListNode h3 = new ListNode(0);
        list.solve(h1,h2,h3);
        util.print(h3.next);
    }

}
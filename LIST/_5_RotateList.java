package LIST;
//Given a linked list, rotate the list to the right by k places, where k is non-negative.
//https://leetcode.com/problems/rotate-list/

public class _5_RotateList {

        public ListNode rotateRight(ListNode head, int k) {
            if(head == null) return null;
            
            int length=0;
            ListNode temp = head;
            while(temp!=null){ temp = temp.next; length++;} 
            
            k = k % length; //improvement [newK = k % length]  this will make sure that upper loop wont run more than LENGTH time (because if k is very large then normal brute force will become much slower)
            
            ListNode curr,tail,headBeforeRotation; curr=tail=head;
            while(k-->0){
                headBeforeRotation = curr;
                while(curr.next!=null){
                    tail = curr;
                    curr = curr.next;
                }
                curr.next = headBeforeRotation;
                tail.next = null;
            }
            
            return curr;  
        }
}

//Optimization 2 : Eliminating the 1st traversal for calculating the length [1ms]

class _5_RotateList_2 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int orgK = k;
        int length=0;
    
        ListNode curr,tail,headBeforeRotation; curr=tail=head;
        while(k-->0){
            headBeforeRotation = curr;
            while(curr.next!=null){
                tail = curr;
                curr = curr.next;
                if((k+1)==orgK) length++;  //this condition will make sure that it will run only for the first time to calculate the length
            }
            curr.next = headBeforeRotation;
            tail.next = null;
            if((k+1) ==orgK) k = k % (length+1); // now update the k and we are done 
        }
        return curr;  
    }
}

//Optimization 3: Time complexity : O(n) [0ms]

class _5_RotateList_3 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int length=0;
        ListNode curr=head;
        while(curr!=null){ length++; curr = curr.next;} //calculate length
        k = k % (length); // optimize k 
        if(k == 0) return head; // if k == 0 means no rotation 
        
        curr = head; // curr.next will hold the new head
        ListNode pos = curr;
        int dest = length-k; // this will give the position where the new head lies
        
        while(pos.next!=null){ 
            if(dest-- > 1)curr = curr.next;
            pos = pos.next;
        }
        pos.next = head; //set the last element's next pointer to the old head 
        head = curr.next; // replace old head reference to the new head (curr.next is the new head)
        curr.next = null; // make curr.next to the null so that curr(new head's prev node) doesn't point to the head(because curr will become last element so make it point to the null)
        return head;  
    }
}
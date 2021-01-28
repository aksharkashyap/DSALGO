package LinkedList;
/*
Following steps can be used to sort the given linked list.

Traverse the list and count the number of 0s, 1s and 2s. Let the counts be n1, n2 and n3 respectively.
Traverse the list again, fill the first n1 nodes with 0, then n2 nodes with 1 and finally n3 nodes with 2.
*/

import LinkedList.LinkedListUtil.ListNode;

class SortLinkedList {

    void sort(ListNode head){
        int count[] = {0,0,0};
        ListNode ptr = head;
        while(ptr!=null){ //count occurance
            count[ptr.val]++;
            ptr = ptr.next;
          }

        //fill values
        ptr = head;
        int i=0;
        while(ptr!=null){
            if(count[i] == 0 ) i++;
            else{ 
                ptr.val = i;
                --count[i];
                ptr = ptr.next;
            }
        }
    }

    public static void main(String[] args) {
        SortLinkedList list = new SortLinkedList();
        LinkedListUtil util = new LinkedListUtil("ListOf0s");
        list.sort(util.head);
        util.print(util.head);
    }
}


// my naive method
/*ListNode head;
    int a=0,b=0,c=0;
    class ListNode {
        int val;
        ListNode next;
    
        ListNode(int val) { 
            this.val = val; 
            next = null;
        }
    }

    void count_occurances(ListNode head){
        while(head!=null){
            if(head.val == 0) a++;
            if(head.val == 1) b++;
            if(head.val == 2) c++;
            head = head.next;
        }
    }
    
    void sort(ListNode head){
        while(head!=null){
            if(a>0){
                head.val = 0;
                a--;
            }
            else if(b>0){
                head.val = 1;
                b--;
            }
            else if(c>0){
                head.val = 2;
                c--;
            }
            head = head.next;
        }
    }*/
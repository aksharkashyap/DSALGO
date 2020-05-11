package Java;
 
class MergeList {
 static ListNode head;
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
   }
    
    public static ListNode sort(ListNode node){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(node!=null){
            ListNode node2 = node.next;
            int min = node.val;
            ListNode minNode = node;
            while(node2!=null){
                if(node2.val < min){ 
                    min = node2.val;
                    minNode = node2;
                }
                node2 = node2.next;
            }
            //--------add-------
          //  System.out.print(minNode.val+" ");
            head.next = minNode;
            head = head.next;
            int temp = node.val;
            minNode.val = temp;
            //-------------------- 
            node = node.next;
        }
        head.next = null;
        return dummy.next;
    }
    
    
    
    public static ListNode sortList(ListNode head) {
        if(head==null)
            return null;
        return sort(head);
    }


    public static void main(String[] args) {
        ListNode newnode = new ListNode(4);
        head = newnode;
        ListNode n2n = new ListNode(3);
        head.next = n2n;
        sortList(head);
    }
}
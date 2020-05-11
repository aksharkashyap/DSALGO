package LIST;
public class FlattenList {
    Node head;
    class Node{
        Node next;
        Node down;
        int val;
        Node(int x){
            val=x;
            next=null;
            down=null;
        }
    }

  public void print(Node head){
    Node temp = head;
    while(temp!=null){
        System.out.print(temp.val+" ");
        temp = temp.down;
    }
  }


  private Node merge(Node a, Node b){
    if(a==null) return b;
    if(b==null) return a;
    Node res;
    if(a.val > b.val){
        res = new Node(b.val);
        res.down = merge(a, b.down);
    }else{
        res = new Node(a.val);
        res.down = merge(a.down, b);
    }
    return res;
  }
    
  public Node flatten(Node head){
    //iterative
    Node temp=head;
    Node a = head;
    while(temp!=null){
        Node down_temp = temp.next;
        while(down_temp!=null){
          a = merge(a,down_temp);
          down_temp = down_temp.down;
        }
        temp = temp.next;
    }
    return a;
    
    //recursive
    /*if(head==null || head.next==null) 
        return head;
    return merge(head,flatten(head.next));*/
  }
    public static void main(String[] args) {
        FlattenList list = new FlattenList();
        //next pointers
        Node node1 = list.new Node(20);
        Node node2 = list.new Node(25);
        Node node3 = list.new Node(28);
        Node node4 = list.new Node(33);
        Node node5 = list.new Node(36);
        list.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //down pointers
        Node node6 = list.new Node(21);
        Node node7 = list.new Node(22);
        Node node8 = list.new Node(23);
        node1.down = node6;
        node6.down = node7;
        node7.down = node8;
        list.print(list.flatten(list.head));
    }
}
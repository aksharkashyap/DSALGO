package TREE;
//implementation doubly linkedlist
class DoublyLinkedList{
  
  class Node{
      int data;
      Node prev,next;
      Node(int data){
        this.data = data;
      }
  }

  private final Node HEAD, TAIL;
  private int SIZE;
    
  DoublyLinkedList(){
    HEAD = new Node(0);
    TAIL = new Node(0);
    HEAD.next = TAIL;
    HEAD.prev = null;
    TAIL.prev = HEAD;
    TAIL.next = null;
  }

  int size(){
    return SIZE;
  }
  void increaseSize(){
    SIZE += 1;
  }
  void decreaseSize(){
    SIZE -= 1;
  }

  void addFirst(int data){
    Node node = new Node(data);
    //connect head's next node to current node
    HEAD.next.prev = node;
    node.next = HEAD.next;
    //now change dummy head's next
    HEAD.next = node;
    node.prev = HEAD;
    //increase size
    increaseSize();
  }

  int getFirst(){
    return size() == 0 ? null : HEAD.next.data;
  }

  int getLast(){
    return size() == 0 ? null : TAIL.prev.data;
  } 

  void addLast(int data){
    Node node = new Node(data);
    TAIL.prev.next = node;
    node.prev = TAIL.prev;
    //change dummy Tail's previuous
    TAIL.prev = node;
    node.next = TAIL;
    //increase size
    increaseSize();
  }

  int removeFirst(){
    if(size() == 0) throw null;
    Node firstNode = HEAD.next;
    firstNode.next.prev = HEAD;
    firstNode.prev = null; // removing first elements back reference
    HEAD.next = firstNode.next; // change first node
    firstNode.next = null; // removing old first nodes next reference 
    decreaseSize();
    return firstNode.data;

  }

  int removeLast(){
    if(size() == 0) throw null;
    Node lastNode = TAIL.prev;
    lastNode.prev.next = TAIL;
    lastNode.next = null;
    TAIL.prev = lastNode.prev;
    lastNode.prev = null;
    decreaseSize();
    return lastNode.data;
  }

  void remove(Node node){
    if(size() == 0 || node == null) return;
    node.prev.next = node.next;
    node.next.prev = node.prev;
    //decrease size
    decreaseSize();
  }

  void iterator(){
    Node node = HEAD.next;
    if(size() == 0 || node == null) return;
    while(node.next!=null){
      System.out.print(node.data+" ");
      node = node.next;
    }
    System.out.println();
  }
}

class MYDLL{
    public static void main(String[] args) {
    
        DoublyLinkedList DLL = new DoublyLinkedList();
        for(int i=0;i<5;i++){
          DLL.addFirst(i);
        }
        for(int i=5;i<10;i++){
          DLL.addLast(i);
        }
        //print items 
        System.out.println("Print item:");
        DLL.iterator();
        
        //size before removal
        System.out.println("Size: " + DLL.size());

        //Remove the last item
        DLL.removeLast();
    
        //After remove
        System.out.println("After removing the last item:");
        DLL.iterator();
    
        //size after removal
        System.out.println("Size after removal: " + DLL.size());

        System.out.println("Remove Last: " + DLL.removeLast());
        System.out.println("Remove First: " + DLL.removeFirst());
      }
}
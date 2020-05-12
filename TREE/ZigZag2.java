package TREE;
import java.util.*; 
//zigzag traversal using two stacks
// this approach is recommended when u want to use it as a subroutine of another program

public class ZigZag2 {
    Node rootNode;
    static class Node { 
        int data; 
        Node leftChild; 
        Node rightChild; 
        
        Node(int data){ 
            this.data = data;  
        } 
    } 
    
    private void printZigZagTraversal() {

        if(rootNode == null) return;
        Stack<Node> curr = new Stack<>();
        Stack<Node> next = new Stack<>();
        curr.push(rootNode);
        boolean isLeftToRight = true;
        while(!curr.isEmpty()){
            Node temp = curr.pop();
            System.out.print(temp.data +" ");

            if(isLeftToRight){
                if(temp.leftChild!=null) next.push(temp.leftChild);
                if(temp.rightChild!=null) next.push(temp.rightChild);
            }else{
                if(temp.rightChild!=null) next.push(temp.rightChild);
                if(temp.leftChild!=null) next.push(temp.leftChild);
            }

            if(curr.isEmpty()){ // change the level 
                isLeftToRight = !isLeftToRight;
                Stack<Node> t = curr;
                curr = next;
                next = t;
            }
        }
    }

    public static void main(String[] args) {
        ZigZag2 tree = new ZigZag2(); 
        tree.rootNode = new Node(1); 
        tree.rootNode.leftChild = new Node(2); 
        tree.rootNode.rightChild = new Node(3); 
        tree.rootNode.leftChild.leftChild = new Node(7); 
        tree.rootNode.leftChild.rightChild = new Node(6); 
        tree.rootNode.rightChild.leftChild = new Node(5); 
        tree.rootNode.rightChild.rightChild = new Node(4); 
    
        System.out.println("ZigZag Order traversal of binary tree is"); 
        tree.printZigZagTraversal(); 
    }
}
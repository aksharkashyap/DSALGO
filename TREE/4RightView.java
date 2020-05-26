package TREE;

//same as left view only diff is that we have to reucrr for right subtree first to get the rightmost node first
class RightView {
    Node root;
    int max=0;
    static class Node{
        int val;
        Node left,right;
        Node(int x){
            val = x;
            left=right=null;
        }
    }

    void right_view(Node root, int h){
        if(root == null) return;
        if(max < h){
            System.out.print(root.val+" ");
            max=h;
        }
        right_view(root.right,h+1);
        right_view(root.left,h+1);
    }


    public static void main(String[] args) {
        RightView tree = new RightView(); 
        Node root = new Node(20);
        tree.root = root; 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        //root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14);
        tree.right_view(root, 1);
    }
}
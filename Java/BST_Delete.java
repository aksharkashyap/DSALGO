package Java;
class BST_Delete{
    Node root;
    class Node{
        Node left,right;
        int data;
        Node(int x){
                data=x;
                left=right=null;
        }
    }

    static Node findMin(Node root){
        Node parent=null;
        while(root.left!=null)
        {
            parent = root;
            root = root.left;
        }
        parent.left = null;
        return root;
    }
    static Node delete(Node root,int key){

        if(key < root.data)
            root.left = delete(root.left,key);
        else if(key > root.data)
            root.right = delete(root.right,key);
        else{
            //leaf node
            if(root.left == null && root.right == null)
                root=null;
            // left child
            else if(root.left!=null && root.right == null)
                {root = root.left;
                root.left = null;}
            //right child    
            else if(root.right!=null && root.left == null)
                {root = root.right;
                root.right = null;}
            //2child
            else{
                Node min = findMin(root.right);
                root.data = min.data;
            }
        }
        return root;

    }

    static void inorder(Node root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
public static void main(String args[]){

    BST_Delete bst = new BST_Delete();
    Node node10 = bst.new Node(10);
    Node node5 = bst.new Node(5);
    Node node20 = bst.new Node(20);
    Node node3 = bst.new Node(3);
    Node node8 = bst.new Node(8);
    Node node15 = bst.new Node(15);
    Node node7 = bst.new Node(7);
    Node node9 = bst.new Node(9);
    bst.root = node10;
    node10.left = node5;
    node10.right = node20;
    node20.left = node15;
    node5.left = node3;
    node5.right = node8;
    node8.left = node7;
    node8.right = node9;
    int key = 5;
    inorder(bst.root);
    delete(bst.root,key);
    System.out.println();
    inorder(bst.root);

}


}
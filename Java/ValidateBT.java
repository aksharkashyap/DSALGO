
/*package Java;
class ValidateBT{
    Node root;
    
    class Node{
        Node left,right;
        int data;
        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    }


    /* // not working for some cases - USE the recursive and limit approch
    static boolean validate(Node root)
    {  
        /* boolean flag=false;
            if(root == null)
                return true;
            if(root.left == null && root.right == null)
                return true;
            if(root.left!=null && root.left.data < root.data)
                flag = validate(root.left);
            else if(root.left!=null && root.left.data > root.data)
                return false;
            if(root.right!=null && root.right.data > root.data)
                flag = validate(root.right);
            else if(root.right!=null && root.right.data < root.data)
                return false;
        
        return flag;
    }
    */

    /*

    public static void main(String args[])
    {
        ValidateBT bt = new ValidateBT();
        Node node10 = bt.new Node(10);
        Node node5 = bt.new Node(5);
        Node node15 = bt.new Node(15);
        Node node6 = bt.new Node(6);
        Node node20 = bt.new Node(20);
       // Node node11 = bt.new Node(11);
        bt.root = node10;
        node10.left=node5;
        node10.right=node15;
        node15.left=node6;
        node15.right = node20;
        //node13.left = node11;
        boolean v = validate(bt.root);
        if(v)
            System.out.println("\nBST\n");
        else System.out.println("\nNOT A BST\n");

    }
}
*/
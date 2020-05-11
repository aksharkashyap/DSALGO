package GRAPH;

public class TreeCentre {
    TreeNode root;
     class TreeNode{
        TreeNode[] child;
        int val;
        TreeNode(int val){
            this.val = val;
            child = null;
        }
        TreeNode(){
            child = null;
        }

    }

    void find_cetre(TreeNode root){

    }

    public static void main(String[] args) {

        TreeCentre t = new TreeCentre();

        TreeNode a = t.new TreeNode(1);
        TreeNode b = t.new TreeNode(2);
        TreeNode c = t.new TreeNode(3);
        TreeNode d = t.new TreeNode(4);
        TreeNode e = t.new TreeNode(5);
        TreeNode f = t.new TreeNode(6);
        t.root = a;
        a.child = new TreeNode[3];
        a.child[0] = b;
        a.child[1] = c;
        a.child[2] = d;
        c.child = new TreeNode[2];
        c.child[0] = e;
        c.child[1] = f;
        
        t.find_cetre(t.root);
        
    }
}
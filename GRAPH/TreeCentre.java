package GRAPH;

<<<<<<< HEAD
public class TreeCentre {
    
=======
import java.util.Arrays;

public class TreeCentre {
    TreeNode root;
     class TreeNode{
        TreeNode[] child;
        int val;
        TreeNode(int val){
            this.val = val;
            child = null;
        }
    }

    void find_degree(TreeNode root, int degree[]){
        if(root == null) return;
        System.out.print(root.val);
        degree[root.val] = 1+root.child.length;
        for(int i=0;i<root.child.length;i++)
            find_degree(root.child[i], degree);
    }
    void find_cetre(TreeNode root, int[]degree){

    }

    public static void main(String[] args) {

        TreeCentre t = new TreeCentre();

        TreeNode a = t.new TreeNode(0);
        TreeNode b = t.new TreeNode(1);
        TreeNode c = t.new TreeNode(2);
        TreeNode d = t.new TreeNode(3);
        TreeNode e = t.new TreeNode(4);
        TreeNode f = t.new TreeNode(5);
        t.root = a;
        a.child = new TreeNode[3];
        a.child[0] = b;
        a.child[1] = c;
        a.child[2] = d;
        c.child = new TreeNode[2];
        c.child[0] = e;
        c.child[1] = f;
        int V = 6;
        int degree[] = new int[V];
        t.find_cetre(t.root,degree);
        t.find_degree(t.root, degree);
        System.out.println(Arrays.toString(degree));
    }
>>>>>>> 2ca8082c487b7225863f6745a8fb3bd08aca4d50
}
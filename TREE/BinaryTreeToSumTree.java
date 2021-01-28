package TREE;
/*
Given a Binary Tree where each node has positive and negative values.
Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree.
The values of leaf nodes are changed to 0.

For example, the following tree

                  10
               /      \
             -2        6
           /   \      /  \ 
         8     -4    7    5
        
         should be changed to

                 20(4-2+12+6)
               /      \
         4(8-4)      12(7+5)
           /   \      /  \ 
         0      0    0    0

*/
class Tree{
    public void toSumTree(Node root){
         solve(root);
    }
    //method 1 
    int solve(Node root){
        if(root == null) return 0;
        int originalLeft = solve(root.left); //to store original(given)value of left child
        int originalRight = solve(root.right); //to store original value of right child
        int root_val = root.data;
        int updatedLeft = (root.left == null ? 0 : root.left.data);
        int updatedRight = (root.right == null ? 0 : root.right.data);
        root.data = updatedLeft + updatedRight + originalLeft + originalRight; //update current root
        return root_val;  // send root's previous value for parent
    }


    //method 2
    int sumTree(Node node){ 
        // Base case 
        if (node == null) 
            return 0; 
   
        // Store the old value 
        int old_val = node.data; 
   
        // Recursively call for left and right subtrees and store the sum 
        // as new value of this node 
        node.data = sumTree(node.left) + sumTree(node.right); 
   
        // Return the sum of values of nodes in left and right subtrees 
        // and old_value of this node 
        return node.data + old_val; 
    } 
}

package TREE;
import java.util.*;
/*
class VerticalOrderTraversal{
    List<Node> bucket[];
    Node root;
    static class Node { 
        int data; 
        Node leftChild; 
        Node rightChild; 
        
        Node(int data){ 
            this.data = data;  
        } 
    } 

    int left_distance(Node root){
        if(root == null) return 0;
        return left_distance(root.leftChild)+1;
    }
    int right_distance(Node root){
        if(root == null) return 0;
        return right_distance(root.rightChild)+1;
    }

    void solve(Node root){
       int left_bucket = left_distance(root);
       int right_bucket = right_distance(root);
       int bucket_size = left_bucket + right_bucket -1;
       int root_bucket_num = left_bucket-1;

       bucket = new ArrayList[bucket_size];
       for(int i=0;i<bucket_size;i++){
           bucket[i] = new ArrayList<>();
       }

       dfs(root, bucket, root_bucket_num);
       print_solution();
    }

    void dfs(Node root, List<Node>[] bucket, int n){
        if(root == null) return;
        bucket[n].add(root);
        dfs(root.leftChild, bucket, n-1);
        dfs(root.rightChild,bucket,n+1);
    }

    void print_solution(){
        for(int i=0;i<bucket.length;i++){
            for(int j=0;j<bucket[i].size();j++){
                System.out.print(bucket[i].get(j).data+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        VerticalOrderTraversal tree = new VerticalOrderTraversal(); 
        tree.root = new Node(1); 
        tree.root.leftChild = new Node(2); 
        tree.root.rightChild = new Node(3); 
        tree.root.leftChild.leftChild = new Node(4); 
        tree.root.leftChild.rightChild = new Node(5); 
        tree.root.rightChild.leftChild = new Node(6); 
        tree.root.rightChild.rightChild = new Node(7); 
        tree.root.rightChild.leftChild.rightChild = new Node(8); 
        tree.root.rightChild.rightChild.rightChild = new Node(9); 
        tree.solve(tree.root);
    }
}
*/

//using ArrayList

class VerticalOrderTraversal{
    List<List<Integer>> bucket;
    Node root;
    int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
    static class Node { 
        int data; 
        Node leftChild; 
        Node rightChild; 
        
        Node(int data){ 
            this.data = data;  
        } 
    } 

    void horizonatal_distance(Node root, int n){
        if(root == null) return;
        if(n<min) min = n;
        if(n>max) max = n;
        horizonatal_distance(root.leftChild,n-1);
        horizonatal_distance(root.rightChild,n+1);
    }

    void solve(Node root){
      horizonatal_distance(root,0);
       int bucket_size = Math.abs(min)+ max;

       bucket = new ArrayList<List<Integer>>(bucket_size);
       for(int i=min;i<=max;i++){
           bucket.add(new ArrayList<>());
       }
       int k=0;
       for(int vertical_line=min;vertical_line<=max;vertical_line++){
           dfs(root,vertical_line,k++,0);
       }
       print_solution();
    }

    void dfs(Node root,int vl ,int pos, int n){
        if(root == null) return;
        if(vl == n) bucket.get(pos).add(root.data);
        dfs(root.leftChild, vl,pos, n-1);
        dfs(root.rightChild,vl,pos,n+1);
    }

    void print_solution(){
        for(int i=0;i<bucket.size();i++){
            for(int j=0;j<bucket.get(i).size();j++){
                System.out.print(bucket.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        VerticalOrderTraversal tree = new VerticalOrderTraversal(); 
        tree.root = new Node(1); 
        tree.root.leftChild = new Node(2); 
        tree.root.rightChild = new Node(3); 
        tree.root.leftChild.leftChild = new Node(4); 
        tree.root.leftChild.rightChild = new Node(5); 
        tree.root.rightChild.leftChild = new Node(6); 
        tree.root.rightChild.rightChild = new Node(7); 
        tree.root.rightChild.leftChild.rightChild = new Node(8); 
        tree.root.rightChild.rightChild.rightChild = new Node(9); 
        tree.solve(tree.root);
    }
}
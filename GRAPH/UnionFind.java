package GRAPH;

public class UnionFind {

    int size; // num of elements in union find
    int[] sz; // size of each component
    int[] id; //parent of i
    int numComponents;

    public UnionFind(int size) {
        if (size <= 0) 
        {   System.out.print("size 0 not allowed");
            return;
        }
            this.size = numComponents = size;
            sz = new int[size]; 
            id = new int[size];
            for(int i=0;i<size;i++){
                id[i] = i; // self loop
                sz[i] = 1; // each component initial size 1
            }
    }

    // find which set/component 'p' belongs to 
    public int find(int p){
       if(p == id[p]) return p;
      // if p is not the parent of itself 
      // Then p is not the representative of his set, 
       return id[p] = find(id[p]);
    }
    /*
    public int find(int p) {

    // Find the root of the component/set
    int root = p;
    while (root != id[root]) root = id[root];

    // Compress the path leading back to the root.
    // Doing this operation is called "path compression"
    // and is what gives us amortized time complexity.
    while (p != root) {
      int next = id[p];
      id[p] = root;
      p = next;
    }

    return root;
  }
 */

    //unify the sets containing elements 'p' and 'q'
    public void unify(int p, int q){

        if(connected(p, q)) return; // elements are already in same group 

        int root1 = find(p);
        int root2 = find(q);

        if(sz[root1] < sz[root2]){ // merge smaller components into larger one
            sz[root2] += sz[root1];
            id[root1] = root2;
        }else{
            sz[root1] += sz[root2];
            id[root2] = root1;
        }
        // since the roots found are different we know that the
        // num of components/sets has decreased by one
        numComponents--;
    }

    // true if 'p' and 'q' are in same set/component
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    
    // size of component 'p' belongs to
    public int componentSize(int p){
        return sz[find(p)];
    }
    // number of elements in this disjoint/union-find set
    public int size(){
        return size;
    }
    //number of remaining components 
    public int components(){
        return numComponents;
    }
    
    public static void main(String[] args) {
        
        UnionFind uf = new UnionFind(5);
        // 0 is a friend of 2 
        uf.unify(0, 2); 
        uf.unify(4, 2); 
        uf.unify(3, 1);       
               
        // Check if 4 is a friend of 0 
        if (uf.find(3) == uf.find(0)) 
                System.out.println("Yes"); 
        else
                System.out.println("No");  
               
               
    }



}
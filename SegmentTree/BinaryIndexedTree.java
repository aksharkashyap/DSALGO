package SegmentTree;
//useful in range sum queries, kth tallest, count inversion
// because it uses less space(len of arr) than segment tree(4*input)
//odd nodes will cover only 1 node's sum
//even nodes will cover 2^(n-1) nodes [n->lsb position]
//video : https://www.youtube.com/watch?v=bFL4-WCuR_o&t=771s

public class BinaryIndexedTree {
    int n = 7;

    int[] BIT = new int[n+1]; // BIT indexing starts from 1
    
    //bottom to up
    void updateBIT(int val, int index,int n){ // update all cells that own us (left to right in arr)
        while(index < n){ 
            BIT[index]+= val;
            index += index & (-index); //move by adding lowest one bit (parent)
        }
    }

    //top to bottom
    int getSum(int index){ //update all cells that we own ( right to left in arr) [if i can accomadate 2 cells then i will direcly take u to the 4th cell]
        int sum=0; 
        while(index>0){ //loop runs exactly number of off/unset/0 bits
            sum += BIT[index];
            index -= index & (-index); //Integer.lowestOneBit(index); //move by removing lowest one bit (child)
        }
        return sum;
    }

    void buildBIT(int arr[]){
        for(int i=0;i<arr.length;i++)
            updateBIT(arr[i],i+1,BIT.length);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        BinaryIndexedTree obj = new BinaryIndexedTree();
        obj.buildBIT(arr);
        System.out.println(obj.getSum(5) - obj.getSum(3));
    }
}
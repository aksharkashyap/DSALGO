package SegmentTree;
//useful in range sum queries, kth tallest, count inversion
// because it uses less space(len of arr) than segment tree(4*input)

public class BinaryIndexedTree {
    int[] BIT = new int[7+1]; // BIT indexing starts from 1
    
    void updateBIT(int val, int index,int n){ // child to parent propogation (left to right in arr)
        while(index < n){ 
            BIT[index]+= val;
            index += index & (-index);
        }
    }

    int getSum(int index){ //parent to child ( right to left in arr)
        int sum=0; 
        while(index>0){
            sum += BIT[index];
            index -= index & (-index);
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
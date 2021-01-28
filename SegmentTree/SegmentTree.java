package SegmentTree;

//segment tree size -> 4*n aprox
public class SegmentTree {
        int[] tree;
        int maxsize;
        int height;
        int STARTINDEX = 0,ENDINDEX,ROOT=0;

        public SegmentTree(int size) {
            height = (int) (Math.ceil(Math.log(size)/Math.log(2)));
            maxsize = 2 * (int) Math.pow(2,height) -1;
            tree = new int[maxsize];
            ENDINDEX = size-1;
        }

        private int leftChild(int pos){
            return 2*pos+1;
        }
        private int rightChild(int pos){
            return 2*pos+2;
        }
        private int mid(int start, int end){
            return  start + (end-start)/2;
        }

        private int getSum(int Qstart, int Qend) {  //o(logn)
            if(Qstart<0 || Qend > tree.length)
                    return -1;
            return getSumUtil(STARTINDEX,ENDINDEX,Qstart,Qend,ROOT);
        }

        private int getSumUtil(int startindex, int endindex, int qstart, int qend, int current) {
            if(startindex >= qstart && qend >= endindex)  //within the range // full overlap
                return tree[current];
            if(startindex > qend || qstart > endindex) // no overlap
                return 0;
            int mid = mid(startindex, endindex);
            return getSumUtil(startindex, mid, qstart, qend, leftChild(current))+  // partial overlap
                    getSumUtil(mid+1, endindex, qstart, qend, rightChild(current));
        }

        private void constructSegmentTree(int[] elements) { // o(n)
            constructSegmentTreeUtil(elements,STARTINDEX,ENDINDEX,ROOT);
        }

        private int constructSegmentTreeUtil(int[] elements, int startindex, int endindex, int current) {
            if(startindex == endindex){
                tree[current] = elements[startindex];
                return tree[current];}
            int mid = mid(startindex,endindex);
            tree[current] = constructSegmentTreeUtil(elements, startindex, mid, leftChild(current))+
                            constructSegmentTreeUtil(elements, mid+1, endindex, rightChild(current));
            return tree[current];
        }

        public void update(int update, int updatPos, int [] elements){
            int updatediff = update - elements[updatPos];
            elements[updatPos] = update;
            updateTreeUtil(STARTINDEX,ENDINDEX,updatPos,updatediff,ROOT);
        }

        private void updateTreeUtil(int startindex, int endindex, int updatePos, int update, int current){
            if(startindex > updatePos || endindex < updatePos)
                return;
            tree[current] = tree[current] + update;
            if(startindex!=endindex)
                {
                    int mid = mid(startindex, endindex);
                    updateTreeUtil(startindex, mid, updatePos, update, leftChild(current));
                    updateTreeUtil(mid+1, endindex, updatePos, update, rightChild(current));
                }
        }

        public static void main(String... arg)
        {
            int[] elements = {1,3,5,7,9,11};
            SegmentTree segmentTree = new SegmentTree(6);
            segmentTree.constructSegmentTree(elements);
            int num = segmentTree.getSum(1, 2);
     
            System.out.println("the num is " + num);
            segmentTree.update(10, 5,elements);
            num = segmentTree.getSum(1, 5);
            System.out.println("the num is " + num);
        }

}
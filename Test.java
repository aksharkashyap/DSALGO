import java.util.Arrays;

class Test{

    //O(m*n)
    //linear search(arr2) * insertion sort (arr1)
    public static void main(String[] args) {
        int[] A = {20,25,40,55,90};
        int[] B = {2,3,4,5,6};
        int m = A.length, n = B.length;
        merge(A,B,m,n);
        System.out.print(Arrays.toString(A));
        System.out.print(Arrays.toString(B));
    }

    static void merge(int[]A, int[]B, int m, int n){

        for(int i=n-1; i>=0;i--){
            int last = A[m-1];
            int j = m-2;
            for(;j>=0 && A[j] >= B[i];j--){
                A[j+1] = A[j];
            }
            if(j != m-2 || last > B[i]){
                A[j+1] = B[i];
                B[i] = last;
            }
        }
    }
}
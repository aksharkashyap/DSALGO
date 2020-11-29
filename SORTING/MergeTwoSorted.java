package SORTING;

import java.util.Arrays;

class MergeTwoSorted{

    //O(m*n) time and O(1) space
    //linear search(arr2) * insertion sort (arr1)
    public static void main(String[] args) {
        int[] A = {20,25,40,55,90};
        int[] B = {2,3,4,5,6};
        int m = A.length, n = B.length;
        merge(A,B,m,n);
        System.out.print(Arrays.toString(A));
        System.out.print(Arrays.toString(B));
    }

    static void merge2(int[]arr1,int[]arr2,int m, int n){

        // traverse the array1 and if arr2 first element is less than arr1 then swap
        for (int i = 0; i < n; i++) {
 
            if (arr1[i] > arr2[0]) {
                // swap to put item to correct position
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
 
                // after swaping we have to sort the array2 again so that it can be again swap with arr1
                // we will store the firstElement of array2 and left shift all the element and store the firstElement in arr2[k-1]
 
                int firstElement = arr2[0];
                int k;
                for (k = 1; k < m && arr2[k] < firstElement; k++){
                    arr2[k - 1] = arr2[k];
                }
                arr2[k - 1] = firstElement;
            }
        }
    }

    //method 2
    static void merge(int[]A, int[]B, int m, int n){

        for(int i=n-1; i>=0;i--){
            int last = A[m-1];
            int j = m-2;
            for(;j>=0 && A[j] >= B[i];j--){
                A[j+1] = A[j]; //shifting
            }
            if(j != m-2 || last > B[i]){
                A[j+1] = B[i];
                B[i] = last;
            }
        }
    }
}

/**
 * worst case
 * A[] = 19 20 21 22 23 24 25
 * B[] = 1 2 3 4 5 6
 * 
 * last > B[i] case
 * A[] = 1 2 8
 * B[] = 3 6 8
 */
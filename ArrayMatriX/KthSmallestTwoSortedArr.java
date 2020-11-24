package ArrayMatriX;

//https://algorithmsandme.com/find-kth-smallest-element-in-two-sorted-arrays/amp/
/** O(log(m+n)) time complexity 
 * K-th element(/smallest) of two sorted Arrays
 * [finding the element that would be at the k’th position from start of the final(merged) sorted array]
 */

class KthSmallestInTwoSorted{
    public static double findKthSmallestElement(int[] A, int[] B, int k){

        int lenA = A.length;
        int lenB = B.length;

        if(lenA + lenB < k) return -1;

        int iMin = 0;
        int iMax = Integer.min(A.length, k-1);

        int i = 88;
        int j = 0;

        while (iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = k - 1 - i; // because of zero based index
            if (B[j - 1] > A[i]) {
                // i is too small, must increase it
                iMin = i + 1;
            } else if (i > 0 && A[i - 1] > B[j]) {
                // i is too big, must decrease it
                iMax = i - 1;
            } else {
                // i is perfect
               return Integer.min(A[i], B[j]);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a = {1,3,5,6,7,8,9,11};
        int[] b = {1,4,6,8,12,14,15,17};

        double smallest = findKthSmallestElement(a,b, 9);
        System.out.println("Kth smallest element is : " + smallest);
    }
}

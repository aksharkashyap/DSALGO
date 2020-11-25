package ArrayMatriX;

//https://algorithmsandme.com/find-kth-smallest-element-in-two-sorted-arrays/amp/
/** O(log(m+n)) time complexity 
 * K-th element(/smallest) of two sorted Arrays
 * [finding the element that would be at the k’th position from start of the final(merged) sorted array]
 */

 /**
  * In order to be kth smallest element, index i and j have to satisfy two conditions:
    A[i] >= B[j-1] and B[j] >= A[i-1] (criss cross condition that ensures that answer will always min(A[i],B[j]))
    i+j  =  k-1 or j = k-1-i
  */

class KthSmallestInTwoSorted{
    public static double findKthSmallestElement(int[] A, int[] B, int k){

        int lenA = A.length, lenB = B.length;

        if(lenA + lenB < k) return -1;

        int iMin = 0;
        int iMax = Math.min(A.length, k-1); //because i has to be in the first array only (i is been calculated using iMin and iMax)

        int i = 0, j = 0;

        while (iMin <= iMax) {
            i = (iMin + iMax) / 2; //index of the first array
            j = k - 1 - i; /* 
                    (1) -1 because of zero based index (indx of 2nd array)
                    (2) k-i (doing this ensure it -> total element(i+j) should not be > k-1) [ hence it must hold, i+j == k-1]
                    because beyond that answer never lies,so no point to search
            */
            if (B[j - 1] > A[i]) {
                // i is too small, must increase it
                iMin = i + 1;
            } else if (i > 0 && A[i - 1] > B[j]) {
                // i is too big, must decrease it
                iMax = i - 1;
            } else {
                // i is perfect
               return Math.min(A[i], B[j]);
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

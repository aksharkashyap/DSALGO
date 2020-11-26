package ArrayMatriX;

//this problem is similar to kth smallest element in two sorted array
//complexity O(log(min(m,n)))

//median will be Max(left) + min(right) / 2 if even len
//or Max(left)

class MedianOfTwoSortedArr {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n [to get min(log(m,n) complexity of binary search)-> iMin and iMax depends on M(len of array 1)]
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
            //or return findMedianSortedArrays(B,A);
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2; // halfLen = m+n+1/2 [here +1 to handle both odd and even length]
        
        //we are calculating halfLen because in merged array the median will always be on Left half
        
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2; // i-> is for arr1
            int j = halfLen - i;  // j-> is for arr2
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; } //all candidate element on arr2
                else if (j == 0) { maxLeft = A[i-1]; } //all candidate element on arr1
                else { maxLeft = Math.max(A[i-1], B[j-1]); } 
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }  //all candidate element on arr2
                else if (j == n) { minRight = A[i]; } //all candidate element on arr1
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
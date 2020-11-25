class KthSmallestInTwoSorted{
    public static int findKthSmallestElement(int[] A, int[] B, int k){

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
               return (B[j]);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int a[] = { 1, 2, 3, 6 }; 
        int b[] = { 4, 6, 8, 10 };
        int alen = a.length;
        int blen = b.length;
        int smallest = findKthSmallestElement(a,b,5);
        System.out.println("Kth smallest element is : " + smallest);
    }
}

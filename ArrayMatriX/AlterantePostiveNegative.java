package ArrayMatriX;

//rearrange array in alternating positive & negative items with O(1) extra space
//note relative ordering does not matter

/* 
1) just fix the positive numbers to their correct position
2) keep in mind that already fixed positive number should not be swapped again
3) negative numbers will automatically be fixed
*/

class AlterantePostiveNegativeest{
    public static void main(String[] args) {
        int[] arr = {1,2,-3,-6,8,4,-5,4,3,5};
        int n  = arr.length;
        int lastPos = 0;
    
        for(int i=0;i<n;i++){
            
            if(i%2 ==0 && i<lastPos && lastPos<n && arr[lastPos]>0){
                continue;
                //postive place, currIdx < lastPos, val[currIdx] is Pos then this value is already fixed to correct position
            }
            if(arr[i] > 0 && lastPos < n){
                swap(arr, lastPos, i);
                lastPos += 2;
            }
           
        }

        for (int val : arr) System.out.print(val+" ");
    }

    static void swap(int[]arr, int lastPos, int i){
        int temp = arr[i];
        arr[i] = arr[lastPos];
        arr[lastPos] = temp;
    }
}


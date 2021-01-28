package ArrayMatriX;
import java.util.Arrays;
//rearrange array in alternating positive & negative items with O(1) extra space
//note relative ordering does not matter

/* 
1) segregate positive numbers to left side
2) negative numbers will automatically be segregated
3) find first indx of negative number from left
4) fix the negatives to their correct position -> 
swap with alterante positive numbers (odd indices) -> swap(1,negIdx), (3,negIndx+1)…….
->we start from the first negative number and 2nd positive number,
and swap every alternate positive number with next negative number
*/

class AlterantePostiveNegativeest{
    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n  = arr.length;
        int lastPos = 0;
        //segregate positive to first side and negative to last side
        for(int i=0;i<n;i++){
            if(arr[i] > 0){
                swap(arr,i,lastPos++);
            }
        }

        //first negative index
        int idx = -1;
        for(int i=0;i<n;i++){
            if(arr[i] < 0){
                idx = i;
                break;
            }
        }
        if(idx == -1) return;
        //System.out.print(Arrays.toString(arr));
        //now swap alternatively

        for(int i=1;i<n && idx<n;i+=2,idx++){
            if(arr[i] < 0) break;
            swap(arr,idx, i);
        }

        System.out.print(Arrays.toString(arr));
    }

    static void swap(int[]arr, int lastPos, int i){
        int temp = arr[i];
        arr[i] = arr[lastPos];
        arr[lastPos] = temp;
    }
}


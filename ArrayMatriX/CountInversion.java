package ArrayMatriX;
/**
 * Given an array A, count the number of inversions in the array.
 * Formally speaking, two elements A[i] and A[j] form an inversion if A[i] > A[j] and i < j
 */
public class CountInversion {

    static int ans = 0;
    
    static int inversionCount(int arr[], int N){
        sort(arr,0,N-1);
        return ans;
    }
    
    static int[] sort(int[]arr, int left, int right){
        if(left > right) return new int[]{};
        if(left==right) return new int[]{arr[left]};
        int mid = left + (right-left)/2;
        int[]leftArr = sort(arr,left,mid);
        int[]rightArr = sort(arr,mid+1,right);
        return merge(leftArr,rightArr);
    }
    
    static int[] merge(int[]left, int[]right){
        int n1 = left.length;
        int n2 = right.length;
        int[]arr = new int[n1+n2];
        
        int k=0;
        int p1=0,p2=0;
        
        while(p1<n1 && p2<n2){
            if(left[p1] > right[p2]){
                arr[k++] = right[p2++];
                ans += n1-p1; //count inversion
            }
            else arr[k++] = left[p1++];
        }
        
        while(p1 < n1){ arr[k++] = left[p1++];}
        while(p2 < n2){ arr[k++] = right[p2++];}
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {3,2,34,1,2};
        System.out.print(inversionCount(arr, arr.length));
    }
}

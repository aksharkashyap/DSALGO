package SORTING;

import java.util.Arrays;

public class MergeSort2 {
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
            if(left[p1] > right[p2]) arr[k++] = right[p2++];
            else arr[k++] = left[p1++];
        }
        
        while(p1 < n1){ arr[k++] = left[p1++];}
        while(p2 < n2){ arr[k++] = right[p2++];}
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10,111,23,1};
        int[] aux = sort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++) arr[i] = aux[i];
        System.out.print(Arrays.toString(aux));
    }
}

package SORTING;

import java.util.Arrays;

class CountSort{

    public static int[] count_sort(int arr[])
    {
        int output[] = new int[arr.length];
        int mMAx = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++)
        {
            mMAx = Math.max(mMAx, arr[i]);
        }
        int count[] = new int[mMAx+1];
        Arrays.fill(count,0);
        for(int i=0;i<arr.length;i++)
        {
                ++count[arr[i]];
        }

        //modify the count so that it can store sum of previous counts;
        for(int i=1;i<=mMAx;i++)
        {
            count[i] += count[i-1];
        }
        //placing the values in our output array
        for(int i=arr.length-1;i>=0;i--)
        {
            output[count[arr[i]-1]]=arr[i];
            --count[arr[i]-1];
        }
        return output;
    }

    public static void main(String args[]){
        int arr[]= {1,10,15,2,30,5};
        int get[]= count_sort(arr);
        for(int i: get){
            System.out.print(i+" ");
        }        
    }

}
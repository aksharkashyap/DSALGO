package SORTING;
import java.util.*;

/*Sort a large set of floating point numbers which are in a range
 and are uniformly distributed across the range*/
public class BucketSort {
    static public void bucket_sort(double arr[],int size){
        List<Double>[]bucket = new ArrayList[size];
        for(int i = 0;i<size;i++)
            bucket[i] = new ArrayList<>();
        
        for(int i=0;i<size;i++)
        {
            double index = arr[i]*size;
            bucket[(int)index].add(arr[i]);
        }
        for(int i=0; i<size;i++)
            Collections.sort(bucket[i]);
        
        int index=0;
        for(int i=0;i<size;i++){
            for(int j=0;j< bucket[i].size();j++){
                 arr[index++] = bucket[i].get(j);
            }
        }     
    }

    public static void main(String ... args) {
        double arr[] = {0.9,0.4,0.5,0.38,0.3,0.2,0.7};
        bucket_sort(arr,arr.length);        
        System.out.println(Arrays.toString(arr));
    }
}

// for integer values---
/**
 * run a for loop in the given array - find max elements
 * declare the size of the bucket as max+1;
 */

/**
 * private int hash(int i, int max, int numberOfBuckets) {
    return (int) ((double) i / max * (numberOfBuckets - 1));
}
With our hash method defined, we can now specify the number of bins as a square root of the input list size:

final int numberOfBuckets = (int) Math.sqrt(initialList.size());
 */
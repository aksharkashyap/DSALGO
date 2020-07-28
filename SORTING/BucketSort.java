package SORTING;
import java.util.*;

/*Sort a large set of floating point numbers which are in a range
 and are uniformly distributed across the range*/

 /** Drawback of count sort ? When to use bucket sort ? 
  Counting sort can not be applied where numbers are in floating point
  as we use keys as index in counting sort. Here keys are floating point numbers
  */
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
            Collections.sort(bucket[i]); // we can use bucket sort recursively here 
        
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


/*Bucket Sort To Sort an Array with Negative Numbers

sortMixed(arr[], n)
1) Split array into two parts 
   create two Empty vector Neg[], Pos[] 
   (for negative and positive element respectively)
   Store all negative element in Neg[] by converting
   into positive (Neg[i] = -1 * Arr[i] )
   Store all +ve in pos[]  (pos[i] =  Arr[i])
2) Call function bucketSortPositive(Pos, pos.size())
   Call function bucketSortPositive(Neg, Neg.size())

bucketSortPositive(arr[], n)
3) Create n empty buckets (Or lists).
4) Do following for every array element arr[i]. 
       a) Insert arr[i] into bucket[n*array[i]]
5) Sort individual buckets using insertion sort.
6) Concatenate all sorted buckets. 

*/

//we can use bucket sort for integers but it doesnt make any sense because the bucket size will be 1
//and also it will take lot of space, 
// we have better algo for integers (count sort)
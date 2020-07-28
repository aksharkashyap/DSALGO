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


/**
 * Complexity
 * 
Worst Case Complexity: O(n2)

When there are elements of close range in the array, they are likely to be placed in the same bucket. 
This may result in some buckets having more number of elements than others.
It makes the complexity depend on the sorting algorithm used to sort the elements of the bucket.
The complexity becomes even worse when the elements are in reverse order. 
If insertion sort is used to sort elements of the bucket, then the time complexity becomes O(n2).

Best Case Complexity: O(n+k)
It occurs when the elements are uniformly distributed in the buckets with a nearly equal number of elements 
in each bucket.
The complexity becomes even better if the elements inside the buckets are already sorted.
If insertion sort is used to sort elements of a bucket then the overall complexity in the best case will be 
linear ie. O(n+k). 
O(n) is the complexity for making the buckets and O(k) is the complexity for sorting the elements of 
the bucket using algorithms having linear time complexity at the best case.


Average Case Complexity: O(n)
It occurs when the elements are distributed randomly in the array. 
Even if the elements are not distributed uniformly, bucket sort runs in linear time. 
It holds true until the sum of the squares of the bucket sizes is linear in the total number of elements.


Bucket Sort Applications
    Bucket sort is used when:
    input is uniformly distributed over a range.
    there are floating point values
 */
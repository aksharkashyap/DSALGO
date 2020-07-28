import java.util.*;

class Test{
  
   static void bucketSort(double[] arr, int size){
      List<List<Double>> bucket = new ArrayList<>();
      size = (int) Math.sqrt(size);

      for(int i=0;i<size;i++) bucket.add(new ArrayList<>());

      for(int i=0;i<arr.length;i++) bucket.get((int)(arr[i] * size)).add(arr[i]);

      for(int i=0;i<size;i++) Collections.sort(bucket.get(i));


      System.out.println(bucket);

      int k=0; for(List<Double> v : bucket){
         for(double val : v) arr[k++] = val;
      }
   }

    public static void main(String[] args) {
      
      double arr[] = {0.5,0.1,0.5,0.2,0.42,0.41,0.53};
      bucketSort(arr,arr.length);
      System.out.print(Arrays.toString(arr));
    }
}

/**
 * iterative inorder,postoder,pre
 */
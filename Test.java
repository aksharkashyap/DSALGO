import java.util.Arrays;
class Test{

   static void countSort(int[] arr, int k){

         int[] count = new int[10];
         int output[] = new int[arr.length];

         for(int i=0;i<arr.length;i++) count[(arr[i]/k) % 10]++;
         
         for(int i=1;i<10;i++) count[i] += count[i-1]; //prefix sum

         for(int i=arr.length-1;i>=0;i--) output[--count[(arr[i]/k) % 10]] = arr[i];

         int i=0; for(int v : output) arr[i++] = v;
   }

    public static void main(String[] args) {
      
      int arr[] = {1234,2134,9853,245,1322};
      int max = 9853; //max element
      for(int i=1; (max/i) >0; i=i*10){ // we need to do -> div by k mod 10 to extract digits 
           countSort(arr, i);
      }
      System.out.print(Arrays.toString(arr));
    }
}

/**
 * iterative inorder,postoder,pre
 */
import java.util.Arrays;

class Test{


    static void sort(int arr[],int n){
        int max = 0;
        int output[] = new int[n];
        for(int v : arr) max = Math.max(v,max);
        int count[] = new int[max+1];

        for(int v : arr) count[v]++; //count
        for(int i=1;i<=max;i++) count[i] += count[i-1]; //modify
        for(int i=n-1;i>=0;i--){
            output[count[arr[i]]-1] = arr[i]; //place values
            count[arr[i]]--;
        }

        System.out.println(Arrays.toString(output));

    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,13,12,5,5};
        sort(arr,arr.length);
    }
}
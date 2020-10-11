import java.util.Arrays;

class Test {

    void buildHeap(int[]arr, int n){

        int idx = (n / 2 ) -1;

        while(idx >= 0){
            heapify(arr, idx, n);
            idx--;
        }

        for(int i=n-1;i>=0;i--){
            swap(arr,0,i);
            heapify(arr,0,i);
          }
    }

    void heapify(int arr[], int idx, int n){ //max heap

        int left = 2*idx + 1;
        int right = 2*idx + 2;

        int largest = idx;

        if(left < n && arr[left] > arr[largest]) largest = left;
        if(right < n && arr[right] > arr[largest]) largest = right;

        if(largest != idx){
            swap(arr, idx, largest);
            heapify(arr, largest, n);
        }
    }

    void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Test obj = new Test();
        int[]arr = {15,2,34,4,5};
        obj.buildHeap(arr, arr.length);
        System.out.print(Arrays.toString(arr));
    }
}
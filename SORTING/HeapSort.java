package SORTING;

import java.util.Arrays;
  class HeapSort{
    
    public void buildHeap(int arr[]){
        int n = arr.length;
        //building max heap of arr elements
        for(int i = (n/2) - 1; i >= 0 ; i--)
            heapify(arr,n,i);
    }

    public void sortHeap(int arr[], int n){
        //sorting the array
        for(int i=n-1;i>=0;i--){
          swap(arr,0,i);
          heapify(arr,i,0);
        }
    }

    private void heapify(int arr[],int n,int i){
      int largest = i;
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      if(left<n && arr[left] > arr[largest])
          largest = left;
      if(right<n && arr[right] > arr[largest])
          largest = right;
      if(largest!=i){
        swap(arr, i, largest);
        heapify(arr, n, largest);
      }
    }

    private void swap(int arr[],int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    public static void main(String[] args) {
      int[] arr = {5,2,31,3,4,5,6,5,1};
      HeapSort hs = new HeapSort();
      hs.buildHeap(arr);
      hs.sortHeap(arr, arr.length);
      System.out.println("Sorted array is");
      System.out.println(Arrays.toString(arr));
    }
  }
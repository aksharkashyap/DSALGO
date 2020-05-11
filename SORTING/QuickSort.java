package SORTING;

/*
public class QuickSort {

    static void swap(int i, int j, int arr[]){
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {// If current element is smaller than the pivot
                i++;
               swap(i, j, arr);
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        swap(i+1, high, arr);
        return i + 1;
    }

    static void quick_sort(int arr[], int low, int high) {
        while (low < high) {
            int pivot_index = partition(arr, low, high);
        quick_sort(arr, low, pivot_index-1);
        low = pivot_index+1; // tail recursion eliminated- improves space (logn)
      }

    }

    public static void main(String[] args) {
        int arr[] = {11,25,17,10,9};
        quick_sort(arr,0,arr.length-1);
        for(int i: arr)
            System.out.print(i+" ");
    }
}


*/

// Java program to illustrate Randomised Quick Sort 
import java.util.*; 

class RandomisedQuickSort 
{ 
	public static int N = 5; 
	public static int[] arr = new int[N]; 
	
	// This Function helps in calculating random 
	// numbers between low(inclusive) and high(inclusive) 
	int random(int low,int high) 
    { 
      
        Random rand= new Random(); 
        int pivot = rand.nextInt(high-low) + low; 
        return pivot;
    } 
	
	/* This function takes last element as pivot, 
	places the pivot element at its correct 
	position in sorted array, and places all 
	smaller (smaller than pivot) to left of 
	pivot and all greater elements to right 
	of pivot */
	
	int partition(int arr[], int low, int high) 
	{ 
		// pivot is choosen randomly 
		int pivot = random(low, high); 
	

		int i = (low-1); // index of smaller element 
		for (int j = low; j < high; j++) 
		{ 
			// If current element is smaller than or 
			// equal to pivot 
			if (arr[j] <= pivot) 
			{ 
				i++; 

				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 


	/* The main function that implements QuickSort() 
	arr[] --> Array to be sorted, 
	low --> Starting index, 
	high --> Ending index */
	void sort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is 
			now at right place */
			int pi = partition(arr, low, high); 

			// Recursively sort elements before 
			// partition and after partition 
			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		int arr[] = {10, 7, 8, 9, 1, 5}; 
		int n = arr.length; 

		RandomisedQuickSort ob = new RandomisedQuickSort(); 
		ob.sort(arr, 0, n-1); 

		System.out.println("sorted array"); 
		printArray(arr); 
	} 
} 

// This code is contributed by Ritika Gupta. 

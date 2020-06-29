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


class Q_Test{

    static void swap(int arr[],int i, int j){
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
    static int getPivot(int arr[], int l, int r){
        int pos=l;
        int pivot = r;

        for(int i=l;i<pivot;i++)//find pivot pos
            if(arr[i]<=arr[pivot]) swap(arr,pos++,i);
        
        swap(arr,pivot,pos); // place the pivot at correct position
        return pos;
    }

    static void sort(int arr[],int l, int r){
        if(l>=r) return;
        int mid = getPivot(arr,l,r);
        sort(arr,l,mid-1);
        sort(arr,mid+1,r);
    }

    public static void main(String[] args) {
        int arr[] = {2,3,49,13,12,5,3,5,55,2,3,5,7,2,11,5};
        sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
	}
}
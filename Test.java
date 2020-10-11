

//[10,12,14,15]

class PriorityQueue{
	int N;
	int[] HEAP;
	PriorityQueue(int n){
		N = n;
		HEAP = new int[n];
	}
	void build_heap(int[]arr){

	}

	void heapify(int i){
		int left = 2 * i;
		int right = 2 * i + 1;
	}

	public static void main(String[] args){
		
		int[] arr = {10,12,14,15};
		int n = arr.length;
		PriorityQueue pq = new PriorityQueue(n);
		pq.build_heap(arr);
	}
}

/*
[1,2,3,4,5]

	 1
   2   3

*/
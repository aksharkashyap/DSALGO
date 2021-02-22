package SegmentTree;
////segment tree size -> 4*n aprox
//tutorial : https://www.youtube.com/watch?v=rwXVCELcrqU&t=458s
//range update in O(logn)

class LazySegmentTree2 
{ 
	final int MAX = 1000;	 // Max tree size 
	int segT[] = new int[MAX]; // To store segment tree 
	int lazy[] = new int[MAX]; // To store pending updates
	
	void updateRangeUtil(int idx, int l, int r, int left, int right, int diff){ 
		
		if(lazy[idx] != 0){ //lazy pending update
			segT[idx] += (r - l + 1) * lazy[idx]; 
            if (l != r){//if not leaf then procede (because if lead(l==r) we cant fo further)
				lazy[idx * 2 + 1] += lazy[idx];  //notify the left children for future lazy updates
				lazy[idx * 2 + 2] += lazy[idx];  //notify the right children for future lazy updates
			}
			lazy[idx] = 0; //mark updated
        } 
        
        if (l > r || l > right || r < left) return; //complete non-overlap (out of range)
        
		if (l >= left && r <= right){  //complete overlap
			segT[idx] += (r - l + 1) * diff; 
			if (l != r){
				lazy[idx * 2 + 1] += diff; 
				lazy[idx * 2 + 2] += diff; 
			} 
			return; 
        }
        //partial overlap
		int mid = l + (r-l)/2;
		updateRangeUtil(idx * 2 + 1, l, mid, left, right, diff); 
		updateRangeUtil(idx * 2 + 2, mid + 1, r, left, right, diff); 
		segT[idx] = segT[idx * 2 + 1] + segT[idx * 2 + 2]; 
	} 

	void updateRange(int n, int left, int right, int diff){
        //segmentTree range [l,r]
        int l = 0, r = n-1;
        //update range [left,right]
        int idx = 0; //start index
		updateRangeUtil(idx, l, r, left, right, diff); 
	} 

	int getSumUtil(int l, int r, int left, int right, int idx){ 
		if (lazy[idx] != 0) { //do the same pending lazy updates if present as we did at the time of updation
			segT[idx] += (r - l + 1) * lazy[idx]; 
			if (l != r){ 
				lazy[idx * 2 + 1] += lazy[idx]; 
				lazy[idx * 2 + 2] += lazy[idx]; 
			}
			lazy[idx] = 0; 
		} 
		if (l > r || l > right || r < left) return 0; //out of bound
		if (l >= left && r <= right) return segT[idx]; //complete overlap
        int mid = (l + r) / 2;
        int left_sum = getSumUtil(l, mid, left, right, 2 * idx + 1);
        int right_sum = getSumUtil(mid + 1, r, left, right, 2 * idx + 2);
		return left_sum + right_sum; 
	} 

	int getSum(int n, int left, int right){ 
		if (left < 0 || right >= n || left > right) { 
			System.out.println("Invalid Input"); 
			return -1; 
		} 
		return getSumUtil(0, n - 1, left, right, 0); 
	} 

	void buildSegmentTreeUtil(int arr[], int left, int right, int idx){ 
		if (left > right) return;
		if (left == right){ 
			segT[idx] = arr[left]; 
			return; 
		} 
		int mid = (left + right) / 2; 
		buildSegmentTreeUtil(arr, left, mid, idx * 2 + 1); 
		buildSegmentTreeUtil(arr, mid + 1, right, idx * 2 + 2); 
		segT[idx] = segT[idx * 2 + 1] + segT[idx * 2 + 2]; 
	} 

	void buildSegmentTree(int arr[], int n){ 
		buildSegmentTreeUtil(arr, 0, n - 1, 0); 
	} 


	public static void main(String args[]){ 
		int arr[] = {1, 3, 5, 7, 9, 11}; 
		int n = arr.length; 
		LazySegmentTree2 tree = new LazySegmentTree2(); 
		tree.buildSegmentTree(arr, n); 
		System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3)); 
		tree.updateRange(n, 1, 5, 10); 
		System.out.println("Updated sum of values in given range = " +tree.getSum(n, 1, 3)); 
	} 
} 


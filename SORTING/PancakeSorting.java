package SORTING;
import java.util.ArrayList;
//max 2*n filps
//start with greatest number and fix it to its correct position by 2 filps (find and flip o,num to take it in front then flip 0 to n to take it to the last)
class PancakeSorting {
	public ArrayList<Integer> pancakeSort(int[] A) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int n=A.length;n>0;n--){
			int i=0;
			while(i<n&& A[i]!=n) i++;
			flip(A,i);
			list.add(i+1);
			flip(A,n-1);
			list.add(n);
		}
		return list;
	}
	
	void flip(int[] A,int n){
		int i=0;
		while(i<n) swap(A,i++,n--);
	}
	
	void swap(int[]A,int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void main(String[] args){
		PancakeSorting obj = new PancakeSorting();
		int[]a = {1,2,3,4};
		ArrayList<Integer> v = obj.pancakeSort(a);
		//System.out.print(Arrays.toString(a));
		System.out.print(v);
	}
}


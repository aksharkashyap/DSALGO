import java.util.*;

class Test {
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> list = new ArrayList<>();
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
		Test obj = new Test();
		int[]a = {1,2,3,4};
		List<Integer> v = obj.pancakeSort(a);
		//System.out.print(Arrays.toString(a));
		System.out.print(v);
	}
}


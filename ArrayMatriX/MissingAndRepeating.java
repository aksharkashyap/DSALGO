package ArrayMatriX;

class MissingAndRepeating {
    //find missing and repeating number in an array of size [1 to n]
	static void repeatingMissing(int arr[], int n){
		int a=0,b=0;
		for(int i=0;i<n;i++){	//find repeating number
			int idx = Math.abs(arr[i])-1;
			if(arr[idx] < 0) a = Math.abs(arr[i]);	
			else arr[idx] = - arr[idx];
		}
		for(int i=0;i<n;i++){	//missing number
			if(arr[i]>0){
				b = i+1;
				break;
			}
		}
		System.out.println(a+" "+b);
	}

	public static void main(String[] args){
		repeatingMissing(new int[]{1,2,3,5,5},5);
	}
}

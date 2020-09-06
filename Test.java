import java.util.*;

class Test {


	static void repeatingMissing(int arr[], int n){
		Arrays.sort(arr);
		for(int i=1;i<n;i++)
		{
			if(arr[i-1] == arr[i]){
				System.out.print(arr[i]+1 + " " + arr[i]);
				break;
			}
		}
	}

	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		repeatingMissing(new int[]{4,2,5,3,3},5);

	}
}


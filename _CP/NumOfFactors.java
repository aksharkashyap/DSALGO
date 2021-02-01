package _CP;

/*O(n * log(max(number))), 
where n is total number of elements in the array and max(number) represents the maximum number in the array.
*/

class NumOfFactors { 

	static int MAX = 1000001; 
	static int factor[] = new int[MAX]; 

	static void generatePrimeFactors(){ 
		factor[1] = 1;
		for (int i = 2; i < MAX; i++) factor[i] = i; 
		for (int i = 4; i < MAX; i += 2) factor[i] = 2; 
		for (int i = 3; i * i < MAX; i++) { 
			if (factor[i] == i) { 
				for (int j = i * i; j < MAX; j += i) { 
					if (factor[j] == j) factor[j] = i; 
				} 
			} 
		} 
	} 
	static int calculateNoOFactors(int n){ 
		if (n == 1) return 1; 
		int ans = 1;
		int dup = factor[n]; 
		int c = 1;
		int j = n / factor[n]; 
		while (j != 1) { 
			if (factor[j] == dup) c += 1; 
			else { 
				dup = factor[j]; 
				ans = ans * (c + 1); 
				c = 1; 
			}
			j = j / factor[j]; 
		} 
		ans = ans * (c + 1);
		return ans; 
	} 
	public static void main(String[] args){
        generatePrimeFactors(); 
        int n = 4;
        calculateNoOFactors(n);
	} 
} 

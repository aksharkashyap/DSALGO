package _CP.PrimalityTest;

//O(logn)
class FermetsPrimalityTest {
	
	/* Iterative Function to calculate (a^n)%p in O(logy) */
	static int power(int a,int n, int p){
		int res = 1;
		a = a % p; 
		while (n > 0){
			if ((n & 1) == 1) res = (res * a) % p;
			n = n >> 1;
			a = (a * a) % p;
		}
		return res;
    }
    
	static boolean isPrime(int n, int itr){ //probabilistic
	    if (n <= 1 || n == 4) return false;
	    if (n <= 3) return true;
	    while (itr > 0){  
		    int a = 2 + (int)(Math.random() % (n - 4)); 
		    if(power(a, n - 1, n) != 1) return false;
		    itr--;
	    }
		return true;
	}

	public static void main(String args[]){
		int itr = 5; //more number of iteration will give more accurate 
		System.out.println(isPrime(131, itr));		
	}
}

/*  https://www.geeksforgeeks.org/primality-test-set-2-fermet-method/

    // high probability Higher value of k increases probability of correct result.    
*/
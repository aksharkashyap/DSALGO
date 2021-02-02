package _CP.PrimalityTest;

//O(logn) - Primality Test
//100% accuracy for 32bit and 64bit integers

class Miller_Rabin_Deterministic {

    static int power(int x, int y, int p) { 
		int res = 1; 
		x = x % p; 
		while (y > 0){ 
			if ((y & 1) == 1) res = (res * x) % p; 
			y = y >> 1;
			x = (x * x) % p; 
		} 
		return res; 
	} 

    static boolean check_composite(int n, int a, int d, int s) {
        int x = power(a, d, n);
        if (x == 1 || x == n - 1) return false;
        for (int r = 1; r < s; r++) {
            x = (x * x) % n;
            if (x == n - 1) return false;
        }
        return true;
    };

    static boolean isPrime(int n) { // returns true if n is prime, else returns false.
        if (n < 2) return false;
        int r = 0;
        int d = n - 1;
        while ((d & 1) == 0) {
            d >>= 1;
            r++;
        }
        for (int a : new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {
            if (n == a) return true;
            if (check_composite(n, a, d, r)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(1234432));
    }
}

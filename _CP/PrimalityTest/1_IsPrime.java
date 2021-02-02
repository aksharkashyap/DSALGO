package _CP.PrimalityTest;

class IsPrime {
    //O(sqrt(n))
    static boolean isPrime(long n){ 
        if (n <= 1l) return false; 
        if (n <= 3l) return true; 
        // This is checked so that we can skip  middle five numbers in below loop 
        if (n % 2l == 0l || n % 3l == 0l) return false; 
        for (long i = 5l; i * i <= n; i = i + 6l){
            if (n % i == 0l || n % (i + 2l) == 0l) return false; 
        }
        return true; 
    }  
}

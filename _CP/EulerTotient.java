package _CP;

/*Euler’s Totient function Φ (n) for an input n is the count of numbers in {1, 2, 3, …, n} 
that are relatively prime to n, i.e., the numbers whose GCD (Greatest Common Divisor) with n is 1. */

//works well for single or very less queries
//time - O(sqrt(n))
class EulerTotient1 {

    static int phi(int n){
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0)
                    n /= i;
                result -= result / i;
            }
        }
        if (n > 1) result -= result / n;
        return result;
    }
}


//For multiple queries -> O(1) phi
//preprocessing O(nlog(logn))

class EulerTotient2{ 
    static int MAX_N = 1000000;
    static long phi[] = new long[MAX_N+1]; 
    static void phi_precompute(){
        for (int i = 1; i <= MAX_N; i++) phi[i] = i;
        for (int p = 2; p <= MAX_N; p++) { 
            if (phi[p] == p) { 
                phi[p] = p - 1; 
                for (int i = 2 * p; i <= MAX_N; i += p){ 
                    phi[i] = (phi[i] / p) * (p - 1); 
                } 
            } 
        } 
    }

    public static void main(String[] args){
        phi_precompute(); //upto 10^6
        System.out.println(phi[4]);
    }
} 



/*Interesting facts

1) For a prime number p, Φ(p) is p-1. For example Φ(5) is 4, Φ(7) is 6 and Φ(13) is 12. This is obvious, gcd of all numbers from 1 to p-1 will be 1 because p is a prime.
2) For two numbers a and b, if gcd(a, b) is 1, then Φ(ab) = Φ(a) * Φ(b). For example Φ(5) is 4 and Φ(6) is 2, so Φ(30) must be 8 as 5 and 6 are relatively prime. 
3) For any two prime numbers p and q, Φ(pq) = (p-1)*(q-1). This property is used in RSA algorithm. 
4) If p is a prime number, then Φ(pk) = pk – pk-1. This can be proved using Euler’s product formula.
5) Sum of values of totient functions of all divisors of n is equal to n.
6) Number of generators of a finite cyclic group under modulo n addition is Φ(n).
*/
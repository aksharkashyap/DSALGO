package _CP.Sieve;

import java.util.Arrays;

/**
 * Print the primes in the given range as array size cant be greater than around
 * 10^6 , if range is greater than this we cant use simple sieve so we need to
 * use segmented sieve given the conditon that range (L-R+1) always lies in <=
 * 10^6
 * 
 * calculate primes till root(R) and letter we will make false all of their
 * multiples in the given range why root(R), because if a number is non prime
 * then it will have one of its root x <= root(n) and another y >= root(n)
 */

class SS{
    static int primes[];
    static void simpleSeive(int LIMIT){//calculate primes till root(R)
        boolean[] bool_prime = new boolean[LIMIT+1]; int size=0;
        Arrays.fill(bool_prime,true);
        for(int i=2; i<=LIMIT;i++){
            if(!bool_prime[i]) continue;
            for(int j = i*i; j<=LIMIT; j+=i) bool_prime[j] = false;
            size++;
        }
        //store the prime numbers in integer form
        primes = new int[size];
        int k=0; primes[k++] = 2;
        for(int i=3;i<bool_prime.length;i+=2) if(bool_prime[i]) primes[k++]=i;

    }

    static void calculate(int L, int R){
        int n = R-L+1;
        boolean[] primeInRange = new boolean[n+1];
    
        for(int i=0;i<primes.length;i++){
            int base = (L / primes[i]) * primes[i];
            if(base < L || base == primes[i]) base += primes[i];
            for(int j=base;j<=R;j+=primes[i]) 
                primeInRange[j-L] = true; // true indicates these nums are not prime
        }
        //print the primes in the given range
        for(int i=L;i<=R;i++)
            if(!primeInRange[i-L]) System.out.print(i+" ");
    }

    public static void main(String[] args) {
        int L = 12, R = 50;
        simpleSeive((int)Math.sqrt(R));
        calculate(L,R);
    }
}
package _CP;

import java.util.*;
class PrimeFactorization{

    static boolean[] isPrime; // to hold all possible primes upto given value
 
    static void fill_prime(int val){
       isPrime = new boolean[val+1];
       Arrays.fill(isPrime,true); // initialize with true 
       isPrime[0] = isPrime[1] = false;
       for(int i=2;i<=Math.sqrt(val);i++){
          if(!isPrime[i]) continue;
          for(int j=i; i*j<=val; j++) isPrime[i*j] = false; 
       }
    }
 
    static void pf(int n, int start, List<Integer> primes){
       for(int p = start; p<primes.size();p++){
             int prime = primes.get(p);
             if(n % prime == 0){
                System.out.print(prime + " ");
                pf(n/prime,p, primes);
                return;
             }
       }
    }
 
     public static void main(String[] args) {
       int num = 353463; // write your number here
       fill_prime(num);  //pre compute all prime number upto given num
       List<Integer> primes = new ArrayList<>(); //to hold all prime numbers upto given value
       for(int i=2;i<isPrime.length;i++) if(isPrime[i]) primes.add(i);
       pf(num,0,primes);
     }
 }
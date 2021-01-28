package _CP;

import java.io.*; 
import java.lang.Math; 
  
class PF3{ 
    // A function to print all prime factors of a given number n 
    public static void primeFactors(int n) 
    { 
        // Print the number of 2s that divide n 
        while (n%2==0){ 
            System.out.print(2 + " "); 
            n /= 2; 
        } 
        // n must be odd at this point.  So we can skip one element (Note i = i +2) 
        for (int i = 3; i <= Math.sqrt(n); i+= 2){ 
            // While i divides n, print i and divide n 
            while (n%i == 0){ 
                System.out.print(i + " "); 
                n /= i; 
            } 
        } 
        // This condition is to handle the case whien n is a prime number greater than 2 
        if (n > 2) System.out.print(n); 
    } 
  
    public static void main (String[] args){ 
        int n = 315; 
        primeFactors(n); 
    } 
} 

/**
 * How does this work?
The steps 1 and 2 take care of composite numbers and step 3 takes care of prime numbers. To prove that the complete algorithm works, we need to prove that steps 1 and 2 actually take care of composite numbers. This is clear that step 1 takes care of even numbers. And after step 1, all remaining prime factor must be odd (difference of two prime factors must be at least 2), this explains why i is incremented by 2.
Now the main part is, the loop runs till square root of n not till n. To prove that this optimization works, let us consider the following property of composite numbers.
Every composite number has at least one prime factor less than or equal to square root of itself.
This property can be proved using counter statement. Let a and b be two factors of n such that a*b = n. If both are greater than √n, then a.b > √n, * √n, which contradicts the expression “a * b = n”.

In step 2 of the above algorithm, we run a loop and do following in loop
a) Find the least prime factor i (must be less than √n,)
b) Remove all occurrences i from n by repeatedly dividing n by i.
c) Repeat steps a and b for divided n and i = i + 2. The steps a and b are repeated till n becomes either 1 or a prime number.
 */


 //https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
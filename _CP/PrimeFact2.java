package _CP;

import java.util.*;
class PrimeFactorization2{

    static int getFactor(int num, int p){
        if(num % p != 0) return num;
        System.out.print(p + " "); 
        return getFactor(num/p, p);
    }

    static int go(int num, int start, int end){
        if(start > end) return num;
        num = getFactor(num,start);
        return go(num,start+2,end);
    }

    public static void main(String[] args){
        int n = 30;
        getFactor(n,2); 
        n = go(n,3,(int)Math.sqrt(n));
        if (n > 2) System.out.print(n); 
    }  
}
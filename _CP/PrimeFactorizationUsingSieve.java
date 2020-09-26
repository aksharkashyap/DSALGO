package _CP;
import java.util.ArrayList;
import java.util.List;

//Prime Factorization using Sieve O(log n) for multiple queries
class PfSieve{

    int[]spf = new int[100001];

     //sieve of smallest prime factors
    //time -> nloglogn
    void sieve_spf(){
        int n = spf.length;
        for(int i=1;i<n;i++) spf[i] = i; // initialize with own number
        
        for(int i=4; i<n; i+=2) spf[i] = 2;  // handle even numbers (they will have 2 as the prime factor)

        for(int i=3; i*i<n; i+=2){  //Note-> if n is a composite number then there exist atleast 1 prime divisor of N below sqrt(n)
            if(spf[i]==i){  //check if i is a prime
                for(int j=i*i; j<n; j=j+i){ // put i as the prime factor for all the factors of i
                    if(spf[j] == j) spf[j] = i;
                }
            }
        }
    }
    //O(logn)
    List<Integer> getFactorization(int n){
        List<Integer> list = new ArrayList<>();
        while(n != 1){
            list.add(spf[n]);
            n = n / spf[n];
        }
        return list;
    }

    public static void main(String[] args) {
        PfSieve p = new PfSieve();
        int n = 12246;
        p.sieve_spf();
        List<Integer> list = p.getFactorization(n);
        System.out.print(list);
    }
}
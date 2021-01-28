package _CP;
import java.util.Arrays;
//n(log(logn))
class SieveOfErato{
    static int n=10;
    static boolean prime[];

    static void sieve(){
        prime = new boolean[n+1];
        Arrays.fill(prime,true);

        for(int i=2; i<=Math.sqrt(n);i++){
            if(prime[i]){
                for(int j = i*i; j<n; j+=i)
                    prime[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        sieve();
        for(int i=2;i<n;i++)
        if(prime[i]) System.out.print(i+" ");
    }
}
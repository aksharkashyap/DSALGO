package _CP.Sieve;
import java.util.Arrays;
//n(log(logn))
class SieveOfErato{
    static int SN=10;
    static boolean prime[];

    static void sieve(){
        prime = new boolean[SN+1];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;
        for(int i=2; i<=Math.sqrt(SN);i++){
            if(prime[i]){
                for(int j = i*i; j<SN; j+=i)
                    prime[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        sieve();
        for(int i=2;i<SN;i++)
        if(prime[i]) System.out.print(i+" ");
    }
}
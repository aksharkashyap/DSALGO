package _CP;
import java.util.Arrays;
//n(log(logn))
class SieveOfErato{

    static void solve(int n){
        boolean prime[] = new boolean[n+1];
        Arrays.fill(prime,true);

        for(int i=2; i<Math.sqrt(n);i++){
            if(prime[i]){
                for(int j = i*i; j<n; j+=i)
                    prime[j] = false;
            }
        }
        
        for(int i=2;i<n;i++)
            if(prime[i]) System.out.print(i+" ");
    }

    public static void main(String[] args) {
        
        solve(10);
    }
}
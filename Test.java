import java.util.*;

class Test{

    int getFactor(int num, int p){
        if(num % p != 0) return num;
        System.out.print(p + " "); 
        return getFactor(num/p, p);
    }

    int go(int num, int start, int end){
        if(start > end) return;
        num = getFactor(num,start);
        return go(num,start+2,end);
    }

    public static void primeFactors(int n){ 
        getFactor(num,2); 
        int n = go(n,3,Math.sqrt(n));
        if (n > 2) System.out.print(n); 
    } 

    
}

/**
 * iterative inorder,postoder,pre
 */
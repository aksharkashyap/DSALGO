package _CP.Pow;

class PowModular {
    /* Iterative Function to calculate (x^y)%p in O(log y) */
    static int pow(int x, int y, int p){
        int res = 1;     
        x = x % p;
        if (x == 0) return 0;
        while (y > 0){
            if((y & 1)==1) res = (res * x) % p;
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return res;
    }

    //p is a prime number -given 
}

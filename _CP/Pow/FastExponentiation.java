package _CP.Pow;

class ModularFastExponentiation{
    //complexity : logn
    //take mod at each step to avoid overflow // static int MOD = (int) 1e7;
    static double pow(double x, int n) {
        
        if(n==0) return 1;
        if(n==1) return x;
        if(n==-1) return 1/x; //to handle negative 
        
        double partialResult = pow(x, n/2);
        
        if (n % 2 == 0) return partialResult * partialResult;
        else if (n > 0) return partialResult * partialResult * x;
        else return partialResult * partialResult / x; //to handle negative n
    }    
    public static void main(String[] args) {
        double x = 5d;
        int n = 3;
        System.out.print(pow(x,n));
    }
}
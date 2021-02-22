package _CP;
//euclid method
//O(log(min(a,b)))

class GCD_LCM_Two{
    
    static int gcd(int a, int b){

        return (b == 0) ? a : gcd(b,a%b);
    }

    static int lcm(int a, int b){
        return (a*b)/gcd(a, b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(12,24));
        System.out.println(lcm(12,24));
    }
}
package BitManipulation;

class SumUsingBitwise {
    int getSum(int a, int b) {
        int carry=0;
        while(b!=0){
            carry = a & b; // taking carry
            a = a ^ b;  // actual addition 
            b = carry << 1; // shift carry so that we can apply it on next iteration
        }
        return a;
    }
}
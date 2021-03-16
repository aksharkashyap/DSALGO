package _CP;

/*odd or even number of factors
    if(number is a perfect square then it has odd number of factors)
*/

class OddorEvenFactors {
    
    boolean hasOddFactors(int n){
        int sqrt = (int) Math.sqrt(n);
        if((sqrt*sqrt) == n) return true;
        return false;
    }
}

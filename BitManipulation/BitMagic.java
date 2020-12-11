package BitManipulation;
//bitmasking stuff
//note that if you are performing any operation on int/long etc then it will be performed for all the 32/64 bits in java
/**
 * note that some programming languages uses different bit representations like 4/16/32 etc
 * so output may vary for different languages
 */
public class BitMagic {

    // check if a number is even or odd
	static boolean isEven(int n) {  
		// n&1 is 1, then odd, else even  
		return ((n & 1)!=1);  
	 } 
    
    //count set bits
    static void count_set_bits(int x){
        int count=0;
        while(x>0){
            x = x & (x-1);
            count++;
        }
        System.out.println(count);
    }

    //find log base 2 of a 32 bit integer
    static void log2(int x){
        int count=0;
        while(x > 0){
            x = x >> 1;
            count++;
        }
        System.out.println(count);
    }

    //is power of 2
    /**All the power of 2 have only single bit set e.g. 16 (00010000). If we minus 1 from this, 
    * all the bits from LSB to set bit get toggled, i.e., 16-1 = 15 (00001111). Now if we AND x with (x-1) 
    * and the result is 0 then we can say that x is power of 2 otherwise not. 
    We have to take extra care when x = 0. */
    static boolean isPowerof2(int x){
        int e = x & (x-1);
        return e==0 ? true : false;
    }

    // Lower to upper case
    static char toUpperCase(char ch){
        ch = (char) (ch & '_'); //ch & ~32
        return ch;
    }

    //upper to lower
    static char toLowerCase(char ch){
        ch = (char) (ch | ' '); //ch | 32
        return ch;
    }

    //multiply by 2
    static int multBy2(int x){
        return x << 1;
    }
    //div by 2
    static int divBy2(int x){
            return x >> 1;
    }
    
    //strip(remove) last set bit
    static int strip_last_set_bit(int x){
        return x & (x-1);
    }

    //getting lowest set bit of a number
    static int get_lowest_set_bit(int x){
        return x & (-x); // here -x = 2's complement of x
    }

    //checking if bit at kth position is set or unset:
    static void isKthBitSet(int n, int k){ 
        if ((n & (1 << k)) > 0) 
            System.out.print("SET"); 
        else
            System.out.print("NOT SET"); 
    }

    // Toggling a bit at nth position :
    static void toggle(int num,int pos){ 
        num = num ^ (1 << pos); 
    }

    //unset bit at nth position
    static void clear_bit(int num,int pos){ 
        num = num & (~(1 << pos)); // ~ indicates toggle
    }   
    //set a bit at nth position  
    static void set_bit(int num,int pos){ 
        num = num | (1 << pos);
    }

    //get last bit of a number
    static int last_bit(int num){
        return num & 1;
    }
    
    //getting most significant bit and its position(leftmost set bit)
    static void msb(int n){
       //msb position 
       int k = (int)(Math.log(n) / Math.log(2));
       //the value of the number with set bit at k-th position 
       int value_at_kth_pos = (int)(Math.pow(2, k)); 
    }

    public static void main(String[] args) {
        
       count_set_bits(3);
       System.out.println(isPowerof2(8));
       System.out.println(toUpperCase('a'));
       System.out.println(toLowerCase('A'));
       System.out.println(multBy2(6));
       System.out.println(divBy2(6));
       System.out.println(get_lowest_set_bit(6));
    }

    
}
package _CP;

public class nextPowerof2 {
    //o(logn)
    static int nextPowerOf2(int n) 
	{ 
		n--; 
		n |= n >> 1; 
		n |= n >> 2; 
		n |= n >> 4; 
		n |= n >> 8; 
		n |= n >> 16; 
		n++; 
		
		return n; 
	}
}

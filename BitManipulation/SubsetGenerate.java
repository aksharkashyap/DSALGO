package BitManipulation;
//complexity O(n * 2^n)
class SubsetGenerate{
    
    static void power_set(int[]set, int n){ 
        
        int pow_set_size =  (int) Math.pow(2, n); 
        /*Run from counter 000..0 to 111..1*/
        for(int counter = 0; counter < pow_set_size; counter++){ 
            for(int j = 0; j < n; j++){ 
                /* Check if jth bit in the counter is set*/
                if((counter & (1 << j)) > 0) System.out.print(set[j]); 
            } 
            System.out.println(); 
        } 
    } 

    public static void main(String[] args) {
        int[]arr = {1,2,3};
        int n = arr.length;
        power_set(arr, n);
    }
}

/*
[1,2,3]
for each number we have 2 choice(include/exlcude) so total 2^n sets will be made
each set bit will indicate that we must include that corrosponding number
 0 0 0
 0 0 1
 0 1 0 
 0 1 1
 1 0 0
 1 0 1
 1 1 0
 1 1 1

*/

//for backtracking verion see -> Backtracking folder
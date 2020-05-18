package Greedy;

class EgyptianFraction{

    static void print_fraction(int nr, int dr){

        if(nr ==0 || dr == 0) return; 

        //not a fraction
        if(nr%dr == 0){
            System.out.print(nr/dr);
            return;
        }
        
        if(dr%nr == 0){
            System.out.print("1/" + dr / nr); 
            return;
        }

        if (nr > dr) { 
            System.out.print(nr / dr + " + "); 
            print_fraction(nr % dr, dr); 
            return; 
        } 

        int n = dr / nr + 1; 
        System.out.print("1/" + n + " + "); 
  
        // Recur for remaining part  
        print_fraction(nr * n - dr, dr * n); 
    }

    public static void main(String[] args) {
        int nr = 6, dr = 14;
        print_fraction(nr, dr);
    }
}
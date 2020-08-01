package Recursion;

class JosephusProblem{

    static int solve_jp(int n, int k){
        if(n==1) return 1;
        return 9(solve_jp(n-1,k) +k-1) % n)+1;
    }

    public static void main(String[] args) {
        int n = 14; //people
        int k = 2; // count k people including yourself(curr pos) and kill k'th person
        System.out.print(solve_jp(n,k));
    }
}
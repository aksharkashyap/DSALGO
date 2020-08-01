import java.util.*;

class Test{
    static int solve_jp(int n, int k){
        if(n==1) return 1;
        int person_going_to_be_killed = ((solve_jp(n-1,k) +k-1) % n);
        System.out.print(person_going_to_be_killed +" ");
        int passTheSwordTonextAlivePerson =  person_going_to_be_killed + 1;
        return passTheSwordTonextAlivePerson;
    }

    public static void main(String[] args) {
        int n = 5; //people
        int k = 2; // count k people including yourself(curr pos) and kill k'th person
        System.out.print(solve_jp(n,k));
    }
}

/**
 * iterative inorder,postoder,pre
 */
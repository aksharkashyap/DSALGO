import java.io.*;
import java.util.*;

 class Test {

    static boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
    
    static boolean halindrome(String s){
        if(s.length()<2) return false;
        boolean c1 = isPalindrome(s);
        int mid = (s.length()-1)/2;
        boolean c2 = halindrome(s.substring(0,mid));
        boolean c3 = halindrome(s.substring(mid,s.length()));
        //odd
        boolean d2 = halindrome(s.substring(0,mid));
        boolean d3 = halindrome(s.substring(mid+1,s.length()));

        if(s.length()%2 == 0) return c1 || c2 || c3;
        return c1 || d2 || d3;
    }

    static int solve(int n, String[] str){
        int count=0;
        for(int i=0;i<n;i++){
            if(halindrome(str[i])) count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = {"Hello","Hi"};
        System.out.println(solve(n,arr));
        
    }
}
/**
 * iterative inorder,postoder,pre
 */

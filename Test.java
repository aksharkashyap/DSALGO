import java.io.*;
import java.util.*;

 class Test {
    
    static int solve(int h, int p){
        while(p>0 && h>0){
            h = h-p;
            p = (int) Math.ceil(p/2);
        }
        return h>0 ? 0 : 1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int h = sc.nextInt();
            int p = sc.nextInt();
            System.out.println(solve(h,p));
        }
    }
}
/**
 * iterative inorder,postoder,pre
 */

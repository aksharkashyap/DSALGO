import java.util.*;

class Test{
    public static void main(String[] args) {
        int b[] = {44,48,77,88};
        int a[] = {1,32,46,47,78,80};
        int alen = a.length;
        int blen = b.length;
        merge(a,b,alen,blen-1);
        System.out.print(Arrays.toString(a) + " " + Arrays.toString(b));
    }
}

/**
 * iterative inorder,postoder,pre
 */
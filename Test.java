import java.util.*;

class Test{
    public static void main(String[] args) {
       StringBuilder sb = new StringBuilder("  akshar k umar kashyap");
        int n = sb.length(), right = 0;
        for(int left=0;left<n;){
            while(sb.charAt(left)==' ') left++;
            while(sb.charAt(right)==' ') right++;

            while(right<n && sb.charAt(right) != ' '){
                right++;
            }
            reverse(sb,left,right-1);
            left = ++right;
        }
        System.out.println(sb);
       reverse(sb, 0, n-1);
       System.out.print(sb);
    }

    static void reverse(StringBuilder sb, int left, int right){
        while(left < right){
            swap(sb, left, right);
            left++; right--;
        }
    }
    static void swap(StringBuilder sb, int i, int j){
        char ch = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, ch);
    }
}
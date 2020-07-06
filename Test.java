import java.util.*;
class Test{
    static void computeLPS(String pat, int m, int[] lps){
        int len=0;
        int i =1;
        lps[0]=0;
        while(i<m){
            if(pat.charAt(len)==pat.charAt(i)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0) len = lps[len-1];
                else{
                    lps[i] = len;
                    i++;
                }
                
            }
        }
    }
    static void kmp(String pat, String txt){
        int m = pat.length();
        int n = txt.length();

        int lps[] = new int[m];
        int j=0; //index for pat
        int i=0; //index for txt
        computeLPS(pat,m,lps);

        while(i<n){
            if(pat.charAt(i) == txt.charAt(j)){
                i++; j++;
            }
            if(j==m){
                System.out.println("found pat at" + (i-j));
                j = lps[j-1];
            }
            else if(i<n && pat.charAt(j)!=txt.charAt(i)){
                if(j!=0) j = lps[j-1];
                else i = i+1;
            }

        }

    }


    public static void main(String[] args) {
       
    }
}

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * https://leetcode.com/problems/merge-intervals/
 */
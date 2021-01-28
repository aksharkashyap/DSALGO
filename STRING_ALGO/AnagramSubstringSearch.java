//o(n)
/**Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) 
 * that prints all occurrences of pat[] and its permutations (or anagrams) in txt[]. 
 * You may assume that n > m.
Expected time complexity is O(n) */

package STRING_ALGO;

public class AnagramSubstringSearch {
    
    static final int MAX = 256;

    static boolean compare(char arr1[],char arr2[]){
        for(int i=0;i<MAX;i++)
            if(arr1[i] !=arr2[i]) return false;
        return true;
    }

    static void anagram_search(String pat, String txt){
        int M = pat.length();
        int N = txt.length();

        char[]countP = new char[MAX];
        char[]countT = new char[MAX];

        for(int i=0;i<M;i++){
            countP[pat.charAt(i)]++;
            countT[txt.charAt(i)]++; //1st window
        }

        for(int i=M;i<N;i++){
                if(compare(countP, countT)) System.out.println("Pattern found at "+ (i-M));
                countT[txt.charAt(i)]++; //slide the window
                countT[txt.charAt(i-M)]--;
        }
        if(compare(countP, countT)) // check the last window
        System.out.println("Pattern found at "+ (N-M));
    }

    public static void main(String[] args) {
        String txt = "BACDGABCDA"; 
        String pat = "ABCD"; 
        anagram_search(pat, txt); 
    }
}
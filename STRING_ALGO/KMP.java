package STRING_ALGO;

class KMP {
    
    void kmp_search(String txt, String pat){
        int m = txt.length();
        int n = pat.length();
        int[] lps = new int[n]; //longest suffix which is proper prefix (to hold the index where should we direct the j pointer when mismatch occurs)
        computeLPS(pat, lps,n);

        int i=0,j=0;
        while(i<m){
            if(txt.charAt(i) == pat.charAt(j)){
                i++; j++;
            }
            if(j==n){
                System.out.println("found pat at index " + (i-j));
                j = lps[j-1]; //point j to the next valid start 
            }
            else if(i<m &&txt.charAt(i) != pat.charAt(j)){
                if(j!=0) j = lps[j-1];
                else i = i +1;
            }
        }
    }

    void computeLPS(String pat, int[]lps, int n){
        lps[0] = 0;
        int i=1,j=0;
        while(i<n){
            if(pat.charAt(i) == pat.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }
            else{
                if(j!=0) j = lps[j-1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB"; 
        String pat = "ABABCABAB"; 
        new KMP().kmp_search(txt, pat);
    }
}
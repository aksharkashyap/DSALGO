package STRING_ALGO;

class KMP {
    
    void kmp_search(char[] txt, char[] pat){
        int m = txt.length;
        int n = pat.length;
        int[] lps = new int[n]; //longest suffix which is proper prefix (to hold the index where should we direct the j pointer when mismatch occurs)
        computeLPS(pat, lps,n);

        int i=0,j=0;
        while(i<m){
            if(txt[i] == pat[j]){
                i++; j++;
            }
            if(j==n){
                System.out.println("found pat at index " + (i-j));
                j = lps[j-1]; //point j to the next valid start 
            }
            else if(i<m &&txt[i] != pat[j]){
                if(j!=0) j = lps[j-1];
                else i = i +1;
            }
        }
    }

    void computeLPS(char[] pat, int[]lps, int n){
        lps[0] = 0;
        int i=1,j=0;
        while(i<n){
            if(pat[i] == pat[j]){
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
        String txt = "41234123"; 
        String pat = "1234"; 
        new KMP().kmp_search(txt.toCharArray(), pat.toCharArray());
    }
}
package DP.EditDistance;

class ScramebleString {
    //from top to bottom breakdown of tree
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if(s1.equals(s2)) return true;
        int[] freq = new int[26];
        for(int i=0;i<n;i++){
            freq[s1.charAt(i)-97]++;
            freq[s2.charAt(i)-97]--;
        }
        for(int k=0;k<26;k++) if(freq[k] != 0) return false;
      
        for(int i=1;i<n;i++){
          //no swapping
          if(isScramble(s1.substring(0,i),s2.substring(0,i)) 
                && isScramble(s1.substring(i),s2.substring(i))) return true;
        
          //swapping        //from front   //from back (because we need equal length string)
         if(isScramble(s1.substring(0, i), s2.substring(n - i))
            && isScramble(s1.substring(i), s2.substring(0, n - i))) return true;
        }
        return false;
    }
}
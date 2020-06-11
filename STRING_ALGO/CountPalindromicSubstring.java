package STRING_ALGO;
/**
* Given a string, your task is to count how many palindromic substrings in this string.
* The substrings with different start indexes or end indexes are counted as 
different substrings even they consist of same characters.
 */

//o(n^2)
public class CountPalindromicSubstring {
        int ans = 0;
        public int countSubstrings(String s) {
            if(s == null || s.length() < 1) return 0;
            char[] str = s.toCharArray();
            int n = str.length;
            
            for(int i=0;i<n;i++){
                expandCentre(str,n,i,i); //to handle odd length
                expandCentre(str,n,i,i+1); //to handle even length
            }
            return ans;
        }
        
        void expandCentre(char[]str,int n,int i, int j){  // expand from centre
            while(i >=0 && j<n){
                if(str[i--]!=str[j++]) return;
                ans++;
            }
        }
}
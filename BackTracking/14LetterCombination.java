package BackTracking;

import java.util.ArrayList;

/** https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 */
class LetterComb{
        int len;
        ArrayList<String> ans = new ArrayList<>();
        
        void solve(String[] str,int idx, StringBuilder sb){
            if(idx == len){
                ans.add(sb.toString()); //add string to answer
                return;
            }
            String s = str[idx];
            for(int i=0;i<s.length();i++){
                sb.append(s.charAt(i));
                solve(str,idx+1,sb);
                sb.setLength(sb.length()-1);
            }
        }
        
        public ArrayList<String> letterCombinations(String digits) {
            len = digits.length();
            if(len == 0) return ans;
            
            String letters[] = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            String str[] = new String[len];
            
            int k=0; for(int i=0;i<len;i++){
                int idx = Integer.parseInt(String.valueOf(digits.charAt(i))) - 2;
                str[k++] = letters[idx];
            }
            
            solve(str,0,new StringBuilder(""));
            return ans;
        }
}
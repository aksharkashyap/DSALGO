package Recursion;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int bL,bR;
        bL=bR=0; 
        //bL -> amount of remaining open brackets to be removed
        //bR -> amount of remaining closed brackets to be removed
        
        //PreCalculate  bL and bR to get the "minimum removed valid string"
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') bL++;
            else if(s.charAt(i)==')'){
                if(bL>0) bL--;
                else bR++;
            }
        }
        Set<String> res = new HashSet<>();
        solve(s,res,new StringBuilder(),bL,bR,0,0);
        return new ArrayList<>(res);
    }
    
    void solve(String s, Set<String> res, StringBuilder sb, int bL, int bR,int pL, int idx){
        
        if(idx == s.length() || bL<0 || bR<0 || pL<0){
            if(bL==0 && bR==0 && pL==0) res.add(sb.toString());
            return;
        }
        
        if(s.charAt(idx) == '('){
            solve(s,res,sb,bL-1,bR,pL,idx+1); //consider '(' removing it
            sb.append(s.charAt(idx));
            solve(s,res,sb,bL,bR,pL+1,idx+1); //dont consider '(' removing it
        }
        else if(s.charAt(idx) == ')'){
            solve(s,res,sb,bL,bR-1,pL,idx+1); //consider ')' removing it
            sb.append(s.charAt(idx));
            solve(s,res,sb,bL,bR,pL-1,idx+1);  // don't consider ')' removing it
        }
        else{
            sb.append(s.charAt(idx));
            solve(s,res,sb,bL,bR,pL,idx+1);
        }
        sb.setLength(sb.length()-1); //backtrack
    }
    //pL -> amount of open paranthesis that need to be closed
}
/*
Problem link -> https://leetcode.com/problems/remove-invalid-parentheses/

Inspired by the following article
https://leetcode.com/problems/remove-invalid-parentheses/discuss/75038/Evolve-from-intuitive-solution-to-optimal-a-review-of-all-solutions

*/
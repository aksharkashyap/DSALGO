package BackTracking;

import java.util.ArrayDeque;

//brute force(fails where input size is large)
class RemoveKDigit {
    int max  = Integer.MAX_VALUE, temp;
    String str,ans;
    
    void solve(StringBuilder sb, int k){
        
        if(k==0){
            str = sb.toString();
            temp = Integer.parseInt(str);
            if(max > temp){
                max = temp;
                ans = str;
               
            }
            return;
        }
        
        for(int i=0;i<sb.length();i++){
            char x = sb.charAt(i);
            sb.deleteCharAt(i);
            solve(sb,k-1);
            sb.insert(i,x);
        }
    }
    
    public String removeKdigits(String num, int k) {
        solve(new StringBuilder(num),k);
        return ans;
    }
}


//greedy / stack

class RemoveKDigit2 {
    
    public String removeKdigits(String num, int k) {
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i=0;i<num.length();i++){
            if(stack.size() < 1 && num.charAt(i) !='0') stack.push(num.charAt(i));
            else{
               while (stack.size()>0 && k > 0 && stack.peek() > num.charAt(i)){
                   stack.pop();
                   k--;
               }
              if(stack.size()==0 && num.charAt(i) =='0') continue;
              stack.push(num.charAt(i));
            }
        }
       
       while(stack.size()>0 && k-- > 0) stack.pop();
       if(stack.size()==0) return "0";
       StringBuilder sb = new StringBuilder();
       while(stack.size()>0) sb.append(stack.pop());
       sb.reverse();
       return sb.toString();
    }
}
package STRING_ALGO;
import java.util.HashMap;

class RomanToInteger {
    HashMap<Character,Integer> map = new HashMap<>();
    
    int solve(String s, int n){
        int num = map.get(s.charAt(n-1));
        char prev = s.charAt(n-1);
        char curr = '\0';
      
        for(int i=n-2;i>=0;i--){
            curr = s.charAt(i);
            if(prev == curr || map.get(curr) > map.get(prev)) num += map.get(curr);
            else num -= map.get(curr);
            prev = curr;
        }
        return num;
    }
    
    public int romanToInt(String s){
        char[] SYMBOLE = {'I','V','X','L','C','D','M'};
        int[] SYMBOLE_NUM = {1,5,10,50,100,500,1000};
        for(int i=0;i<SYMBOLE.length;i++) map.put(SYMBOLE[i],SYMBOLE_NUM[i]);
        if(map.containsKey(s)) return map.get(s);
        return solve(s,s.length());
    }
}
//https://leetcode.com/problems/roman-to-integer/
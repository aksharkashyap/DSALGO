package DP.EditDistance;

import java.util.HashMap;

class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        
        if(p.length()==0) return s.length()==0; // base case are we finished with the letters?
        
        if(p.length()>1 && p.charAt(1)=='*'){
            if(isMatch(s,p.substring(2))){ //0 repeat
                return true; 
            }
             //1 or more than 1 repeat
            if(s.length()>0 && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)))
                return isMatch(s.substring(1),p);
        }
        else{
            if(s.length()>0 && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)))
                return isMatch(s.substring(1),p.substring(1)); //both match
        }
        
        return false;
    }
}

//memoization
class RegularExpressionMatching2 {
    HashMap<String,Boolean> map = new HashMap<>();
    
    public boolean isMatch(String s, String p) {
        
        if(p.length()==0) return s.length()==0; // base case are we finished with the letters?
        
        String key = s+"#"+p;
        
        if(map.containsKey(key)) return map.get(key);
        
        Boolean result=false;
        
        if(p.length()>1 && p.charAt(1)=='*'){
            if(isMatch(s,p.substring(2))){ //0 repeat
                map.put(key,true);
                return true;
            }
             //1 or more than 1 repeat
            if(s.length()>0 && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)))
                result = isMatch(s.substring(1),p);
        }
        else{
            if(s.length()>0 && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)))
                result = isMatch(s.substring(1),p.substring(1)); //both match
        }
        map.put(key,result);
        return result;
    }
}


package SlidingWindow;
import java.util.*;

//brute force optimized
class MinWinSub{
    public String minWindow(String s, String t) {
      if(s.length() < t.length() || s.length()==0 || t.length()==0) return "";
      int temp_total;
      int count[] = new int[128];
      int start=0,end=0;
      int len=s.length()+2;
        
      for(int i=0;i<t.length();i++) count[t.charAt(i)]++;
    
      for(int i=0;i<s.length();i++){
          int temp_count[] = Arrays.copyOf(count,128);
          temp_total = t.length();
          if(temp_count[s.charAt(i)]==0) continue;
          if(s.length()-i < t.length()) break;
          for(int j=i;j<s.length();j++){
              if(temp_count[s.charAt(j)] != 0){
                  temp_count[s.charAt(j)]--;
                  temp_total--;
              }
              if(temp_total==0){
                  if((j-i+1) < len){
                    start = i;
                    end = j;
                    len = j-i+1;
                  }
                  break;
              }
          }
      }
        return len == s.length()+2 ? "" : s.substring(start,end+1);
    }
}


/* sliding window
1. Use two pointers: start and end to represent a window.
2. Move end to find a valid window.
3. When a valid window is found, move start to find a smaller window. */
package DP.Other;
class LongestHappyString {
        String maxstr="";
        StringBuilder sb = new StringBuilder("");
        
        boolean isFine(int arr[],char[]chars,int i){
            if(sb.length()<2 || sb.charAt(sb.length()-1) != chars[i]) return true;
            int j=sb.length()-1;
            if(sb.charAt(j) != sb.charAt(j-1)) return true;
            return false;
        }
        
        void solve(int a,int b,int c,char[] chars){
          
            int arr[] = {a,b,c};
            for(int i=0;i<3;i++){
                if(arr[i]<=0 || ! isFine(arr,chars,i)) continue;
                sb.append(chars[i]);
                int j,k,m; j=k=m=0;
                if(i==0) j=1; if(i==1) k=1; if(i==2) m=1;
                solve(a-j,b-k,c-m,chars);
                if(maxstr.length()<sb.length()) maxstr = sb.toString();
                sb.setLength(sb.length()-1);
            }
            
        }
        
        public String longestDiverseString(int a, int b, int c) {
            char chars[] = {'a','b','c'};
            solve(a,b,c,chars);
            return maxstr;
        }
}